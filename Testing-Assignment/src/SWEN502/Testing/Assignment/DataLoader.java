package SWEN502.Testing.Assignment;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataLoader {
	
	private static ArrayList<Player> playerlist;

	public void setPlayerList(ArrayList<Player> list) {
		playerlist = list;
	}
	
	public void clearPlayerList() {
		playerlist.clear();
		System.out.println("DataLoader player list cleared\n");
	}
	
	
	public int loadXMLData(String xmlfile) {
	//public int loadXMLData(Scanner scan) {
		
		
		if( xmlfile == null || xmlfile.equals("") ) {
			System.out.println("Invalid file\n");
			return -1;
		}
		
		playerlist = new ArrayList<>();

		System.out.println("Loading \'" +xmlfile+ "\'...\n");

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		Document doc =  null;

		/**
		 * Creates a new instance of a DocumentBuilderusing the currently configured parameters.
		 */
		try {
			db = dbf.newDocumentBuilder();
		}
		catch(ParserConfigurationException ex) {
			System.out.println("ParserConfigurationException\n");
			return -1;
		}


		/**
		 * Parse the content of the given URI as an XML document and return a new DOM Document object.
		 * An IllegalArgumentException is thrown if the URI is null.
		 */
		try {
			doc = db.parse(xmlfile);
		} 
		catch(SAXException ex) {
			System.out.println("SAX error: xml file may be corrupt\n");
			return -1;
		} 
		catch(IOException ex) {
			System.out.println("IO error: xml file may be missing\n");
			return -1;
		} 
		catch(IllegalArgumentException ex) {
			System.out.println("IllegalArgumentException: invalid arguement to parse\n");
			return -1;
		}


		NodeList mylist = doc.getElementsByTagName("row");
		for(int i=0; i<mylist.getLength(); i++) {

			// default values
			String name = "Unknown Player";
			String club = "Unknown Club";
			int age = 0;
			double value = 0.0;
			String pos = "Unknown Position";
			String nation = "Unknown Nationality";
			
			
			Node n = mylist.item(i);
			Element e = (Element)n;


			/**
			 * Check the name tag in the xml
			 */
			try {
				name = e.getElementsByTagName("name").item(0).getTextContent();
			} 
			catch(NullPointerException ex) {
				System.out.println("Error in XML file: name tag is missing; using \'"+name+"\'\n"); 
			}


			/**
			 * Check the club tag in the xml
			 */
			try {
				club = e.getElementsByTagName("club").item(0).getTextContent();
			} 
			catch(NullPointerException ex) {
				System.out.println("Error in XML file: club tag is missing; using \'"+club+"\'\n"); 
			}


			/**
			 * Check the market value tag in the xml -- must also check if it is a number
			 */
			try {
				value =  Double.parseDouble(e.getElementsByTagName("market_value").item(0).getTextContent());
			} 
			catch(NullPointerException ex) {
				System.out.println("Error in XML file: market_value tag is missing; using \'"+value+"\'\n"); 
			} 
			catch(NumberFormatException ex) {
				System.out.println("Error in XML file: market_value value is not a number; using \'"+value+"\'\n"); 
			}


			/**
			 * Check the position tag in the xml
			 */
			try {
				pos = e.getElementsByTagName("position").item(0).getTextContent();
			} 
			catch(NullPointerException ex) {
				System.out.println("Error in XML file: position tag is missing; using \'"+pos+"\'\n"); 
			}


			/**
			 * Check the age tag in the xml -- must also check if it is a number
			 */
			try {
				age = Integer.parseInt(e.getElementsByTagName("age").item(0).getTextContent());
			} 
			catch(NullPointerException ex) {
				System.out.println("Error in XML file: age tag is missing; using \'"+age+"\'\n"); 
			} 
			catch(NumberFormatException ex) {
				System.out.println("Error in XML file: age value is not a number; using \'"+age+"\'\n"); 
			}


			/**
			 * Check the nationality tag in the xml
			 */
			try {
				nation = e.getElementsByTagName("nationality").item(0).getTextContent();
			} 
			catch(NullPointerException ex) {
				System.out.println("Error in XML file: nationality tag is missing; using \'"+nation+"\'\n"); 
			}

			Player newplayer = new Player(name, age, club, nation, pos, value);
			playerlist.add(newplayer);
		}
		
		
		System.out.println("Number of players loaded: "+playerlist.size()+"\n");

		return playerlist.size();

	}
	
	/**
	 * Print all items in the ArrayList
	 */
	public void printAll() {
		
		if(playerlist.isEmpty()) {
			System.out.println("Player list is empty\n");
			return;
		}
			
		for(Player p : playerlist) {
			System.out.println(p.toString());
		}
		System.out.println("Number of players: "+playerlist.size()+"\n");
	}
	
	
	
	/**
	 * Helper methods for the filtering
	 */
	public int findByName(String input) {
		
		if(playerlist.isEmpty()) {
			System.out.println("Player list is empty; nothing to filter");
			return -1;
		}
		
		int count = 0;
		for(Player p : playerlist) {
			if (p.getName().equalsIgnoreCase(input)) {
				System.out.println(p.toString());
				count++;
			}
		}
		System.out.println("Number of players found: "+count+"\n");
		return count;
	}
	
	public int findByAge(int age) {
		
		if(playerlist.isEmpty()) {
			System.out.println("Player list is empty; nothing to filter");
			return -1;
		}
		
		int count = 0;
		for(Player p : playerlist) {
			if (p.getAge() == age) {
				System.out.println(p.toString());
				count++;
			}
		}
		System.out.println("Number of players found: "+count+"\n");
		return count;
	}
	
	public int findByClub(String input) {
		
		if(playerlist.isEmpty()) {
			System.out.println("Player list is empty; nothing to filter");
			return -1;
		}
		
		int count = 0;
		for(Player p : playerlist) {
			if (p.getClub().equalsIgnoreCase(input)) {
				System.out.println(p.toString());
				count++;
			}
		}
		System.out.println("Number of players found: "+count+"\n");
		return count;
	}
	
	public int findByNation(String input) {
		
		if(playerlist.isEmpty()) {
			System.out.println("Player list is empty; nothing to filter");
			return -1;
		}
		
		int count = 0;
		for(Player p : playerlist) {
			if (p.getNation().equalsIgnoreCase(input)) {
				System.out.println(p.toString());
				count++;
			}
		}
		System.out.println("Number of players found: "+count+"\n");
		return count;
	}
	
	public int findByPosition(String input) {
		
		if(playerlist.isEmpty()) {
			System.out.println("Player list is empty; nothing to filter");
			return -1;
		}
		
		int count = 0;
		for(Player p : playerlist) {
			if (p.getPosition().equalsIgnoreCase(input)) {
				System.out.println(p.toString());
				count++;
			}
		}
		System.out.println("Number of players found: "+count+"\n");
		return count;
	}
	
	public int findByMarketVal(double value) {
		
		if(playerlist.isEmpty()) {
			System.out.println("Player list is empty; nothing to filter");
			return -1;
		}
		
		int count = 0;
		for(Player p : playerlist) {
			if (p.getMarketValue() == value) {
				System.out.println(p.toString());
				count++;
			}
		}
		System.out.println("Number of players found: "+count+"\n");
		return count;
	}
	
	

	
	/**
	 * Return the ArrayList<Player> to caller
	 */
	public ArrayList<Player> getPlayerList(){
		return playerlist;
	}
	
	/**
	 * Add a new custom player to ArrayList
	 */
	public void addPlayer(Scanner scan) {
		//Scanner scan = new Scanner(System.in);
		String input = "";
		
		// default values
		String name_str = "Unknown Player";
		int player_age = 0;
		String club_str = "Unknown Club";
		String nation_str = "Unknown Nation";
		String pos_str = "Unknown Position";
		double player_value = 0.0;
		
		while(true) {
			
			System.out.println("Add new player? (Y/N)");
			input = scan.nextLine();
			
			if(input.equalsIgnoreCase("y")) {
				
				System.out.println("Name?");
				name_str = scan.nextLine();
				
				try {
					System.out.println("Age?");
					String age_str = scan.nextLine();
					player_age = Integer.parseInt(age_str);
				}
				catch(NumberFormatException ex) {
					System.out.println("Invalid age");
				}
		        
				System.out.println("Club?");
		        club_str = scan.nextLine();
		        
				System.out.println("Nation?");
		        nation_str = scan.nextLine();
		        
				System.out.println("Position?");
		        pos_str = scan.nextLine();
		        
		        try {
		        	System.out.println("Market value?");
		        	String value_str = scan.nextLine();
		        	player_value = Double.parseDouble(value_str);
		        }
		        catch(NumberFormatException ex) {
		        	System.out.println("Invalid market value");
		        }
		        
		        Player newPlayer = new Player(name_str, player_age, club_str, nation_str, pos_str.toUpperCase(), player_value); 
		        
				playerlist.add(newPlayer);				
		        
			}
			
			else if(input.equalsIgnoreCase("n")) {
				break;
			}
		}
		
	}
	
	public DataLoader()  {
		try {
			playerlist = new ArrayList<>();
			
			//loadXMLData(new File("premierLeaguePlayerNames.xml"));
			//addPlayer();
			//printAll();
			
			//filterPlayers();
			//saveNewXML();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

//	public static void main(String[] args) throws Exception {
//		new DataLoader();
//	}

}
