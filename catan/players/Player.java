package players;

import java.util.ArrayList;
import resources.Resources;
import enums.Colour;


public class Player extends Resources{

	private Colour colour;
	private int numCocoTiles; //number of coco tile cards 
	private ArrayList<Integer> lairsBuilt;

	
	@Override
	public String toString() {
		return colour +" Player \n" + "\nNumber CocoTiles =\t" + numCocoTiles + "\nGold =\t\t\t" + getGold() + "\nMolasses =\t\t" + getMolasses() + "\nGoats =\t\t\t"
				+ getSheep() + "\nCutlasses =\t\t" + getCutlasses() + "\nWood =\t\t\t" + getWood() + "\n----------------------------\n";
	}

	//Constructor for Player
	public Player() {
		super(0,0,0,0,0);
		this.colour = null;
		this.numCocoTiles = 0;
		this.lairsBuilt = new ArrayList<Integer>();
	}

	public ArrayList<Integer> getLairsBuilt() {
		return lairsBuilt;
	}


    public void addLair(int coords) { //adds the lair a player just built to lairsBuilt
    	this.lairsBuilt.add(coords);
    }


	//Getters and setters for Player
	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}

	public int getNumCocoTiles() {
		return numCocoTiles;
	}

	public void setNumCocoTiles(int numCocoTiles) {
		this.numCocoTiles = this.numCocoTiles+numCocoTiles;
	}

	public int getResourceNum(int resource) {
		return super.getResourceNum(resource);
	} 
	

	public void changeResourceNum(int resource, int changeNum) {
		 super.changeResourceNum(resource,changeNum);
		} 
	
	
	
//More Methods for player.....	


	@Override
	public boolean checkResources() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void resetMarketplace() {
		// TODO Auto-generated method stub
		
	}
}
