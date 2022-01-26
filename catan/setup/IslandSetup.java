package setup;

import board.Board;

import enums.TileEnums;

public class IslandSetup {
	private int[] tL = new int[2]; // Top left of island
	private int[] tR = new int[2]; // Top right corner of island
	private int[] bR = new int[2]; // Bottom left corner of island
	private int[] bL = new int[2]; // Bottom right corner of island

	//private int tLx, tLy, tRx, tRy, bRx, bRy, bLx, bLy; // read in coordinates for corners
	private int islandNum; // dice number on island
	private char islandRes; // resource on island
	private int islID; //id number for island
	private int ghostCapt; //0 if no ghost captain, 1 if ghost captain on island

	// constructor for a normal island
	// takes in corner coordinates,resource type and island number
	public IslandSetup(int id, int tLx, int tLy, int tRx, int tRy, int bRx, int bRy, int bLx, int bLy, int islandNum,
			char islandRes) {
		this.tL[0] = tLx;
		this.tL[1] = tLy;
		this.tR[0] = tRx;
		this.tR[1] = tRy;
		this.bL[0] = bLx;
		this.bL[1] = bLy;
		this.bR[0] = bRx;
		this.bR[1] = bRy;
		this.islandNum = islandNum; // DICE NUMBER ON ISLAND
		this.islandRes = islandRes; // W = WOOD, G = GOLD, M = MOLASSES,C = CUTLASS, S = sheep
		this.islID = id;
		this.ghostCapt = 0;
	}

	public int getIslID() {
		return islID;
	}


	
	public void setIsland() { // method to put the island on the game board

		for (int y = tL[1] - 1; y < bL[1]; y++) { // For each row in Board
			for (int x = tL[0] - 1; x < tR[0]; x++) { // For each column in row
				Board.getBoard().get(y).get(x).setType(TileEnums.ISLAND);
			}
		}

		// set the ship paths on the board - seen as "~" on board 
		Board.getBoard().get(bL[1] - 1).get(bL[0] - 1).setType(TileEnums.SHIP_PATH);
		Board.getBoard().get(tR[1] - 1).get(tR[0] - 1).setType(TileEnums.SHIP_PATH);
		Board.getBoard().get(tL[1] - 1).get(tL[0] - 1).setType(TileEnums.SHIP_PATH);
		Board.getBoard().get(bR[1] - 1).get(bR[0] - 1).setType(TileEnums.SHIP_PATH);
		Board.getBoard().get(bL[1]).get(bL[0] + 1).setType(TileEnums.SHIP_PATH);
		Board.getBoard().get(tL[1] - 2).get(tL[0] + 1).setType(TileEnums.SHIP_PATH);

		// set players base locations - seen as "0" on board 
		Board.getBoard().get(bL[1] - 2).get(bL[0] - 2).setType(TileEnums.LAIR_SPOT);
		Board.getBoard().get(bR[1] - 2).get(bR[0] + 0).setType(TileEnums.LAIR_SPOT);
		Board.getBoard().get(bR[1]).get(bR[0] - 2).setType(TileEnums.LAIR_SPOT);
		Board.getBoard().get(bR[1] - 4).get(bR[0] - 2).setType(TileEnums.LAIR_SPOT);
		Board.getBoard().get(bR[1]).get(bR[0] - 4).setType(TileEnums.LAIR_SPOT);
		Board.getBoard().get(bR[1] - 4).get(bR[0] - 4).setType(TileEnums.LAIR_SPOT);

		// set resource and number for the island in the middle of island
		Board.getBoard().get(tL[1]).get(tL[0] + 1).setChar(" " + this.islandNum + " ");
		Board.getBoard().get(tL[1] + 1).get(tL[0] + 1).setChar(" " + this.islandRes + " ");

	}

	// method for creating the islands on the left edge of the map
	// have a slightly different shape as no player lair/ship lane on 1 side.
	public void setEdgeIslandL() {

		for (int y = tL[1] - 1; y < bL[1]; y++) { // For each row in Board
			for (int x = tL[0] - 1; x < tR[0]; x++) { // For each column in row
				Board.getBoard().get(y).get(x).setType(TileEnums.ISLAND);
			}
		}

		// set ship path that are shared with the neighbouring island
		// overwritten with the above loop from last island
		Board.getBoard().get(tR[1] - 1).get(tR[0] - 1).setType(TileEnums.SHIP_PATH);
		Board.getBoard().get(bR[1] - 1).get(bR[0] - 1).setType(TileEnums.SHIP_PATH);

		// set 2 idle corners to default character print
		Board.getBoard().get(tL[1] - 1).get(tL[0] - 1).setType(TileEnums.MISC);
		Board.getBoard().get(bL[1] - 1).get(bL[0] - 1).setType(TileEnums.MISC);

		// set resource and number as before in the middle of the island
		Board.getBoard().get(tL[1]).get(tL[0] + 1).setChar(" " + this.islandNum + " ");
		Board.getBoard().get(tL[1] + 1).get(tL[0] + 1).setChar(" " + this.islandRes + " ");

	}

	public void setEdgeIslandR() {

		for (int y = tL[1] - 1; y < bL[1]; y++) { // For each row in Board
			for (int x = tL[0] - 1; x < tR[0]; x++) { // For each column in row
				Board.getBoard().get(y).get(x).setType(TileEnums.ISLAND);
			}
		}

		// set ship path that are shared with the neighbouring island
		// overwritten with the above loop from last island
		Board.getBoard().get(tR[1] - 1).get(tR[0] - 1).setType(TileEnums.MISC);
		Board.getBoard().get(bR[1] - 1).get(bR[0] - 1).setType(TileEnums.MISC);

		// set 2 idle corners to default character print
		Board.getBoard().get(tL[1] - 1).get(tL[0] - 1).setType(TileEnums.SHIP_PATH);
		Board.getBoard().get(bL[1] - 1).get(bL[0] - 1).setType(TileEnums.SHIP_PATH);

		// set resource and number as before in the middle of the island
		Board.getBoard().get(tL[1]).get(tL[0] + 1).setChar(" " + this.islandNum + " ");
		Board.getBoard().get(tL[1] + 1).get(tL[0] + 1).setChar(" " + this.islandRes + " ");

	}

	public int getIslandNum() { //returns island dice number
		return islandNum;
	}

	public String getIslandRes() { //returns string of the islands associated resource from character
		String resType = null;
		switch (islandRes) {
		case 'W':
			resType = "wood";
			break;
		case 'G':
			resType = "gold";
			break;
		case 'M':
			resType = "molasses";
			break;
		case 'C':
			resType = "cutlasses";
			break;
		case 'S':
			resType = "sheep";
			break;
		case 'X':
			resType = "ghost captain";
			break;
		//default:
			//System.out.println("ERROR IN getIslandRes");	
		}
		return resType;
	}

	public int getGhostCapt() {
		return ghostCapt;
	}

	public void setGhostCapt(int ghostCapt) {
		this.ghostCapt = ghostCapt;
	}

}
