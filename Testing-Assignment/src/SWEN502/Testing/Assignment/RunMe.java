package SWEN502.Testing.Assignment;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import ecs100.*;

public class RunMe {

	private DataLoader dataLoader;
	private DBInterface dbInterface;
	private ArrayList<Player> myPlayerList;
	
	public RunMe() throws Exception {
		
		Scanner scan = new Scanner(System.in);
		String input = "";
		
		dataLoader = new DataLoader();
		dbInterface = new DBInterface();
		myPlayerList = new ArrayList<>();
		
		while(true) {
			
			System.out.println("Select option?");
			System.out.println("0: Load data into list from xml");
			System.out.println("1: Display currently loaded players");
			System.out.println("2: Add a new player to player list");
			System.out.println("3: Filter player in list by attibute");
			System.out.println("4: Save current player list to database");
			System.out.println("5: Delete all players on database");
			System.out.println("6: Read players from database into list");
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
					dbInterface.openDB();
					dbInterface.saveAll(myPlayerList);
					dbInterface.closeDB();
					break;
				}
	
				case "5":{
					dbInterface.openDB();
					dbInterface.deleteAllPlayers();
					dbInterface.closeDB();
					break;
				}
	
				case "6":{
					dbInterface.openDB();
					dbInterface.readDatabase();
					dataLoader.setPlayerList(dbInterface.getPlayers());
					dbInterface.closeDB();
					break;
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
