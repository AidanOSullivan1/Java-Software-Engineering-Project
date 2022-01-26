package setup;

import java.util.ArrayList;
import players.Player;
import players.PlayerList;
import java.util.Scanner;
import enums.Colour;


public class PlayerSetup {

	////////// Method to get number of players playing //////////

	public static int getNumPlayers() {
		System.out.println("\nHow many players will be playing ? [3/4]");

		int j = 0;
		int userInput = 0;
		while (j == 0) {
			Scanner sc = new Scanner(System.in); // System.in is a standard input stream
			userInput = sc.nextInt();
			j = 1;

			if ((userInput > 4) || (userInput < 3)) { // input is outside of the range 3 to 4
				System.out.println("\n" + userInput + " is not a valid input, please choose from the following:");
				System.out.println("[3/4]");
				j = 0;
			}
		}
		return userInput;
	}

	/////////// Method to let players pick colours and assigns them //////////
	public static void playerBuilder() {
		ArrayList<Integer> playerPick = new ArrayList<>(); // array list to hold colour choices for players
		// RED = 1
		// WHITE = 2
		// BLUE = 3
		// ORANGE = 4
		int numPlayers = getNumPlayers();
		

		Player player1 = new Player();
		Player player2 = new Player();
		Player player3 = new Player(); // always create 4 players but maybe only use 3
		Player player4 = new Player();

		PlayerList.getInstance().addPlayer(player1);
		PlayerList.getInstance().addPlayer(player2);
		PlayerList.getInstance().addPlayer(player3); // add all players to player list
		PlayerList.getInstance().addPlayer(player4);

		int i = 0; // iterator for while loop
		int error = 0; // goes to 1 if error found in input

		//BoardSetup.buildStarterLairs(); //builds starter Lairs for all players

		if (numPlayers == 3) { // will remove the 4th player if none
			PlayerList.getInstance().removePlayer(player4);
		}

		System.out.println("[1] RED\n" + "[2] PURPLE\n[3] BLUE\n[4] GREEN");
		
		while (i < numPlayers) {
			System.out.println("\nPlayer " + (i + 1) + " please chose a colour :  ");
			Scanner input1 = new Scanner(System.in);
			int userInput1 = input1.nextInt(); // take input from user

			if (playerPick.contains(userInput1)) { // colour has already been chosen
				System.out.println("\nPlease chose a colour that has not already been taken");
				error = 1;
			}

			if ((userInput1 > 4) || (userInput1 < 1)) { // input is outside of the range 1 to 4
				System.out.println("\n" + userInput1 + " is not a valid input, please choose from the following:");
				System.out.println("[1] RED\n[2] PURPLE\n[3] BLUE\n[4] GREEN");
				error = 1;
			}

			if ((userInput1 <= 4) && (userInput1 >= 1) && (error == 0)) { // valid user input

				switch (userInput1) { // assigns right colour to the right player

				case 1:
					userInput1 = 1;
					(PlayerList.getInstance().getPlayer(i)).setColour(Colour.RED);
					break;

				case 2:
					userInput1 = 2;
					(PlayerList.getInstance().getPlayer(i)).setColour(Colour.PURPLE);
					break;

				case 3:
					userInput1 = 3;
					(PlayerList.getInstance().getPlayer(i)).setColour(Colour.BLUE);
					break;

				case 4:
					userInput1 = 4;
					(PlayerList.getInstance().getPlayer(i)).setColour(Colour.GREEN);
					break;

				}
				playerPick.add(userInput1); // holds player picks for error checking
				i++; // iterator for indexing
			}
			error = 0; // reset error checker
		}

	}

}
