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
	public String inputXMLFile;
	
	@BeforeEach
	void init() {
		dl = new DataLoader();
	}
	
	@Parameters
	static Collection<Object[]> XMLFiles(){
		System.out.println("Generate XML test cases");
		return Arrays.asList(new Object[][] {
			{ "premierLeaguePlayerNames.xml", 461 },
			{ "smallList3.xml", 3 },
			{ "smallList5.xml", 5 },
		});
	}
	
	@ParameterizedTest
	@MethodSource("XMLFiles")
	void testLoadXMLData(String inputXMLFile, int expectedNum ) {
		assertEquals(expectedNum, dl.loadXMLData(inputXMLFile));
	}

//	@Test
//	void testSaveNewXML() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testPrintAll() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFilterPlayers() {
//		fail("Not yet implemented");
//	}
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
