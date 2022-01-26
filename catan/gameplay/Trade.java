package gameplay;

import players.Player;
import players.PlayerList;
import resources.*;


public class Trade {

	// Player should specify the resource they wish to trade and then they must
	// return two of the same type of another resource from their hand to the
	// stockpile
	// Can trade with the stockpile as many times as they wish during their turn
	// The user will input an integer to decide which resource is selected
	Resources stockpile = ResourceList.getInstance().getResource(1); // Returns the stockpile from singleton list

	public void stockpileTrade(int resourceTake, int resourceGive, Player player, String gameplay) {
		int resourceNum;
		int playerResNum;
		resourceNum = stockpile.getResourceNum(resourceTake); // Checks if the Stockpile has enough of this kind to give
																// to the Player

		// Special trade Instance when the player is receiving resources from a cocotile
		if (resourceNum > 0 && gameplay == "coco") {
			stockpile.changeResourceNum(resourceTake, -1);
			player.changeResourceNum(resourceTake, 1);
		}
		playerResNum = player.getResourceNum(resourceGive); // Checks if the player has enough of resources of this kind
															// to return. Must be greater than 1

		if (resourceNum > 0 && playerResNum > 1 && gameplay == "lair") {
			stockpile.changeResourceNum(resourceGive, 1);
			player.changeResourceNum(resourceGive, -1);
			stockpile.changeResourceNum(resourceTake, -1);
			player.changeResourceNum(resourceTake, 1);
		}

		// Regular Trade when all conditions are met
		if (resourceNum > 0 && playerResNum > 1 && gameplay != "coco") {
			stockpile.changeResourceNum(resourceGive, 2);
			player.changeResourceNum(resourceGive, -2);
			stockpile.changeResourceNum(resourceTake, -1);
			player.changeResourceNum(resourceTake, 1);
		}
		// If none of that resource remain in the pile, all resources of that type are
		// returned from the all the players' hand. Then trade.
		else if (resourceNum == 0) {
			System.out.println("None of the chosen resource remain in the stockpile. The stockpile will be restocked");
			stockpileRunOut(resourceTake);
			// Now trade
			stockpile.changeResourceNum(resourceTake, -1);
			player.changeResourceNum(resourceTake, 1);
		} else if (playerResNum <= 1 && gameplay != "coco") {
			System.out.println(
					"None of the chosen resource remain in the Player's hand. Please choose another and try again");
		}
	}

	public void stockpileRunOut(int resourceTake) {
		System.out.println("the stockpile has run out of " + resourceTake
				+ ". All resources of this type will be removed from every player's hand.");
		int resourceNum;
		// all resources of that type in every player's hand are returned to the
		// stockpile
		for (Player player : PlayerList.getInstance().getList()) {
			resourceNum = player.getResourceNum(resourceTake);
			System.out.println("the player has " + resourceNum);
			player.changeResourceNum(resourceTake, -resourceNum);
			stockpile.changeResourceNum(resourceTake, resourceNum);
		}
	}

	public void marketplaceTrade(int resourceTake, int resourceGive, Player player) {
		Resources marketplace = ResourceList.getInstance().getResource(0);
		int resourceNum;
		int playerResNum;
		resourceNum = marketplace.getResourceNum(resourceTake); // Check of the marketplace has enough of this kind to
																// give
		playerResNum = player.getResourceNum(resourceGive); // Checks if the player has enough of this kind to give.
		if (resourceNum > 0 && playerResNum > 0) {
			// Receiving a resource
			marketplace.changeResourceNum(resourceTake, -1);
			player.changeResourceNum(resourceTake, 1);
			// Giving a resource in exchange
			marketplace.changeResourceNum(resourceGive, 1);
			player.changeResourceNum(resourceGive, -1);
			// Add message if the player choses to trade a resource that is not in their
			// hand
		} else if (resourceNum == 0) {
			System.out.println(
					"None of the chosen resource remain in the Marketplace. Please choose another and try again");

		} else if (playerResNum == 0) {
			System.out.println(
					"None of the chosen resource remain in the Player's hand. Please choose another and try again");

		}

		// Check to see if all the resources in the marketplace are of the same type
		if (marketplace.checkResources() == true) {
			System.out.println("Marketplace reset as there are 5 resources of the same kind");
			// If true the tiles are removed from the marketplace and returned to the
			// stockpile. Then, it will be necessary to place 1 of each resource on the
			// marketplace booths, just like at the beginning of the game.”
			marketplace.resetMarketplace();
		} else {
		}

	}

}
