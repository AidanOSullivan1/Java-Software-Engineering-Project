package board;

import enums.TileEnums;

public class Tile {

    private TileEnums tileType; //enum type
    private String       mapChar; //character displayed on map
    
 
    protected Tile(int x, int y) { // constructor
        this.tileType = TileEnums.MISC; // Tile type
        this.mapChar  = tileType.getChar(); // Tile map character
    }
    
    public String getChar() { //get character method
        return mapChar;
    }
    
    public void setChar(String newChar) { // Set mapChar to custom value
        this.mapChar = newChar;
    }
    
    public void setType(TileEnums newType) { // Set new tileType and mapChar
        tileType = newType;
        resetChar();
    }
    
    protected void resetChar() { // Set mapChar to default value for tileType
    	mapChar = tileType.getChar();
    }

	public void setType(int j) { //ensures even spacing on board with coordinate system
		// TODO Auto-generated method stub
		if(j<10) {
		mapChar = " "+ String.valueOf(j) + " "; //single digit numbers
		}
		else {
			mapChar = " "+ String.valueOf(j); //ensure even spacing of 2 digit numbers
		}
	}
}
