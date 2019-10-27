package SWEN502.Testing.Assignment.Tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized.Parameters;

import SWEN502.Testing.Assignment.DBInterface;
import SWEN502.Testing.Assignment.Player;

/**
 * Class assumes that the data in database is correct!!!
 * @author Natsuki
 *
 */

class DBInterfaceTest {

	DBInterface dbi;
	
	Player testPlayer;
	boolean playerExists;
	
	@BeforeEach
	void init() {
		dbi = new DBInterface();
	}
	
	
	@Test
	void testOpenDB() {
		assertFalse(dbi.openDB("test", "test", "test"));	// invalid login details should fail
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
		assertEquals(461, dbi.readDatabase());
		assertTrue(dbi.closeDB());
	}

	@Test
	void testGetPlayers() {
		assertTrue(dbi.openDB("jdbc:mysql://localhost/nats", "newuser", "1234"));
		assertEquals(461, dbi.readDatabase());
		ArrayList<Player> playerlist = dbi.getPlayers();
		assertEquals(461, playerlist.size());
		assertTrue(dbi.closeDB());
	}
	
	// do not test this method here, requires modification of database; see OverallTester.java
//	@Test
//	void testTruncatePlayerTable() {
//		
//	}

	@Test
	void testClearPlayerList() {
		assertTrue(dbi.openDB("jdbc:mysql://localhost/nats", "newuser", "1234"));
		assertEquals(461, dbi.readDatabase());
		assertTrue(dbi.clearPlayerList());
		assertEquals(0, dbi.getPlayers().size());
		assertTrue(dbi.closeDB());
	}

	
	@Parameters 
	static Collection<Object[]> testPlayers(){
		System.out.println("Generating test cases with players\n");
		return Arrays.asList(new Object[][] {
			{ new Player("Alexis Sanchez", 28, "Arsenal", "Chile", "LW", 65.0), true },
			{ new Player("", 0, "", "", "", 0.0), false },
			{ new Player("Homer Simpson", 40, "Springfield Nuclear Power Plant", "USA", "Dad", -100), false },
			{ new Player("Lewis Cook", 20, "Bournemouth", "England", "CM", 6), true}
		});
	}
	
	@ParameterizedTest
	@MethodSource("testPlayers")
	void testPlayerExistsPlayer (Player testPlayer, boolean validPlayer) {
		assertTrue(dbi.openDB("jdbc:mysql://localhost/nats", "newuser", "1234"));
		
		assertEquals(validPlayer, dbi.playerExists(testPlayer));
		
		assertTrue(dbi.closeDB());
	}


	// do not test this method here, requires modification of database; see OverallTester.java
//	@Test
//	void testSaveAll() {
//		// 
//	}



}
