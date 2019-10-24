package SWEN502.Testing.Assignment;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class DBInterface {

	private Connection con;
	private String url = "jdbc:mysql://localhost/nats";
	private String dbUser = "newuser";	// do not use root!!!!!
	private String usrPass = "1234";
	private Statement stmt;

	/**
	 * Open the DB connection
	 */
	public void openDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, dbUser, usrPass);
			System.out.println("Connected to database\n");

		}
		catch(Exception ex) {
			System.out.println("Error connecting to database\n");
			ex.printStackTrace();
		}
	}

	/**
	 * Close the DB connection
	 */
	public void closeDB() {
		try {
			con.close();
			System.out.println("Closed connection to database\n");
		}
		catch(Exception ex) {
			System.out.println("Error disconnecting from database\n");
			ex.printStackTrace();
		}
	}

	/**
	 * Read all players from the DB and print out
	 */
	public void readDB() {

		try {
			stmt = con.createStatement();
			String sql = "Select * from players";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				System.out.println("ID: " + rs.getInt("players.id"));
				System.out.println("Name: " + rs.getString("players.name"));
				System.out.println("Age: " + rs.getInt("players.age"));
				System.out.println("Club: " + rs.getString("players.club"));
				System.out.println("Nation: " + rs.getString("players.nationality"));
				System.out.println("Position: " + rs.getString("players.position"));
				System.out.println("Market value: £" + rs.getDouble("players.market_value")+"M\n");
			}
			rs.close();
			stmt.close();
		}
		catch(Exception ex) {
			System.out.println("Error reading from database\n");
			ex.printStackTrace();
		}
	}
	
	/**
	 * Delete all players from the database
	 */
	public void deleteAllPlayers() {
		
		try {
			stmt = con.createStatement();
			String sql = "truncate table players;";
			int rs = stmt.executeUpdate(sql);
			stmt.close();
			
			System.out.println("Players successfully deleted from database\n");
		}
		catch(Exception ex) {
			System.out.println("Error in database\n");
			ex.printStackTrace();
		}
	}
	
	public ArrayList<Player> findPlayersByClub(String clubName){
		
		try {
			ArrayList<Player> foundPlayers = new ArrayList<>();
			stmt = con.createStatement();
			String sql = "Select * from players where players.club='"+clubName+"'";
			System.out.println(sql + "\n");
			
			Boolean playersFound = false;
			Player foundPlayer;
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				playersFound = true;
				

				int player_id = rs.getInt("players.id");
				String player_name = rs.getString("players.name");
				int player_age = rs.getInt("players.age");
				String player_club = rs.getString("players.club");
				String player_nation = rs.getString("players.nationality");
				String player_pos = rs.getString("players.position");
				double player_val = rs.getDouble("players.market_value");
				
				////`name`, `age`, `club`, `nationality`, `position`, `market_value`)"
				foundPlayer = new Player(player_name, player_age, player_club, player_nation, player_pos, player_val);
				foundPlayers.add(foundPlayer);
				
			}
			
			if(!playersFound) {
				System.out.println("Player(s) not found in database\n");
			}
			
			rs.close();
			stmt.close();
			
			return foundPlayers;
			
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}
	
	
	
	public ArrayList<Player> findPlayersByNation(String nation){
		
		try {
			ArrayList<Player> foundPlayers = new ArrayList<>();
			stmt = con.createStatement();
			String sql = "Select * from players where players.nationality='"+nation+"'";
			System.out.println(sql + "\n");
			
			Boolean playersFound = false;
			Player foundPlayer;
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				playersFound = true;
				

				int player_id = rs.getInt("players.id");
				String player_name = rs.getString("players.name");
				int player_age = rs.getInt("players.age");
				String player_club = rs.getString("players.club");
				String player_nation = rs.getString("players.nationality");
				String player_pos = rs.getString("players.position");
				double player_val = rs.getDouble("players.market_value");
						
				////`name`, `age`, `club`, `nationality`, `position`, `market_value`)"
				foundPlayer = new Player(player_name, player_age, player_club, player_nation, player_pos, player_val);
				foundPlayers.add(foundPlayer);
				
			}
			
			if(!playersFound) {
				System.out.println("Player(s) not found in database\n");
			}
			
			rs.close();
			stmt.close();
			
			return foundPlayers;
			
		}
		
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}
	
	
	
	private void printPlayerList(ArrayList<Player> players) {
		for(Player p : players) {
			System.out.println(p.toString());
		}
	}
	
	/**
	 * Find player by name
	 * @param name
	 * @return
	 */
	public Player findPlayerByName(String name) {
		
		try {
			stmt = con.createStatement();
			String sql = "Select * from players where players.name='"+name+"'";
			System.out.println(sql + "\n");
			
			Boolean playerFound = false;
			//Player foundPlayer;
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				playerFound = true;
				

				int player_id = rs.getInt("players.id");
				String player_name = rs.getString("players.name");
				int player_age = rs.getInt("players.age");
				String player_club = rs.getString("players.club");
				String player_nation = rs.getString("players.nationality");
				String player_pos = rs.getString("players.position");
				double player_val = rs.getDouble("players.market_value");
				
				System.out.println("ID: " + player_id);
				System.out.println("Name: " + player_name);
				System.out.println("Age: " + player_age);
				System.out.println("Club: " + player_club);
				System.out.println("Nation: " + player_nation);
				System.out.println("Position: " + player_pos);
				System.out.println("Market value: £" + player_val+"M\n");
				
				//foundPlayer = new Player();
				
			}
			
			if(!playerFound) {
				System.out.println("Player named *" +name+ "* not found in database\n");
			}
			
			rs.close();
			stmt.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

	public void deletePlayer() {

	}




	public Boolean saveToDB(ArrayList<Player> players) {

		try {

			for(Player p : players) {

				stmt = con.createStatement();

				String query = "INSERT INTO `nats`.`players` (`name`, `age`, `club`, `nationality`, `position`, `market_value`)"
						+ " values (?, ?, ?, ?, ?, ?)";

				PreparedStatement prep = con.prepareStatement(query);
				
				prep.setString(1, p.getName());
				prep.setInt(2, p.getAge());
				prep.setString(3, p.getClub());
				prep.setString(4, p.getNation());
				prep.setString(5, p.getPosition());
				prep.setDouble(6, p.getMarketValue());
				prep.execute();

				stmt.close();

			}

		}

		catch(Exception ex) {
			System.out.println("Error writing to database");
			ex.printStackTrace();
		}

		return true;
	}


	public DBInterface() {

		//openDB();

		//printPlayerList(findPlayersByClub("Arsenal"));
		
		//printPlayerList(findPlayersByNation("England"));
		
		//findPlayerByName("Ass Walcott");
		
		//saveToDB(players);
		
		//deleteAllPlayers();
		
		//ArrayList<Player> players = new ArrayList<>();
		// String name, String nation, String club, int age, String position, double market_value
		//players.add( new Player( "bob", "bobs burgers", "USA", 12345, "GK", 12.0 ) );

		//saveToDB(players);

		//readDB();

		//closeDB();


	}
	
	public static void main(String[] args) {
		new DBInterface();
	}

} 
