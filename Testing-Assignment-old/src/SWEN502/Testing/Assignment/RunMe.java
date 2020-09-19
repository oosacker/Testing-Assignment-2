package SWEN502.Testing.Assignment;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import ecs100.*;

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
		
		dataLoader = new DataLoader();
		dbInterface = new DBInterface();
		myPlayerList = new ArrayList<>();
		
		while(true) {
			
			System.out.println("Select option?");
			System.out.println("0: Load data from xml");
			System.out.println("1: Display loaded data");
			System.out.println("2: Add a new player to list");
			System.out.println("3: Filter players by attibute");
			System.out.println("4: Save current list to database (flush)");
			System.out.println("5: Delete all data on database (truncate)");
			System.out.println("6: Read data from database");
			System.out.println("7: Reset local player lists");
			input = scan.nextLine();

			switch(input) {

				case "0":{
					//dataLoader.loadXMLData(new File("premierLeaguePlayerNames.xml"));
					
					dataLoader.loadXMLData(scan);
					myPlayerList = dataLoader.getPlayerList();
					break;
				}
	
				case "1":{
					dataLoader.printAll();
					break;
				}
	
				case "2":{
					dataLoader.addPlayer(scan);	// can only have one scan object
					break;
				}
	
				case "3":{
					dataLoader.filterPlayers(scan); // can only have one scan object
					break;
				}
	
				case "4":{
					myPlayerList = dataLoader.getPlayerList();
					dbInterface.openDB(url, dbUser, usrPass);
					dbInterface.saveAll(myPlayerList);
					dbInterface.closeDB();
					break;
				}
	
				case "5":{
					dbInterface.openDB(url, dbUser, usrPass);
					dbInterface.truncatePlayerTable();
					dbInterface.closeDB();
					break;
				}
	
				case "6":{
					dbInterface.openDB(url, dbUser, usrPass);
					dbInterface.readDatabase();
					dataLoader.setPlayerList(dbInterface.getPlayers());
					dbInterface.closeDB();
					break;
				}
				
				case "7":{
					dbInterface.clearPlayerList();
					dataLoader.clearPlayerList();
					myPlayerList.clear();
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
