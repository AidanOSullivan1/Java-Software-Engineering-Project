package Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import players.Player;
import players.PlayerList;
import resources.ResourceList;
import resources.Resources;
import setup.TileSetup;

class TileSetupTest {

	@Test
	public void testTileSetup() {
		PlayerList.getInstance();
		Player player1 = new Player();
		Player player2 = new Player();
		Player player3 = new Player();
		
		PlayerList.getInstance().addPlayer(player1);
		PlayerList.getInstance().addPlayer(player2);
		PlayerList.getInstance().addPlayer(player3);
		
		int numPlayers = PlayerList.getInstance().getNumPlayers();
		
		int expectedStockpileGold = 17;
		int expectedStockpileMollasses = 17-numPlayers;
		int expectedStockpileGoats = 17;
		int expectedStockpileCutlasses = 17;
		int expectedStockpileWood = 17-numPlayers;
		
		
		TileSetup tilesetup = new TileSetup ();
		tilesetup.resourcesInit();
		Resources stockpile = ResourceList.getInstance().getResource(1);
		
		assertEquals("The correct amount of Gold should be in the Stockpile on setup",expectedStockpileGold, stockpile.getResourceNum(1));
		assertEquals("The correct amount of Mollasses should be in the Stockpile on setup",expectedStockpileMollasses, stockpile.getResourceNum(2));
		assertEquals("The correct amount of Goats should be in the Stockpile on setup",expectedStockpileGoats, stockpile.getResourceNum(3));
		assertEquals("The correct amount of Cutlasses should be in the Stockpile on setup",expectedStockpileCutlasses, stockpile.getResourceNum(4));
		assertEquals("The correct amount of Wood should be in the Stockpile on setup",expectedStockpileWood, stockpile.getResourceNum(5));
		
		int expectedMarketplaceGold = 1;
		int expectedMarketplaceMollasses = 1;
		int expectedMarketplaceGoats = 1;
		int expectedMarketplaceCutlasses = 1;
		int expectedMarketplaceWood = 1;
		Resources marketplace = ResourceList.getInstance().getResource(0);
		
		assertEquals("The correct amount of Gold should be in the Marketplace on setup",expectedMarketplaceGold, marketplace.getResourceNum(1));
		assertEquals("The correct amount of Mollasses should be in the Marketplace on setup",expectedMarketplaceMollasses, marketplace.getResourceNum(2));
		assertEquals("The correct amount of Goats should be in the Marketplace on setup",expectedMarketplaceGoats, marketplace.getResourceNum(3));
		assertEquals("The correct amount of Cutlasses should be in the Marketplace on setup",expectedMarketplaceCutlasses, marketplace.getResourceNum(4));
		assertEquals("The correct amount of Wood should be in the Marketplace on setup",expectedMarketplaceWood, marketplace.getResourceNum(5));
		
		//Show for 1 player that they received the correct number of resources
		
		int expectedPlayerGold = 0;
		int expectedPlayerMollasses = 1;
		int expectedPlayerGoats = 0;
		int expectedPlayerCutlasses = 0;
		int expectedPlayerWood = 1;
		
		assertEquals("The correct amount of Gold should be in the Player's hand on setup",expectedPlayerGold, player1.getResourceNum(1));
		assertEquals("The correct amount of Mollasses should be in the Player's hand on setup",expectedPlayerMollasses, player1.getResourceNum(2));
		assertEquals("The correct amount of Goats should be in the Player's hand on setup",expectedPlayerGoats, player1.getResourceNum(3));
		assertEquals("The correct amount of Cutlasses should be in the Player's hand on setup",expectedPlayerCutlasses, player1.getResourceNum(4));
		assertEquals("The correct amount of Wood should be in the Player's hand on setup",expectedPlayerWood, player1.getResourceNum(5));
		
		
	}

}
