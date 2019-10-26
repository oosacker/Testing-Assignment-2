package SWEN502.Testing.Assignment.Tester;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized.Parameters;

import SWEN502.Testing.Assignment.DataLoader;
import SWEN502.Testing.Assignment.Player;

class DataLoaderTest {
	
	DataLoader dl;
	
	private ArrayList<Player> playerlist = new ArrayList<>();
	
	public int expectedNum;
	public String XMLFile;
	
	@BeforeEach
	void init() {
		dl = new DataLoader();
	}
	
	@Parameters (name = "{index}: loadXMLData({0}) = {1}")
	static Collection<Object[]> goodXMLFiles(){
		System.out.println("Generating test cases with valid xml files\n");
		return Arrays.asList(new Object[][] {
			{ "smallList3.xml", 3 },
			{ "smallList5.xml", 5 },
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
			{ "badXMLFile1.xml", 1 },
			{ "badXMLFile2.xml", 4 },
		});
	}
	
	@ParameterizedTest
	@MethodSource("badXMLFiles")
	void testLoadInvalidXMLData(String XMLFile, int expectedNum ) {
		assertEquals(expectedNum, dl.loadXMLData(XMLFile));
	}


//	@Test
//	void testPrintAll() {
//		fail("Not yet implemented");
//	}
//
	@Test
	void testFilterPlayers() {
		fail("Not yet implemented");
	}
//
//	@Test
//	void testGetPlayerList() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testAddPlayer() {
//		fail("Not yet implemented");
//	}


}
