package gameplay;

import players.Player;
import resources.ResourceList;
import resources.Resources;
import java.util.Scanner;

import board.Board;

public class PlayerTurn {

	public static Player getCurrentPlayer() {
		return currentPlayer;
	}

	public boolean isDidMarketplaceTrade() {
		return didMarketplaceTrade;
	}

	private boolean didMarketplaceTrade = false;
	private static Player currentPlayer;

	public PlayerTurn(Player thisPlayer) {
		PlayerTurn.currentPlayer = thisPlayer;
	}

	public void playerTurn() {
		int userInput = 0;
		boolean validInput;
		boolean turnOver = false;

		System.out.println("It is " + currentPlayer.getColour() + "'s turn! Press '1' to begin.");
		Scanner sc = new Scanner(System.in); // System.in is a standard input stream
		int userInput1 = sc.nextInt();

		while (!turnOver) {
			System.out.println(currentPlayer.getColour() + "'s turn! Press '1' to roll the dice to begin your turn.");
			sc = new Scanner(System.in); // System.in is a standard input stream
			
			
			
			userInput1 = sc.nextInt();
			Dice dice = new Dice();
			int diceRoll = dice.rollDice();
			
			
			if(diceRoll==6) {
				GhostCaptain.placeGhostCaptain(currentPlayer);
			}
			
			else {
			ReceiveResources.diceResources(diceRoll); //1 should be diceRoll
			}
			
			Board.getInstance().printBoard();
			//
			System.out.println(currentPlayer);
			
			
			Resources stockpile = ResourceList.getInstance().getResource(1);
			String resourcetoReceive = stockpile.getResourceString(diceRoll);
			
			
			//System.out.println(diceRoll + " was rolled.Each player with a pirate lair next to an island with "
					//+ diceRoll + " should receive " + resourcetoReceive);
			
			
			// Add gameplay for each player receiving resources based on the dice roll and
			// Ghostcaptain
			validInput = false;

			while (!validInput && userInput != 5) {
				turnOptions();
				sc = new Scanner(System.in); // System.in is a standard input stream
				// String userString = sc.nextInt();

				try {
					userInput = sc.nextInt();
				} catch (NumberFormatException e) {
					continue;
				}

				if ((userInput >= 1) && (userInput <= 5)) {
					validInput = true;
				}

				Cocotiles cocotiles = new Cocotiles();
				Building building = new Building();
				
				switch (userInput) {
				case 1: building.canBuildCheck(currentPlayer);
						Board.getInstance().printBoard();
					break;
				case 2:
					cocotiles.buyCocoTile(currentPlayer);
					break;
				case 3:
					tryMarketplaceTrade(currentPlayer);
					break;
				case 4:
					tryStockpileTrade(currentPlayer);
					break;
				case 5:
					turnOver = true;
					break;
				default:
					System.out.println("CASE ERROR IN PlayerTurn.doTurn()");
				}
				validInput = false;
			}
			
			//Cocotiles.spookyIslandCheck(currentPlayer);
		}
		System.out.println("Player has ended their turn");
		// Most likely will return to game manager

	}

	private void turnOptions() {
		System.out.println("\nWhat do you want to do?\nYour options are:");
		System.out.println("[1]    build                        \t[Lair Cost = 1 cutlass, 1 molasses, 1 sheep & 1 wood]      [Ship Cost = 1 sheep & 1 wood]"); // As many times as they want per turn
		System.out.println("[2]    buy a cocotile				[cost =  1 cutlass, 1 molasses, & 1 gold]"); // As many times as they want per turn (I think)
		System.out.println("[3]    trade with the marketplace"); // Once per turn
		System.out.println("[4]    trade with the stockpile"); // As many times as they want per turn
		// Add ghost captain functionality
		System.out.println("[5]    end your turn");
	}

	public void tryMarketplaceTrade(Player currentPlayer) {
		System.out.println(ResourceList.getInstance().getList());
		if (didMarketplaceTrade) {
			System.out.println("You already traded with the marketplace this turn.This action is not permitted.");
		} else if (!didMarketplaceTrade) {
			System.out.println(
					"Please Select the resource that you wish to take from the marketplace using its number index");
			Scanner scan = new Scanner(System.in); // System.in is a standard input stream
			int resourceTake = scan.nextInt();
			System.out.println("Please Select the resource that you wish to give to the marketplace");
			scan = new Scanner(System.in); // System.in is a standard input stream
			int resourceGive = scan.nextInt();
			Trade trade = new Trade();
			trade.marketplaceTrade(resourceTake, resourceGive, currentPlayer);
			System.out.println(currentPlayer);
		}
		didMarketplaceTrade = true; // Remembers that a marketplace trade has already taken place
	}

	public void tryStockpileTrade(Player currentPlayer) {
		System.out.println(ResourceList.getInstance().getList());
		System.out
				.println("Please Select the resource that you wish to take from the Stockpile using its number index");
		Scanner scan = new Scanner(System.in); // System.in is a standard input stream
		int resourceTake = scan.nextInt();
		System.out.println(
				"Please Select the resource that you wish to give to the stockpile. Two of this type will be removed from your hand");
		scan = new Scanner(System.in); // System.in is a standard input stream
		int resourceGive = scan.nextInt();
		Trade trade = new Trade();
		trade.stockpileTrade(resourceTake, resourceGive, currentPlayer, null);
		System.out.println(currentPlayer);
	}

}