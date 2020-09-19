package SWEN502.Testing.Assignment;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class DBInterface {

	private static Connection con;
	private static Statement stmt;
	private static ArrayList<Player> playerlist;
	
	/**
	 * Open the DB connection
	 */
	public boolean openDB(String url, String dbUser, String usrPass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, dbUser, usrPass);
			System.out.println("Connected to database\n");
			return true;

		}
		catch(Exception ex) {
			System.out.println("Error connecting to database\n");
			//ex.printStackTrace();
			return false;
		}
	}

	/**
	 * Close the DB connection
	 */
	public boolean closeDB() {
		try {
			con.close();
			System.out.println("Closed connection to database\n");
			return true;
		}
		catch(Exception ex) {
			System.out.println("Error disconnecting from database\n");
			ex.printStackTrace();
			return false;
		}
	}

	/**
	 * Read all players from the DB and print out
	 */
	public boolean readDatabase() {

		try {
			stmt = con.createStatement();
			String sql = "Select * from players";
			ResultSet rs = stmt.executeQuery(sql);

			Player p;
			//playerlist = new ArrayList<>();
			
			while(rs.next()){
				
				String player_name = rs.getString("players.name");
				int player_age = rs.getInt("players.age");
				String player_club = rs.getString("players.club");
				String player_nation = rs.getString("players.nationality");
				String player_pos = rs.getString("players.position");
				double player_val = rs.getDouble("players.market_value");
				
				System.out.println("ID: " + rs.getInt("players.id"));
				System.out.println("Name: " + player_name);
				System.out.println("Age: " + player_age);
				System.out.println("Club: " + player_club);
				System.out.println("Nation: " + player_nation);
				System.out.println("Position: " + player_pos);
				System.out.println("Market value: £" + player_val+"M\n");
				
				p = new Player(player_name, player_age, player_club, player_nation, player_pos, player_val);
				if(!playerlist.contains(p))
					playerlist.add(p);
				
			}
			rs.close();
			stmt.close();
			return true;
		}
		catch(Exception ex) {
			System.out.println("Error reading from database\n");
			ex.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Player> getPlayers(){
		return playerlist;
	}
	
	/**
	 * Delete all players from the database
	 */
	public boolean truncatePlayerTable() {
		
		try {
			stmt = con.createStatement();
			String sql = "truncate table players;";
			int rs = stmt.executeUpdate(sql);
			stmt.close();
			
			System.out.println("Players successfully deleted from database\n");
			return true;
		}
		catch(Exception ex) {
			System.out.println("Error in database\n");
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean clearPlayerList() {
		playerlist.clear();
		System.out.println("DBInterface player list cleared\n");
		return true;
	}
	
	/**
	 * Check if player is already in database
	 */
	public boolean playerExists(Player p) {
		
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
				//System.out.println("Player \'" +p.getName() +"\' found in database\n");
			}
			
			else if(!playerFound) {
				//System.out.println("Player \'"+p.getName() +"\' not found in database\n");
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
	

	private int printPlayerList(ArrayList<Player> players) {
		for(Player p : players) {
			System.out.println(p.toString());
		}
		System.out.println("Number of players in list: "+players.size());
		return players.size();
	}
	

	public boolean saveAll(ArrayList<Player> players) {

		try {

			int count = 0;
			
			for(Player p : players) {

				if(!playerExists(p)) {
					
					System.out.println("Player \'" +p.getName()+ "\' is not in the database; adding\n");
					
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
					
					System.out.println("Player \'" +p.getName()+ "\' is already in the database; skipping\n");
					
				}

			}
			System.out.println("Number of players added: "+count+"\n");

		}

		catch(Exception ex) {
			System.out.println("Error writing to database\n");
			ex.printStackTrace();
			return false;
		}

		return true;
	}


	public DBInterface() {
		try {
			playerlist = new ArrayList<>();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
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
