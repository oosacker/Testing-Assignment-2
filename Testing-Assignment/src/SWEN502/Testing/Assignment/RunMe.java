package SWEN502.Testing.Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMe {

	private DataLoader dataLoader;
	private DBInterface dbInterface;
	private ArrayList<Player> myPlayerList;

	private String url = "jdbc:mysql://localhost/nats";
	private String dbUser = "newuser";	// do not use root!!!!!
	private String usrPass = "1234";

	public RunMe() throws Exception {

		Scanner scan = new Scanner(System.in);
		String input = "";
		String xmlfile = "premierLeaguePlayerNames.xml";

		dataLoader = new DataLoader();
		dbInterface = new DBInterface();
		myPlayerList = new ArrayList<>();

		while(true) {

			System.out.println("Select option?");
			System.out.println("0: Load data from xml");
			System.out.println("1: Display loaded data");
			System.out.println("2: Filter players by attibute");
			System.out.println("3: Save current list to database");
			System.out.println("4: Quit\n");
			input = scan.nextLine();

			first_switch_statement:
				
			switch(input) {

				// 0: Load data from xml
				
				case "0":{
					
					System.out.println("Which xml file to load?");
					System.out.println("0: Specify your own");
					System.out.println("1: Load default file (premierLeaguePlayerNames.xml)\n");
					String line = scan.nextLine();
					
					
					switch(line) {
						case("0"):{
							System.out.println("Which file?");
							xmlfile = scan.nextLine();
							
							dataLoader.loadXMLData(xmlfile);
							myPlayerList = dataLoader.getPlayerList();
							
							break;
						}
						case("1"):{
							// Load the default file (premierLeaguePlayerNames.xml)
							xmlfile = "premierLeaguePlayerNames.xml";
							
							dataLoader.loadXMLData(xmlfile);
							myPlayerList = dataLoader.getPlayerList();
							
							break;
						}
						default:{
							System.out.println("Invalid input\n");
							break;
						}
						
					}
					
					break;
				}
	
				//1: Display loaded data
				case "1":{
					dataLoader.printAll();
					break;
				}
	
				//2: Filter players by attribute
				case "2":{
	
					if (dataLoader.getPlayerList().isEmpty()) {
						System.out.println("Player list is empty; nothing to filter\n");
						break;
					}
					
					while(true) {
						
						System.out.println("Filter player list by?");
						System.out.println("0: Name");
						System.out.println("1: Age");
						System.out.println("2: Club");
						System.out.println("3: Nationality");
						System.out.println("4: Position");
						System.out.println("5: Market value");
						System.out.println("6: Cancel\n");
						input = scan.nextLine();
	
						switch(input) {
	
							// Name mode
							case "0":{
		
								System.out.println("Name?");
								input = scan.nextLine();
								
								if(input.equals("")) {
									System.out.println("Invalid input\n");
									break;
								}
								
								dataLoader.findByName(input);
		
								break;
							}
		
							// Age mode
							case "1":{
		
								System.out.println("Age?");
								input = scan.nextLine();
								
								if(input.equals("")) {
									System.out.println("Invalid input\n");
									break;
								}
								
								int age = -1;	// Default value
		
								try {
									age = Integer.parseInt(input);
								}
								catch(NumberFormatException ex) {
									System.out.println("Invalid input\n");
								}
		
								dataLoader.findByAge(age);
		
								break;
							}
		
							// Club mode
							case "2":{
								System.out.println("Club?");
								input = scan.nextLine();
								
								if(input.equals("")) {
									System.out.println("Invalid input\n");
									break;
								}
								
								dataLoader.findByClub(input);
								break;
							}
		
							// Nationality mode
							case "3":{
								System.out.println("Nationality?");
								input = scan.nextLine();
								
								if(input.equals("")) {
									System.out.println("Invalid input\n");
									break;
								}
								
								dataLoader.findByNation(input);
								break;
							}
		
							// Position mode
							case "4":{
								System.out.println("Position?");
								input = scan.nextLine();
								
								if(input.equals("")) {
									System.out.println("Invalid input\n");
									break;
								}
								
								dataLoader.findByPosition(input);
								break;
							}
		
							// Market value mode
							case "5":{
								System.out.println("Market value (£M)?");
								input = scan.nextLine();
								
								if(input.equals("")) {
									System.out.println("Invalid input\n");
									break;
								}
								
								double value = 0.0;	// Default value
		
								try {
									value = Double.parseDouble(input);
								}
								catch(NumberFormatException ex) {
									System.out.println("Invalid input");
								}
		
								dataLoader.findByMarketVal(value);
								break;
							}
		
							case "6":{
								break first_switch_statement;
							}
		
							default:{
								System.out.println("Invalid input");
								break;
							}
	
						}
	
					}
					
				}
	
				case "3":{
					
					if (dataLoader.getPlayerList().isEmpty()) {
						System.out.println("Player list is empty; nothing to save\n");
						break;
					}
					
					myPlayerList = dataLoader.getPlayerList();
					dbInterface.openDB(url, dbUser, usrPass);
					dbInterface.saveAll(myPlayerList);
					dbInterface.closeDB();
					break;
				}
	

				case "4":{
					System.out.println("Quit\n");
					return;
				}
	

				/* THESE ARE FOR DEVELOPER TESTING ONLY!!! */
				// TRUNCATE THE DATABASE (REMOVE ALL PLAYERS) 
				/*
				case "5":{
					dbInterface.openDB(url, dbUser, usrPass);
					dbInterface.truncatePlayerTable();
					dbInterface.closeDB();
					break;
				}
	
				// READ ALL PLAYERS FROM DATABASE
				case "6":{
					dbInterface.openDB(url, dbUser, usrPass);
					dbInterface.readDatabase();
					dataLoader.setPlayerList(dbInterface.getPlayers());
					dbInterface.closeDB();
					break;
				}
	
				// RESET THE ARRAYLISTS
				case "7":{
					dbInterface.clearPlayerList();
					dataLoader.clearPlayerList();
					myPlayerList.clear();
					break;
				}
				*/
				
				default:{
					System.out.println("Invalid input\n");
					break;
				}


			}

		}

	}

	public static void main(String[] args) throws Exception {
		new RunMe();
	}

}
