package gameplay;

import java.util.Scanner;

import enums.Colour;
import enums.TileEnums;
import players.Player;
import resources.ResourceList;
import resources.Resources;
import board.Board;


public class Building { // class buildsd Lairs and Ships

	// Resources stockpile = ResourceList.getInstance().getResource(1);
	public void buildLair(int x, int y, Player currentPlayer) {
		// add in check to ensure right location for a base

		Colour colour = currentPlayer.getColour(); // gets players colour

		switch (colour) { // pick what colour to build lair

		case RED:
			Board.getBoard().get(y - 1).get(x - 1).setType(TileEnums.REDLAIR);
			break;
		case BLUE:
			Board.getBoard().get(y - 1).get(x - 1).setType(TileEnums.BLUELAIR);
			break;
		case GREEN:
			Board.getBoard().get(y - 1).get(x - 1).setType(TileEnums.GREENLAIR);
			break;
		case PURPLE:
			Board.getBoard().get(y - 1).get(x - 1).setType(TileEnums.PURPLELAIR);
			break;
		default:
			System.out.println("ERROR IN build lair");
		}

		int concatCoords = Integer.valueOf(String.valueOf(x) + String.valueOf(y)); // concatenated coordinates

		currentPlayer.addLair(concatCoords); // saves coords to player
		// Board.getInstance().printBoard(); // prints board to screen

	}

	public void buildShip(int x, int y, Player currentPlayer) {
		// add in check to ensure right location for a base

		Colour colour = currentPlayer.getColour(); // gets players colour

		switch (colour) { // pick what colour to build lair

		case RED:
			Board.getBoard().get(y - 1).get(x - 1).setType(TileEnums.REDSHIP);
			break;
		case BLUE:
			Board.getBoard().get(y - 1).get(x - 1).setType(TileEnums.BLUESHIP);
			break;
		case GREEN:
			Board.getBoard().get(y - 1).get(x - 1).setType(TileEnums.GREENSHIP);
			break;
		case PURPLE:
			Board.getBoard().get(y - 1).get(x - 1).setType(TileEnums.PURPLESHIP);
			break;
		default:
			System.out.println("ERROR IN build ship");
		}

		int concatCoords = Integer.valueOf(String.valueOf(x) + String.valueOf(y)); // concatenated coordinates

		// currentPlayer.addLair(concatCoords); // saves coords to player
		// Board.getInstance().printBoard(); // prints board to screen

	}

	public void pickLair(Player currentPlayer) { // finds coordinates where player wants to build
		Board.getInstance().printBoard(); // prints board to screen
		System.out.println("Please choose where you would like to build a Lair.\n");
		System.out.println(
				"A player may only build a lair in an empty lair location (O) adjacent to one of their ships\n");

		System.out.println("Enter the x coordinate :  \n");

		Scanner input = new Scanner(System.in);
		int x_coord = input.nextInt(); // take input from user - x coordinate

		System.out.println("Enter the y coordinate :  \n");
		int y_coord = input.nextInt(); // take input from user - y coordinate

		buildLair(x_coord, y_coord, currentPlayer); // calls build lair method for current player
	}

	public void pickShip(Player currentPlayer) { // finds coordinates where player wants to build

		System.out.println("Please choose where you would like to build a Ship.\n");
		System.out.println(
				"A player may only build a ship in an empty ship location (~) adjacent to one of their lairs\n");
		System.out.println("Enter the x coordinate :  \n");

		Scanner input = new Scanner(System.in);
		int x_coord = input.nextInt(); // take input from user - x coordinate

		System.out.println("Enter the y coordinate :  \n");
		int y_coord = input.nextInt(); // take input from user - y coordinate

		buildShip(x_coord, y_coord, currentPlayer); // calls build lair method for current player
	}

	public void canBuildCheck(Player currentPlayer) {
		Resources stockpile = ResourceList.getInstance().getResource(1);
		if (currentPlayer.getResourceNum(2) == 0 || currentPlayer.getResourceNum(3) == 0
				|| currentPlayer.getResourceNum(4) == 0 || currentPlayer.getResourceNum(5) == 0) {
			System.out.println("You do not have enough resources to build\n");
			return;
		}

		if (currentPlayer.getResourceNum(3) == 0 || currentPlayer.getResourceNum(5) == 0) {
			System.out.println("You do not have enough resources to build a Ship\n");
			return;
		} else {
			System.out.println("Would you like to build a [1] Lair or a [2] Ship\n");
			Scanner input = new Scanner(System.in);
			int ans = input.nextInt(); // take input from user - x coordinate

			if (ans == 1) {
				pickLair(currentPlayer);
				// take resources used off player
				currentPlayer.changeResourceNum(2, -1);
				stockpile.changeResourceNum(2, 1);
				currentPlayer.changeResourceNum(3, -1);
				stockpile.changeResourceNum(3, 1);
				currentPlayer.changeResourceNum(4, -1);
				stockpile.changeResourceNum(4, 1);
				currentPlayer.changeResourceNum(5, -1);
				stockpile.changeResourceNum(5, 1);

				return;
			} else if (ans == 2) {
				pickShip(currentPlayer);
				// t6ake resources for ship
				currentPlayer.changeResourceNum(3, -1);
				stockpile.changeResourceNum(3, 1);
				currentPlayer.changeResourceNum(5, -1);
				stockpile.changeResourceNum(5, 1);

			}

		}

	}

}
