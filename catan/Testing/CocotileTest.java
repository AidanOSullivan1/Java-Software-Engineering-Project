package Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameplay.Cocotiles;
import gameplay.Trade;
import players.Player;
import players.PlayerList;
import resources.ResourceList;
import resources.Resources;
import setup.TileSetup;

class CocotileTest {

	@Test
	public void testCocotiles() { 
		
		//All resources set up in the marketplace and stockpile and a single player who has several of each resource for testing purposes
		 PlayerList.getInstance().addPlayer(new Player());
		 for (Player player: PlayerList.getInstance().getList()) {
			 player.changeResourceNum(1, 6);   // 5 of each resources added the the player's hand
			 player.changeResourceNum(2, 6);
			 player.changeResourceNum(3, 6);
			 player.changeResourceNum(4, 6);
			 player.changeResourceNum(5, 6);
			 TileSetup tileHandler    = new TileSetup();
		     tileHandler.resourcesInit();
		     
		     // The first test ensures that the correct quantity of cocotiles are taken from a players hand 
		     // and added to the stockpile when a Cocotile is purchased
		     // A Cocotile costs one gold (index 1), molasses (index 2) and cutlasses (index 3)
		     
		     Resources stockpile = ResourceList.getInstance().getResource(1);  //Returns the stockpile from singleton list
		     int expectedStockpileGold = stockpile.getResourceNum(1)+1;
		     int expectedStockpileMolasses = stockpile.getResourceNum(2)+1;
		     int expectedStockpileCutlasses = stockpile.getResourceNum(4)+1;
		     int expectedPlayerGold = player.getResourceNum(1)-1;
		     int expectedPlayerMolasses = player.getResourceNum(2)-1;
		     int expectedPlayerCutlasses = player.getResourceNum(4)-1;
		     
		     //Carry out the purchase of a Cocotile
		     Cocotiles cocotiles = new Cocotiles();
		     cocotiles.buyCocoTile(player);
		     
		     //The molasses test was not used because in instances where Resource Card 1 is dealt the player would also receive molasses
		     
		     assertEquals("The correct amount of Gold in the Stockpile after the trade",expectedStockpileGold, stockpile.getResourceNum(1));
		     //assertEquals("The correct amount of Molasses in the Stockpile after the trade",expectedStockpileMolasses, stockpile.getResourceNum(2));
		     assertEquals("The correct amount of Cutlasses in the Stockpile after the trade",expectedStockpileCutlasses, stockpile.getResourceNum(4));
		     
		     assertEquals("The correct amount of Gold in the Player's hand after the trade",expectedPlayerGold, player.getResourceNum(1));
		     //assertEquals("The correct amount of Molasses in the Player's after the trade",expectedPlayerMolasses, player.getResourceNum(2));
		     assertEquals("The correct amount of Cutlasses in the Player's after the trade",expectedPlayerCutlasses, player.getResourceNum(4));
		     
		     // After each purchase the player should add the Cocotile to their pile. Check to ensure that this has occurred
		     // A second Cocotile trade is carried out 
		     
		     cocotiles.buyCocoTile(player);
		     
		     int numCocotiles = player.getNumCocoTiles();
		     
		     assertEquals("The correct amount of Cocotiles in the Player's hand",2, numCocotiles);
		     
		     //Test to ensure that a player dealt Resource Card 1 and 2 will receive the correct amount of Resources to their hand
		     // This will also be reflected in the Stockpile where they are subtracted.
		     // In this test case the deck has not been shuffled so it is known where these cards will be located
		     
		     // Resource Card 1 Test => Receive Molasses and Cutlasses
		     
		     expectedStockpileMolasses = stockpile.getResourceNum(2)-2+1;      //Gives two to the player but receives one from the cost of the Cocotile
		     int expectedStockpileWood = stockpile.getResourceNum(5)-2;
		     expectedPlayerMolasses = player.getResourceNum(2)+2-1;            //Receives 2 but losses one to the cost of a cocotile
		     int expectedPlayerWood = player.getResourceNum(5)+2;
		   

		     cocotiles.buyCocoTile(player);
		     
		     assertEquals("The correct amount of Molasses in the Stockpile after the trade",expectedStockpileMolasses, stockpile.getResourceNum(2));
		     assertEquals("The correct amount of Wood in the Stockpile after the trade",expectedStockpileWood, stockpile.getResourceNum(5));
		     
		     assertEquals("The correct amount of Molasses in the Player's after the trade",expectedPlayerMolasses, player.getResourceNum(2));
		     assertEquals("The correct amount of Wood in the Player's hand after the trade",expectedPlayerWood, player.getResourceNum(5));
		     
		     
		     // Resource Card 2 Test => Receive Sheep and Cutlasses
		     
		     expectedStockpileCutlasses = stockpile.getResourceNum(4)-2+1;      //Gives two to the player but receives one from the cost of the Cocotile
		     int expectedStockpileSheep = stockpile.getResourceNum(3)-2;
		     expectedPlayerCutlasses = player.getResourceNum(4)+2-1;            //Receives 2 but losses one to the cost of a cocotile
		     int expectedPlayerSheep = player.getResourceNum(3)+2;
		   

		     cocotiles.buyCocoTile(player);
		     
		     assertEquals("The correct amount of Cutlasses in the Stockpile after the trade",expectedStockpileCutlasses, stockpile.getResourceNum(4));
		     assertEquals("The correct amount of Sheep in the Stockpile after the trade",expectedStockpileSheep, stockpile.getResourceNum(3));
		     
		     assertEquals("The correct amount of Cutlasses in the Player's after the trade",expectedPlayerCutlasses, player.getResourceNum(4));
		     assertEquals("The correct amount of Sheep in the Player's hand after the trade",expectedPlayerSheep, player.getResourceNum(3));
		     
		 }
	}

}
