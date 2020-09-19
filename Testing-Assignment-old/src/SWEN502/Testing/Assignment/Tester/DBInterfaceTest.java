package SWEN502.Testing.Assignment.Tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import SWEN502.Testing.Assignment.DBInterface;
import SWEN502.Testing.Assignment.Player;

class DBInterfaceTest {

	DBInterface dbi = new DBInterface();
	
	@Test
	void testOpenDB() {
		assertFalse(dbi.openDB("test", "test", "test"));
		assertTrue(dbi.openDB("jdbc:mysql://localhost/nats", "newuser", "1234"));
		assertTrue(dbi.closeDB());
	}

	@Test
	void testCloseDB() {
		assertTrue(dbi.openDB("jdbc:mysql://localhost/nats", "newuser", "1234"));
		assertTrue(dbi.closeDB());
	}

	@Test
	void testReadDatabase() {
		assertTrue(dbi.openDB("jdbc:mysql://localhost/nats", "newuser", "1234"));
		assertTrue(dbi.readDatabase());
		assertTrue(dbi.closeDB());
	}

	@Test
	void testGetPlayers() {
		assertTrue(dbi.openDB("jdbc:mysql://localhost/nats", "newuser", "1234"));
		assertTrue(dbi.readDatabase());
		ArrayList<Player> playerlist = dbi.getPlayers();
		assertEquals(461, playerlist.size());
		assertTrue(dbi.closeDB());
	}
	
//	@Test
//	void testTruncatePlayerTable() {
//		int database_size = 0;
//		assertTrue(dbi.openDB("jdbc:mysql://localhost/nats", "newuser", "1234"));
//		assertTrue(dbi.readDatabase());
//		ArrayList<Player> playerlist = dbi.getPlayers();
//		assertEquals(database_size, playerlist.size());
//		assertTrue(dbi.closeDB());
//	}

	@Test
	void testClearPlayerList() {
		assertTrue(dbi.openDB("jdbc:mysql://localhost/nats", "newuser", "1234"));
		assertTrue(dbi.readDatabase());
		assertTrue(dbi.clearPlayerList());
		assertEquals(0, dbi.getPlayers().size());
		assertTrue(dbi.closeDB());
	}

	@Test
	void testPlayerExists() {
		assertTrue(dbi.openDB("jdbc:mysql://localhost/nats", "newuser", "1234"));
		
		Player invalid_player = new Player("", 0, "", "", "", 0.0);
		assertFalse(dbi.playerExists(invalid_player));
		
		Player valid_player = new Player("Alexis Sanchez", 28, "Arsenal", "Chile", "LW", 65.0);
		assertTrue(dbi.playerExists(valid_player));
		
		assertTrue(dbi.closeDB());
	}


//	@Test
//	void testSaveAll() {
//		fail("Not yet implemented");
//	}



}
