package SWEN502.Testing.Assignment.Tester;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import SWEN502.Testing.Assignment.DataLoader;
import SWEN502.Testing.Assignment.Player;

class DataLoaderTest {

	DataLoader dl = new DataLoader();
	private ArrayList<Player> playerlist = new ArrayList<>();
	
	
	
	@Test
	void testLoadXMLData() {
		fail("Not yet implemented");
	}

//	@Test
//	void testSaveNewXML() {
//		fail("Not yet implemented");
//	}

	@Test
	void testPrintAll() {
		//assertEquals(i+j, math.add(i, j));
	}

	@Test
	void testFilterPlayers() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPlayerList() {
		assertNotNull(dl.getPlayerList());
	}

	@Test
	void testAddPlayer() {
		fail("Not yet implemented");
	}

	@AfterAll
	void finish() {
		
	}

}
