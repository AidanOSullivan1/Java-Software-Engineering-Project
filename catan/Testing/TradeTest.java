package Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameplay.Trade;
import players.Player;
import players.PlayerList;
import resources.ResourceList;
import resources.Resources;
import setup.PlayerSetup;
import setup.TileSetup;

class TradeTest {

	@Test
	public void testTrade() {
		//All resources set up in the marketplace and stockpile and a single player who has several of each resource for testing purposes
		 PlayerList.getInstance().addPlayer(new Player());
		 for (Player player: PlayerList.getInstance().getList()) {
			 player.changeResourceNum(1, 5);   // 5 of each resources added the the player's hand
			 player.changeResourceNum(2, 5);
			 player.changeResourceNum(3, 5);
			 player.changeResourceNum(4, 5);
			 player.changeResourceNum(5, 5);
			 TileSetup tileHandler    = new TileSetup();
		     tileHandler.resourcesInit();
		     
		     //Test to see if a trade with the stockpile will add one of the chosen resources to the player's
		     // and remove two of another resource from the players hand, which should appear in the stockpile
		     // In this instance the player chooses to take gold (index 1) and exchange wood (index 5)
		     Resources stockpile = ResourceList.getInstance().getResource(1);  //Returns the stockpile from singleton list
		     int expectedStockpileGold = stockpile.getResourceNum(1)-1;
		     int expectedStockpileWood = stockpile.getResourceNum(5)+2;
		     int expectedPlayerGold = player.getResourceNum(1)+1;
		     int expectedPlayerWood = player.getResourceNum(5)-2;
		     
		     //Carry out the trade
		     Trade trade = new Trade();
		     trade.stockpileTrade(1, 5, player,null);
		     
		     assertEquals("The correct amount of Gold in the Stockpile after the trade",expectedStockpileGold, stockpile.getResourceNum(1));
		     assertEquals("The correct amount of Wood in the Stockpile after the trade",expectedStockpileWood, stockpile.getResourceNum(5));
		     
		     assertEquals("The correct amount of Gold in the Player's hand after the trade",expectedPlayerGold, player.getResourceNum(1));
		     assertEquals("The correct amount of Wood in the Player's after the trade",expectedPlayerWood, player.getResourceNum(5));
		     
		     
		     // Similar test for the marketplace
		     // In this case a single resource should be taken from the player's hand and added to the marketplace
		     // while another single resource is taken from the marketplace and added to the player's hand
		     //// In this instance the player chooses to take molasses (index 2) and exchange cutlasses (index 4)
		     Resources marketplace = ResourceList.getInstance().getResource(0);  //Returns the marketplace from singleton list
		     int expectedMarketplaceMollasses = marketplace.getResourceNum(2)-1;
		     int expectedMarketplaceCutlasses = marketplace.getResourceNum(4)+1;
		     int expectedPlayerMollasses = player.getResourceNum(2)+1;
		     int expectedPlayerCutlasses = player.getResourceNum(4)-1;
		     
		     //Carry out the trade
		     trade.marketplaceTrade(2, 4, player);
		     
		     assertEquals("The correct amount of Mollasses in the Marketplace after the trade",expectedMarketplaceMollasses, marketplace.getResourceNum(2));
		     assertEquals("The correct amount of Cutlasses in the Markertplace after the trade",expectedMarketplaceCutlasses, marketplace.getResourceNum(4));
		     
		     assertEquals("The correct amount of Mollasses in the Player's hand after the trade",expectedPlayerMollasses, player.getResourceNum(2));
		     assertEquals("The correct amount of Cutlasses in the Player's after the trade",expectedPlayerCutlasses, player.getResourceNum(4));
		 }
		
		
		
	}

}
