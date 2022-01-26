package gameplay;

import players.Player;
import resources.ResourceList;
import resources.Resources;
import tiles.*;


public class Cocotiles {
	
		    //Check to see if they have enough of the necessary resources
			//Subtract 1 from cutlasses, wood and molasses
			//Take a cocotile from the deck 
			//Function to use immediately
			//Add to the number of cocotiles that the player has
			//Check to see if they have the the most cocotiles and can move a lair to the Spooky Island
	
	Resources stockpile = ResourceList.getInstance().getResource(1);
	public static int maxCocoTiles;
	//Function used if a player wishes to buy a cocotile
	public void buyCocoTile(Player player) {
		if(player.getResourceNum(1)==0||player.getResourceNum(2)==0||player.getResourceNum(4)==0){
			System.out.println("You do not have enough resources of either Gold, Molasses or Cutlasses in your deck");	
		}
		else {
			player.changeResourceNum(1,-1);
			stockpile.changeResourceNum(1,1);
			player.changeResourceNum(2,-1);
			stockpile.changeResourceNum(2,1);
			player.changeResourceNum(4,-1);
			stockpile.changeResourceNum(4,1);	
			
			Tile cocotile = Deck.getInstance().dealCocoTile();
			System.out.println(cocotile);
			//Immediately use cocotile
			 useCocoTile(cocotile,player);
			 player.setNumCocoTiles(1);
			 //spookyIslandCheck();	
		}
		
		 
		 }
	
	public static void useCocoTile(Tile cocotile, Player player) {
		if( cocotile.indexNum() == 1 ) {
			
			Trade trade = new Trade();
			//This string indicates to stockpileTrade() not to subtract from a players hand and only to give resources
			String coco = "coco";
			// Two molasses added to the player and removed from the stockpile.
			//Function called twice because the function only detects if 0 resources remain in the stockpile (Reuses regular Trading functionality)
			//If there was 1 resource remaining and two to be removed this would pose a problem
			trade.stockpileTrade(2, 0, player,coco);
			trade.stockpileTrade(2, 0, player,coco);
			// Two wood added to the player and removed from the stockpile.
			trade.stockpileTrade(5, 0, player,coco);
			trade.stockpileTrade(5, 0, player,coco);
			System.out.println(player);
		}
		else if(cocotile.indexNum() == 2) {
			Trade trade = new Trade();
			String coco = "coco";
			// Two goats added to the player and removed from the stockpile.
			trade.stockpileTrade(3, 0, player,coco);
			trade.stockpileTrade(3, 0, player,coco);
			// Two cutlasses added to the player and removed from the stockpile.
			trade.stockpileTrade(4, 0, player,coco);
			trade.stockpileTrade(4, 0, player,coco);
			System.out.println(player);
		}
		else if(cocotile.indexNum() == 3) {
			GhostCaptain.placeGhostCaptain(player);
		//Add ghost captain cocotile action
		}
		else if(cocotile.indexNum() == 4) {
			Building building = new Building();
			building.pickLair(player);
		}
	}
	
	/*//functionality not implemented in final design
public void spookyIslandCheck() {
		int cocotileNum;
		int largest = 0;
		boolean draw = false;
		for (Player player : PlayerList.getInstance().getList()) {
			cocotileNum = player.getNumCocoTiles();
			if (cocotileNum > largest) {
				player.getColour();
				largest = cocotileNum;
				draw = false;
			}
			else if (cocotileNum == largest) {
				draw = true;
			}
		}
		if (draw == false) {
			//Add "player",colour.toString()," to the print statement when player colours are initaited
			System.out.println("Player may place one of the unused pirates’ lairs on Spooky Island.  ");
		}
		else if (draw == true) {
			System.out.println("Multiple players have the same number of cocotiles, remove your pirate layers from the island");
		}
		
		
		
	}
*/
	
	

}
