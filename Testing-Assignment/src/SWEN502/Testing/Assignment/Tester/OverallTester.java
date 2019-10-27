package SWEN502.Testing.Assignment.Tester;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.assertEquals;
import SWEN502.Testing.Assignment.DBInterface;
import SWEN502.Testing.Assignment.Player;
import SWEN502.Testing.Assignment.DataLoader;

class OverallTester {

	
	DataLoader dl;
	int expectedNum;
	String XMLFile;
	DBInterface dbi;
	ArrayList<Player> playerlist1, playerlist2;
	
	@BeforeEach
	void init() {
		dbi = new DBInterface();
		dl = new DataLoader();
		playerlist1 = new ArrayList<>();
		playerlist2 = new ArrayList<>();
	}
	
	@Test
	void overallTest() {

		// read the xml file with 461 players
		assertEquals(461, dl.loadXMLData("premierLeaguePlayerNames.xml"));
		playerlist1 = dl.getPlayerList();
		assertEquals(461, playerlist1.size());
		System.out.println("Loaded 461 players from xml file correctly\n");
		
		// reset the database to 0 players and check
		assertTrue(dbi.openDB("jdbc:mysql://localhost/nats", "newuser", "1234"));
		assertTrue(dbi.truncatePlayerTable());
		assertEquals(0, dbi.readDatabase());
		playerlist2 = dbi.getPlayers();
		assertEquals(0, playerlist2.size());
		assertTrue(dbi.closeDB());
		System.out.println("Database has been reset to 0 correctly\n");
		
		// upload the playerlist1 to the database
		assertTrue(dbi.openDB("jdbc:mysql://localhost/nats", "newuser", "1234"));
		assertEquals(461, dbi.saveAll(playerlist1));
		assertEquals(461, dbi.readDatabase());
		playerlist2 = dbi.getPlayers();
		System.out.println("461 players from xml file uploaded to database correctly\n");
		
		// you cannot compare playerlist1 with playerlist2 here and expect them to be the same!!!
		// Java will consider 2 objects with same data as different instances!!!
		
		
		assertTrue(dbi.closeDB());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
