package SWEN502.Testing.Assignment;

import java.io.File;
import java.util.ArrayList;

public class RunMe {

	private DataLoader dataLoader;
	private DBInterface dbInterface;
	private ArrayList<Player> myPlayerList;
	
	public RunMe() throws Exception {
		
		dataLoader = new DataLoader();
		dataLoader.loadXMLData(new File("premierLeaguePlayerNames.xml"));
		//dataLoader.addPlayer();
		myPlayerList = dataLoader.getPlayerList();
		
		//System.out.println(myPlayerList.size());
		dbInterface = new DBInterface();
		dbInterface.openDB();
		dbInterface.saveToDB(myPlayerList);
		dbInterface.readDB();
		dbInterface.closeDB();
		
	}

	public static void main(String[] args) throws Exception {
		new RunMe();
	}

}
