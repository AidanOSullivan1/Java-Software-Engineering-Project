package board;

import java.util.ArrayList;

public class Board {

	private static ArrayList<ArrayList<Tile>> boardTiles; // 2D array list to hold the board tiles
	private static Board theBoard;
	private int numRows; // number of rows on board
	private int numCols; // number of columns on board
	private int[] dimensions;

	// singleton setup to ensure only one board
	public static Board getInstance() {
		if (theBoard == null) {
			theBoard = new Board();
		}
		return theBoard;
	}

	// private constructor for the singleton setup
	private Board() {
		// Set dimensions of Board
		this.numRows = 22; // 5
		this.numCols = 16; // 7
		this.dimensions = new int[2];
		dimensions[0] = numCols;
		dimensions[1] = numRows;

		// Create blank Tiles for Board
		this.boardTiles = new ArrayList<ArrayList<Tile>>();

		for (int y = 0; y < numRows; y++) { // For each row in Board
			boardTiles.add(new ArrayList<Tile>()); // create 2D array list

			for (int x = 0; x < numCols; x++) { // For each column in row
				boardTiles.get(y).add(new Tile(x, y)); // add default tile
			}
		}

		// add in coordinate system
		for (int j = 1; j < numCols; j++) { // For each column in row
			boardTiles.get(numRows - 1).get(j - 1).setType(j); // adds in x axis coords
		}
		for (int k = 1; k < numRows; k++) { // For each column in row
			boardTiles.get(k - 1).get(numCols - 1).setType(k); // adds in y axis coords
		}
	}

	// method to return the board
	public static ArrayList<ArrayList<Tile>> getBoard() {
		return boardTiles;
	}

	// method to print the board out to console
	public void printBoard() {
		BoardLegend.printLegend();
		String stringOut; // string to hold each line

		for (int y = 0; y < numRows; y++) { // For each row in Board
			stringOut = "";

			for (int x = 0; x < numCols; x++) { // add each tile character to string
				stringOut = stringOut + boardTiles.get(y).get(x).getChar();
			}

			System.out.println(stringOut); // print out string
			stringOut = null; // reset string
		}
		System.out.println("\n");
		
	}


}
