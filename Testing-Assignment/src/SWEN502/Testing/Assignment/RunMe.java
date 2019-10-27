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
			System.out.println("3: Save current list to database (flush)");
			System.out.println("4: Delete all data on database (truncate)");
			System.out.println("5: Read data from database");
			System.out.println("6: Reset local player lists");
			System.out.println("7: Quit");
			input = scan.nextLine();

			first_switch_statement:
				
			switch(input) {

				// 0: Load data from xml
				case "0":{
					
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
					dataLoader.loadXMLData(xmlfile);
					myPlayerList = dataLoader.getPlayerList();
					break;
				}
	
				//1: Display loaded data
				case "1":{
					dataLoader.printAll();
					break;
				}
	
				//2: Filter players by attibute
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
						System.out.println("6: Cancel");
						input = scan.nextLine();
	
						switch(input) {
	
							// Name mode
							case "0":{
		
								System.out.println("Name?");
								input = scan.nextLine();
								dataLoader.findByName(input);
		
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
		
								dataLoader.findByAge(age);
		
								break;
							}
		
							// Club mode
							case "2":{
								System.out.println("Club?");
								input = scan.nextLine();
								dataLoader.findByClub(input);
								break;
							}
		
							// Nationality mode
							case "3":{
								System.out.println("Nationality?");
								input = scan.nextLine();
								dataLoader.findByNation(input);
								break;
							}
		
							// Position mode
							case "4":{
								System.out.println("Position?");
								input = scan.nextLine();
								dataLoader.findByPosition(input);
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
					dbInterface.openDB(url, dbUser, usrPass);
					dbInterface.truncatePlayerTable();
					dbInterface.closeDB();
					break;
				}
	
				case "5":{
					dbInterface.openDB(url, dbUser, usrPass);
					dbInterface.readDatabase();
					dataLoader.setPlayerList(dbInterface.getPlayers());
					dbInterface.closeDB();
					break;
				}
	
				case "6":{
					dbInterface.clearPlayerList();
					dataLoader.clearPlayerList();
					myPlayerList.clear();
					break;
				}
	
				case "7":{
					return;
				}
	
				default:{
					break;
				}


			}

		}



		//dataLoader.loadXMLData(new File("premierLeaguePlayerNames.xml"));
		//dataLoader.addPlayer();
		//myPlayerList = dataLoader.getPlayerList();

		//System.out.println(myPlayerList.size());



		//dbInterface.findPlayerinDB(myPlayerList.get((int)(Math.random() * 461)));

		//dbInterface.deleteAllPlayers();
		//dbInterface.saveAll(myPlayerList);
		//dbInterface.readDB();
		//dbInterface.closeDB();

	}

	public static void main(String[] args) throws Exception {
		new RunMe();
	}

}
