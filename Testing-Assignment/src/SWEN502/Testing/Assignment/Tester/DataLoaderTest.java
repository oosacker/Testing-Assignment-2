package SWEN502.Testing.Assignment.Tester;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized.Parameters;

import SWEN502.Testing.Assignment.DataLoader;
//import SWEN502.Testing.Assignment.Player;
import SWEN502.Testing.Assignment.Player;

class DataLoaderTest {
	
	DataLoader dl;
	int expectedNum;
	String XMLFile;
	
	@BeforeEach
	void init() {
		dl = new DataLoader();
		ArrayList<Player> playerlist = new ArrayList<>();
	}
	
	@Parameters (name = "{index}: loadXMLData({0}) = {1}")
	static Collection<Object[]> goodXMLFiles(){
		System.out.println("Generating test cases with valid xml files\n");
		return Arrays.asList(new Object[][] {
			{ "missing_file.xml", -1 },	// test with missing file 
			{ "smallList3.xml", 3 },
			{ "smallList5.xml", 5 },
			{ "smallList150.xml", 150 },
		});
	}
	
	@ParameterizedTest
	@MethodSource("goodXMLFiles")
	void testLoadValidXMLData(String XMLFile, int expectedNum ) {
		assertEquals(expectedNum, dl.loadXMLData(XMLFile));
	}
	
	@Parameters (name = "{index}: loadXMLData({0}) = {1}")
	static Collection<Object[]> badXMLFiles(){
		System.out.println("Generating test cases with invalid xml files\n");
		return Arrays.asList(new Object[][] {
			{ "missing_file.xml", -1 },	// test with missing file 
			{ "badXMLFile1.xml", 1 },	// test with one player and one damaged tag 
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
		
		assertEquals(1, dl.findByName("Alexis Sanchez"));
		assertEquals(3, dl.findByAge(18));
		assertEquals(24, dl.findByClub("Bournemouth"));
		assertEquals(17, dl.findByPosition("AM"));
		assertEquals(4, dl.findByMarketVal(50));
		
	}


}
