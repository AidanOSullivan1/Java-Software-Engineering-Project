package setup;

import board.Board;
import tiles.Deck;

public class SetupManager {
	// ===========================================================
	// Variable Setup
	// ===========================================================
	// Self singleton
	private static SetupManager setup;

	// Setup Controllers
	private TileSetup tileHandler;


	// ===========================================================
	// Get Instance of Singleton
	// ===========================================================
	/**
	 * getInstance of singleton Setup class
	 * 
	 * @return instance of Setup class
	 */
	public static SetupManager getInstance() {
		if (setup == null) {
			setup = new SetupManager();
		}
		return setup;
	}

	// ===========================================================
	// Constructor
	// ===========================================================
	/**
	 * Constructor class for Setup
	 */
	private SetupManager() {
		// this.playerHandler = new PlayerSetup();
		this.tileHandler = new TileSetup();
	}

	public void doAllSetup() {

		welcomeScreen();
		Board.getInstance(); // create instance of the board

		LairResourceMap.createIslands(); // makes all the islands and places on board
		LairResourceMap.diceLairLink();

		PlayerSetup.playerBuilder();

		tileHandler.resourcesInit();
		BoardSetup.buildStarterLairs();
		Deck.getInstance();
		Deck.getInstance().ShuffleDeck();
	}

	/**
	 * Printout a Welcome / start screen
	 */
	public void welcomeScreen() {
		System.out.println("  .oooooo.          oooo        888888888888         oooo         888       888     ");
		System.out.println(" d8P'  `Y8b        888888           888             888888        888888    888   	");
		System.out.println("888               888  888          888            888  888       888 888   888      ");
		System.out.println("888              888    888         888           888    888      888  888  888       ");
		System.out.println("888             888888888888        888          888888888888     888   888 888      ");
		System.out.println("`88b    ooo    888        888       888         888        888    888    888888        ");
		System.out.println(" `Y8bood8P'   888          888      888        888          888   888     88888         ");
		System.out.println("\nSoftware Engineering (COMP 41670) 2021\n");
		System.out.println("Authors: Aidan O'Sullivan and Jack Donnelly");
	}

}
