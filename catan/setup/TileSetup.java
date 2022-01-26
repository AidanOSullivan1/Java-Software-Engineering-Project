package setup;
import resources.*;
import players.Player;
import players.PlayerList;


public class TileSetup {

		private int gold = 1;
		private int molasses = 2;
		private int goats = 3;
		private int cutlasses = 4;
		private int wood = 5;
			
		Resources stockpile = new Stockpile(0,0,0,0,0);
		Resources marketplace = new MarketPlace(0,0,0,0,0);
		
		public TileSetup() {
			//resourcesInit();
		}
		
		//Sets up the marketplace, stockpile and gives out the intial tiles to each player
		public void resourcesInit() {
			
			int playerNum = PlayerList.getInstance().getNumPlayers();
			//Initial amount in the Stockpile
			stockpile.changeResourceNum(gold,17);
			stockpile.changeResourceNum(cutlasses,17);
			stockpile.changeResourceNum(goats,17);
			stockpile.changeResourceNum(molasses,17-playerNum); 
			stockpile.changeResourceNum(wood,17-playerNum);
			
			//Initial amount in the Marketplace, add 1  of each type to each booth
			// i stands for the resource to be incremented
			for (int i = 1; i < 6; i++){
				marketplace.changeResourceNum(i,1);
			}
			
			//Initial amount given to each player
			for (Player player : PlayerList.getInstance().getList()) {
				player.changeResourceNum(molasses,1);
				player.changeResourceNum(wood,1);

			}
			
			ResourceList.getInstance().addResourcetoList(marketplace);
			ResourceList.getInstance().addResourcetoList(stockpile);
	}
	
}
