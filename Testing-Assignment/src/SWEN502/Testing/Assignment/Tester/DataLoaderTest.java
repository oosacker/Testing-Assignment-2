package SWEN502.Testing.Assignment.Tester;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized.Parameters;
import SWEN502.Testing.Assignment.DataLoader;


class DataLoaderTest {
	
	DataLoader dl;
	int expectedNum;
	String XMLFile;
	
	@BeforeEach
	void init() {
		dl = new DataLoader();
	}
	
	@Parameters 
	static Collection<Object[]> goodXMLFiles(){
		System.out.println("Generating test cases with valid xml files\n");
		return Arrays.asList(new Object[][] {
			{ "smallList3.xml", 3 },	// test xml file with 3 players
			{ "smallList5.xml", 5 },	// test xml file with 5 players
			{ "smallList150.xml", 150 },	// test xml file with 150 players
		});
	}
	
	@ParameterizedTest
	@MethodSource("goodXMLFiles")
	void testLoadValidXMLData(String XMLFile, int expectedNum ) {
		assertEquals(expectedNum, dl.loadXMLData(XMLFile));
	}
	
	@Parameters
	static Collection<Object[]> badXMLFiles(){
		System.out.println("Generating test cases with invalid xml files\n");
		return Arrays.asList(new Object[][] {
			{ "missing_file.xml", -1 },	// test with missing file 
			{ "", -1 },					// test with invalid file name
			{ null, -1 },				// test with invalid file name
			{ "badXMLFile1.xml", 1 },	// test with one player and 2 damaged tags 
			{ "badXMLFile2.xml", 4 },	// test with 4 players and 4 damaged tags
			{ "badXMLFile3.xml", 461 },	// file with 461 players and one damaged tag
		});
	}
	
	@ParameterizedTest
	@MethodSource("badXMLFiles")
	void testLoadInvalidXMLData(String XMLFile, int expectedNum ) {
		assertEquals(expectedNum, dl.loadXMLData(XMLFile));
	}



	@Test
	void testFilterPlayers() {
		assertEquals(461, dl.loadXMLData("premierLeaguePlayerNames.xml"));
		
		assertEquals(0, dl.findByName(null));
		assertEquals(0, dl.findByName(""));
		assertEquals(1, dl.findByName("Alexis Sanchez"));
		
		assertEquals(0, dl.findByAge(-1));
		assertEquals(3, dl.findByAge(18));
		
		assertEquals(0, dl.findByClub(null));
		assertEquals(0, dl.findByClub(""));
		assertEquals(24, dl.findByClub("Bournemouth"));
		
		assertEquals(0, dl.findByPosition(null));
		assertEquals(0, dl.findByPosition(""));
		assertEquals(17, dl.findByPosition("AM"));
		
		assertEquals(0, dl.findByMarketVal(-1));
		assertEquals(4, dl.findByMarketVal(50));
		
	}


}
