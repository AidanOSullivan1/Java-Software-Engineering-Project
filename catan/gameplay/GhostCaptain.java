package gameplay;

import java.util.Scanner;

import board.Board;
import enums.TileEnums;
import players.Player;
import resources.Resources;
import setup.IslandSetup;
import setup.LairResourceMap;

public class GhostCaptain {
	
	public static int lastXCoord = 8; //hold last GC location so he can be removed
	public static int lastYCoord = 11; //set to spooky island location to start
	
	
	public static void placeGhostCaptain(Player currentPlayer) { 
		
		resetGhostCapt(); //removes old ghost captain
		
		Board.getInstance().printBoard(); //print board
		System.out.println("You have just activated the Ghost captain feature ! \n");
		System.out.println("You can now place the ghost captain on any island giving you 2 of the island's resource \n");
		System.out.println("However while the Ghost Captain is on this island no resources can be collected from it from the dice roll \n");
		
		System.out.println("Please enter the x coordinate for the centre of the island (The coordinate of the dice Number) :\n");
		Scanner input = new Scanner(System.in);
		int x_coord = input.nextInt(); // take input from user - x coordinate

		System.out.println("Please enter the y coordinate for the centre of the island (The coordinate of the dice Number) :\n");
		int y_coord = input.nextInt(); // take input from user - y coordinate
		
		int resIndex =  Resources.getResourceIndex(getIslandFromCoord(x_coord, y_coord).getIslandRes()); //gets resource index to give to player
		
		Trade trade = new Trade();
		String coco = "coco";
		
		trade.stockpileTrade(resIndex, 0, currentPlayer,coco); //gives res from stockpile to player
		trade.stockpileTrade(resIndex, 0, currentPlayer,coco);
		
		placeOnMap(x_coord, y_coord); //places ghost captain on map
		
		getIslandFromCoord(x_coord, y_coord).setGhostCapt(1); //sets captain on island - so know location for resource dice rolls
		
		lastXCoord = x_coord; //sets last location so can clear when captain is placed again
		lastYCoord = y_coord;

	}
	
	public static IslandSetup getIslandFromCoord(int x, int y) { //gets the island from the coordinates given 
		
		int concatCoords = Integer.valueOf(String.valueOf(x) + String.valueOf(y)); //concatanate coords
		
		switch(concatCoords) {
		case 83: return LairResourceMap.getIsland1(); //(8,3) is centre of island 1 ....
		case 87: return LairResourceMap.getIsland2();
		case 49: return LairResourceMap.getIsland3();
		case 811: return LairResourceMap.getIsland4();
		case 1210: return LairResourceMap.getIsland5();
		case 413: return LairResourceMap.getIsland6();
		case 815: return LairResourceMap.getIsland7();
		case 1213: return LairResourceMap.getIsland8();
		case 819: return LairResourceMap.getIsland9();
		case 45: return LairResourceMap.geteIsland1();
		case 125: return LairResourceMap.geteIsland2();
		case 417: return LairResourceMap.geteIsland3();
		case 1217: return LairResourceMap.geteIsland4();
		}
		return null;
	}
	
	public static void placeOnMap(int x, int y) { //places ghost captain on the board
		Board.getBoard().get(y-2).get(x-1).setType(TileEnums.GHOSTCAPT); //place x on map
	}
	
	public static void resetGhostCapt() { //removes ghost captain from the board
		getIslandFromCoord(lastXCoord,lastYCoord).setGhostCapt(0); //resets last ghost captain location
		Board.getBoard().get(lastYCoord-2).get(lastXCoord-1).setType(TileEnums.ISLAND); //RESETS marker on island 
	}

}
