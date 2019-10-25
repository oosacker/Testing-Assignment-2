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
	public void readDatabase() {

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
	
	/**
	 * Check if player is already in database
	 */
	public Boolean playerExists(Player p) {
		
		try {

			Boolean playerFound = false;
			
			stmt = con.createStatement();
			
			String sql = "Select * from players where "
			+ "players.name=? and "
			+ "players.age=? and "
			+ "players.club=? and "
			+ "players.nationality=? and "
			+ "players.position=? and "
			+ "players.market_value=?;";

			PreparedStatement prep = con.prepareStatement(sql);
			
			prep.setString(1, p.getName());
			prep.setInt(2, p.getAge());
			prep.setString(3, p.getClub());
			prep.setString(4, p.getNation());
			prep.setString(5, p.getPosition());
			prep.setDouble(6, p.getMarketValue());
			
			ResultSet rs = prep.executeQuery();
			
			if(rs.next()){
				playerFound = true;
				System.out.println("Player *" +p.getName() +"* found in database\n");
			}
			
			else if(!playerFound) {
				System.out.println("Player not found in database\n");
			}
			
			rs.close();
			stmt.close();
			
			return playerFound;

		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	

	private void printPlayerList(ArrayList<Player> players) {
		for(Player p : players) {
			System.out.println(p.toString());
		}
		System.out.println("Number of players in list: "+players.size());
	}
	

	public void deletePlayer(Player p) {
		if(!playerExists(p)) {
			return;
		}
		else {
			//  remove
		}
	}

	public Boolean saveAll(ArrayList<Player> players) {

		try {

			int count = 0;
			
			for(Player p : players) {

				if(!playerExists(p)) {
					
					System.out.println("Player " +p.getName()+ " is not in the database; adding\n");
					
					count++;
					
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
				
				else {
					
					System.out.println("Player " +p.getName()+ " is already in the database; skipping\n");
					
				}

			}
			System.out.println("Number of players added: "+count);

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
