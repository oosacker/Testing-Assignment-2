package SWEN502.Testing.Assignment;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
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
	
	
	public void loadXMLData(Scanner scan) {

		// default values
		String name = "Unknown Player";
		String club = "Unknown Club";
		int age = 0;
		double value = 0.0;
		String pos = "Unknown Position";
		String nation = "Unknown Nationality";
		String xmlfile = "premierLeaguePlayerNames.xml";


		System.out.println("Which xml file to load?");
		System.out.println("0: Specify your own");
		System.out.println("1: Load default file (premierLeaguePlayerNames.xml)");
		String line = scan.nextLine();

		switch(line) {

			case("0"):{
				System.out.println("Which file?");
				xmlfile = scan.nextLine();
				break;
			}
			case("1"):{
				// Load the default file (premierLeaguePlayerNames.xml)
				break;
			}
			default:{
				System.out.println("Invalid input\n");
				break;
			}
		}

		System.out.println("Loading " +xmlfile+ "\n");

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
			return;
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
			return;
		} 
		catch(IOException ex) {
			System.out.println("IO error: xml file may be missing\n");
			return;
		} 
		catch(IllegalArgumentException ex) {
			System.out.println("IllegalArgumentException: invalid arguement to parse\n");
			return;
		}


		NodeList mylist = doc.getElementsByTagName("row");
		for(int i=0; i<mylist.getLength(); i++) {

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


	}

	/***
	 * Save the ArrayList as a new XML file
	 */
	public void saveNewXML() {
		
		try {
			DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = df.newDocumentBuilder();

			Document doc = db.newDocument();

			Element root = doc.createElement("root");
			doc.appendChild(root);

			Element row = doc.createElement("row");
			root.appendChild(row);

			for(Player p : playerlist) {

				Element playerName = doc.createElement("name");
				playerName.appendChild(doc.createTextNode( p.getName()) );
				root.appendChild(playerName);


				Element playerClub = doc.createElement("club");
				playerClub.appendChild(doc.createTextNode( p.getClub()) );
				root.appendChild(playerClub);

				Element playerAge = doc.createElement("age");
				playerAge.appendChild(doc.createTextNode( Integer.toString(p.getAge())) );
				root.appendChild(playerAge);

				Element playerPos = doc.createElement("position");
				playerPos.appendChild(doc.createTextNode( p.getPosition()) );
				root.appendChild(playerAge);

				Element playerMarketVal = doc.createElement("market_value");
				playerMarketVal.appendChild(doc.createTextNode( Double.toString(p.getMarketValue())) );
				root.appendChild(playerMarketVal);

				Element playerNation = doc.createElement("nationality");
				playerNation.appendChild(doc.createTextNode( p.getNation()) );
				root.appendChild(playerNation);

			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource domSource = new DOMSource(doc);
			StreamResult streamResult = new StreamResult(new File("myPlayerList.xml"));

			transformer.transform(domSource, streamResult);
		}
		catch(Exception ex) {
			System.out.println("Error saving new XML file\n");
			ex.printStackTrace();
		}
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
	 * Search for a player in the ArrayList
	 */
	public void filterPlayers(Scanner scan) {
		
		if(playerlist.isEmpty()) {
			System.out.println("Player list is empty; cannot filter\n");
			return;
		}
		
		printAll();
			
		//Scanner scan = new Scanner(System.in);
		String input = "";
		int count = 0;
		
		while(true) {
			
			System.out.println("Filter player list? (Y/N)");
			input = scan.nextLine();
			
			if(input.equalsIgnoreCase("Y")) {
				
				System.out.println("Filter player list by?");
				System.out.println("0: Name");
				System.out.println("1: Age");
				System.out.println("2: Club");
				System.out.println("3: Nationality");
				System.out.println("4: Position");
				System.out.println("5: Market value");
				input = scan.nextLine();
				
				switch(input) {
				
					// Name mode
					case "0":{
						
						System.out.println("Name?");
						input = scan.nextLine();
						
						for(Player p : playerlist) {
							if (p.getName().equalsIgnoreCase(input)) {
								System.out.println(p.toString());
								count++;
							}
						}
						System.out.println("Number of players found: "+count+"\n");
						count = 0;
						break;
					}
					
					// Age mode
					case "1":{
						
						System.out.println("Age?");
						input = scan.nextLine();
						int age = -1;	// Default value
						
						try {
							age = Integer.parseInt(input);
						}
						catch(NumberFormatException ex) {
							System.out.println("Invalid input");
						}
						
						for(Player p : playerlist) {
							if (p.getAge() == age) {
								System.out.println(p.toString());
								count++;
							}
						}
						System.out.println("Number of players found: "+count+"\n");
						count = 0;
						break;
					}
					
					// Club mode
					case "2":{
						System.out.println("Club?");
						input = scan.nextLine();
						
						for(Player p : playerlist) {
							if (p.getClub().equalsIgnoreCase(input)) {
								System.out.println(p.toString());
								count++;
							}
						}
						System.out.println("Number of players found: "+count+"\n");
						count = 0;
						break;
					}
					
					// Nationality mode
					case "3":{
						System.out.println("Nationality?");
						input = scan.nextLine();
						
						for(Player p : playerlist) {
							if (p.getNation().equalsIgnoreCase(input)) {
								System.out.println(p.toString());
								count++;
							}
						}
						System.out.println("Number of players found: "+count+"\n");
						count = 0;
						break;
					}
					
					// Position mode
					case "4":{
						System.out.println("Position?");
						input = scan.nextLine();
						
						for(Player p : playerlist) {
							if (p.getPosition().equalsIgnoreCase(input)) {
								System.out.println(p.toString());
								count++;
							}
						}
						System.out.println("Number of players found: "+count+"\n");
						count = 0;
						break;
					}
					
					// Market value mode
					case "5":{
						System.out.println("Market value (£M)?");
						input = scan.nextLine();
						double value = 0.0;	// Default value
						
						try {
							value = Double.parseDouble(input);
						}
						catch(NumberFormatException ex) {
							System.out.println("Invalid input");
						}
						
						for(Player p : playerlist) {
							if (p.getMarketValue() == value) {
								System.out.println(p.toString());
								count++;
							}
						}
						System.out.println("Number of players found: "+count+"\n");
						count = 0;
						break;
					}
					
					default:{
						System.out.println("Invalid input");
						break;
					}
					
				}

			}
			
			else if(input.equalsIgnoreCase("N")) {
				break;
			}
			
			else {
				System.out.println("Invalid input");
			}
		}
		
		//scan.close();
		
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

	public static void main(String[] args) throws Exception {
		new DataLoader();
	}

}
