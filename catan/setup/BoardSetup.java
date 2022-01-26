package setup;

import board.Board;
import enums.Colour;
import enums.TileEnums;
import gameplay.Building;
import players.PlayerList;


public class BoardSetup {
	
	public static void buildStarterLairs() { //builds the starter bases for each colour
		Building building = new Building();
		
		Board.getBoard().get(9).get(7).setType(TileEnums.GHOSTCAPT); //place ghost captin in starter location
		
		building.buildLair(5, 3, PlayerList.getInstance().getPlayerFromColour(Colour.PURPLE));  //Purple starter Lairs
		building.buildLair(13, 15, PlayerList.getInstance().getPlayerFromColour(Colour.PURPLE));
		building.buildShip(12, 15, PlayerList.getInstance().getPlayerFromColour(Colour.PURPLE));  //Purple starter Lairs
		building.buildShip(6, 4, PlayerList.getInstance().getPlayerFromColour(Colour.PURPLE));
		
		building.buildLair(11, 3, PlayerList.getInstance().getPlayerFromColour(Colour.GREEN)); //Green starter
		building.buildLair(3, 15, PlayerList.getInstance().getPlayerFromColour(Colour.GREEN));
		building.buildShip(4, 15, PlayerList.getInstance().getPlayerFromColour(Colour.GREEN)); //Green starter
		building.buildShip(10, 4, PlayerList.getInstance().getPlayerFromColour(Colour.GREEN));
		
		building.buildLair(3, 7, PlayerList.getInstance().getPlayerFromColour(Colour.BLUE)); //blue starter
		building.buildLair(11, 19, PlayerList.getInstance().getPlayerFromColour(Colour.BLUE));
		building.buildShip(4, 7, PlayerList.getInstance().getPlayerFromColour(Colour.BLUE)); //blue starter
		building.buildShip(10, 18, PlayerList.getInstance().getPlayerFromColour(Colour.BLUE));
		
		building.buildLair(13, 7, PlayerList.getInstance().getPlayerFromColour(Colour.RED)); //red starter
		building.buildLair(5, 19, PlayerList.getInstance().getPlayerFromColour(Colour.RED));
		building.buildShip(6, 18, PlayerList.getInstance().getPlayerFromColour(Colour.RED)); //red starter
		building.buildShip(12, 7, PlayerList.getInstance().getPlayerFromColour(Colour.RED));
	}
	

}
