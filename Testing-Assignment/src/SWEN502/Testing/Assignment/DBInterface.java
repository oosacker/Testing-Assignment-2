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
			System.out.println("Connected to database: " +url);

		}
		catch(Exception ex) {
			System.out.println("Error connecting to database: " +url);
			ex.printStackTrace();
		}
	}

	/**
	 * Close the DB connection
	 */
	public void closeDB() {
		try {
			con.close();
			System.out.println("Closed connection to database");
		}
		catch(Exception ex) {
			System.out.println("Error disconnecting from database");
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
				System.out.print("\n");
				System.out.println("ID: " + rs.getInt("players.id"));
				System.out.println("Name: " + rs.getString("players.name"));
				System.out.println("Age: " + rs.getInt("players.age"));
				System.out.println("Club: " + rs.getString("players.club"));
				System.out.println("Nation: " + rs.getString("players.nationality"));
				System.out.println("Position: " + rs.getString("players.position"));
				System.out.println("Market value: £" + rs.getDouble("players.market_value")+"M");
				System.out.print("\n");
			}
			rs.close();
			stmt.close();
		}
		catch(Exception ex) {
			System.out.println("Error reading from database");
			ex.printStackTrace();
		}
	}

	public void deletePlayer() {

	}

	public DBInterface() {

		//openDB();

		//ArrayList<Player> players = new ArrayList<>();
		// String name, String nation, String club, int age, String position, double market_value
		//players.add( new Player( "bob", "bobs burgers", "USA", 12345, "GK", 12.0 ) );

		//saveToDB(players);

		//readDB();

		//closeDB();


	}


	public Boolean saveToDB(ArrayList<Player> players) {

		try {

			for(Player p : players) {

				stmt = con.createStatement();

				String query = "INSERT INTO `nats`.`players` (`name`, `age`, `club`, `nationality`, `position`, `market_value`)"
						+ " values (?, ?, ?, ?, ?, ?)";

				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				preparedStmt.setString	( 1, p.getName()		);
				preparedStmt.setInt		( 2, p.getAge()			);
				preparedStmt.setString	( 3, p.getClub()		);
				preparedStmt.setString	( 4, p.getNation()		);
				preparedStmt.setString	( 5, p.getPosition()	);
				preparedStmt.setDouble	( 6, p.getMarketValue()	);
				preparedStmt.execute();

				stmt.close();

			}

		}

		catch(Exception ex) {
			System.out.println("Error writing to database");
			ex.printStackTrace();
		}

		return true;
	}


	public static void main(String[] args) {
		new DBInterface();
	}

} 
