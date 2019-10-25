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
	
	private ArrayList<Player> playerlist;

	public void loadXMLData(File xmlfile) {
		
		// default values
		String name = "Unknown Player";
		String club = "Unknown Club";
		int age = 0;
		double value = 0.0;
		String pos = "Unknown Position";
		String nation = "Unknown Nationality";
		
		try {

			playerlist = new ArrayList<>();

			//File xmlfile = new File("premierLeaguePlayerNames.xml");

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			Document doc = db.parse(xmlfile);
			
			NodeList mylist = doc.getElementsByTagName("row");

			for(int i=0; i<mylist.getLength(); i++) {
				Node n = mylist.item(i);
				Element e = (Element)n;

				name = e.getElementsByTagName("name").item(0).getTextContent();
				club = e.getElementsByTagName("club").item(0).getTextContent();
				value =  Double.parseDouble(e.getElementsByTagName("market_value").item(0).getTextContent());
				pos = e.getElementsByTagName("position").item(0).getTextContent();
				age = Integer.parseInt(e.getElementsByTagName("age").item(0).getTextContent());
				nation = e.getElementsByTagName("nationality").item(0).getTextContent();

				Player newplayer = new Player(name, age, club, nation, pos, value);
				playerlist.add(newplayer);
			}
		}
		catch(SAXException e) {
			System.out.println("sax error");
		}
		catch(IOException e) {
			System.out.println("io error");
		}
		catch(ParserConfigurationException e) {
			System.out.println("parser error");
		}
		catch(DOMException ex){
			System.out.println("dom error");
		}
		
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
			System.out.println("Error saving new XML file");
			ex.printStackTrace();
		}
	}
	
	/**
	 * Print all items in the ArrayList
	 */
	public void printAll() {
		for(Player p : playerlist) {
			System.out.println(p.toString());
		}
		System.out.println("Number of players: "+playerlist.size()+"\n");
	}
	
	/**
	 * Search for a player in the ArrayList
	 */
	public void filterPlayers() {
		
		if(playerlist.isEmpty()) {
			System.out.println("Player list is empty; cannot search");
			return;
		}
		
		printAll();
			
		Scanner scan = new Scanner(System.in);
		String input = "";
		
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
							}
						}
						
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
							}
						}
						
						break;
					}
					
					// Club mode
					case "2":{
						System.out.println("Club?");
						input = scan.nextLine();
						
						for(Player p : playerlist) {
							if (p.getClub().equalsIgnoreCase(input)) {
								System.out.println(p.toString());
							}
						}
						break;
					}
					
					// Nationality mode
					case "3":{
						System.out.println("Nationality?");
						input = scan.nextLine();
						
						for(Player p : playerlist) {
							if (p.getNation().equalsIgnoreCase(input)) {
								System.out.println(p.toString());
							}
						}
						break;
					}
					
					// Position mode
					case "4":{
						System.out.println("Position?");
						input = scan.nextLine();
						
						for(Player p : playerlist) {
							if (p.getPosition().equalsIgnoreCase(input)) {
								System.out.println(p.toString());
							}
						}
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
							}
						}
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
		
		scan.close();
		
	}
	
	/**
	 * Return the ArrayList<Player> to caller
	 */
	public ArrayList<Player> getPlayerList(){
		return this.playerlist;
	}
	
	/**
	 * Add a new custom player to ArrayList
	 */
	public void addPlayer() {
		Scanner scan = new Scanner(System.in);
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
	
	public DataLoader() throws Exception {
		loadXMLData(new File("premierLeaguePlayerNames.xml"));
		//addPlayer();
		//printAll();
		
		filterPlayers();
		//saveNewXML();
	}

	public static void main(String[] args) throws Exception {
		new DataLoader();
	}

}
