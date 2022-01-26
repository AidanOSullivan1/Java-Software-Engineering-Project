package players;

import java.util.ArrayList;
import java.util.List;

import enums.Colour;

public class PlayerList {
	private static PlayerList playerList1;
	private static List<Player> playerList;

	// ===========================================================
	// Get Instance of Singleton
	// ===========================================================
	/**
	 * Get the single instance of the List of Players in the game
	 * 
	 * @return The PlayerList object
	 */
	public static PlayerList getInstance() {
		if (playerList1 == null) {
			playerList1 = new PlayerList();
		}
		return playerList1; // change
	}

	private PlayerList() { // constructor
		this.playerList = new ArrayList<Player>();
	}

	public void addPlayer(Player player1) { // add player to playerlist
		playerList.add(player1);
	}
	
	public void removePlayer(Player player1) { // add player to playerlist
		playerList.remove(player1);
	}

	public int getNumPlayers() { // returns number of players in the game
		return playerList.size();
	}

	public Player getPlayer(int index) {
		return playerList.get(index);
	}
	
	public Player getPlayerFromColour(Colour colour) {
		
		for(int i=0 ; i<playerList.size() ; i++) {
			if(colour == playerList.get(i).getColour()) {
				return playerList.get(i);
			}
		}
		//System.out.println("Player not found");
		Player removedPlayer = new Player();
		removedPlayer.setColour(colour);
		return removedPlayer;
	}

	public List<players.Player> getList() { // returns list of all players
		//System.out.println(this.playerList.toString());
		return playerList;
	}

}
