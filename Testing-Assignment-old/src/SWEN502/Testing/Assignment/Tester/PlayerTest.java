package SWEN502.Testing.Assignment.Tester;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import SWEN502.Testing.Assignment.Player;

class PlayerTest {

	Player test_player;
	String name = "Test Name";
	int age = 0;
	String club = "Test Club";
	String nation = "Test Nation";
	String position = "Test position";
	double value = 0.0;
	
	@Test
	void testPlayer() {
		test_player = new Player(name, age, club, nation, position, value);
		assertNotNull(test_player);
	}

	@Test
	void testGetName() {
		test_player = new Player(name, age, club, nation, position, value);
		assertEquals(name, test_player.getName());
	}

	@Test
	void testGetNation() {
		test_player = new Player(name, age, club, nation, position, value);
		assertEquals(nation, test_player.getNation());
	}
	
	@Test
	void testGetClub() {
		test_player = new Player(name, age, club, nation, position, value);
		assertEquals(club, test_player.getClub());
	}

	@Test
	void testGetAge() {
		test_player = new Player(name, age, club, nation, position, value);
		assertEquals(age, test_player.getAge());
	}

	@Test
	void testGetPosition() {
		test_player = new Player(name, age, club, nation, position, value);
		assertEquals(position, test_player.getPosition());
	}

	@Test
	void testGetMarketValue() {
		test_player = new Player(name, age, club, nation, position, value);
		assertEquals(value, test_player.getMarketValue());
	}

	@Test
	void testToString() {
		test_player = new Player(name, age, club, nation, position, value);
		assertEquals("Name: " + name + "\nNation: " + nation + "\nClub: " + club + "\nAge: " + age + "\nPosition: "
				+ position + "\nMarket value: £"+ value +"M\n", test_player.toString());
	}

}
