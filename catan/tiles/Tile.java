package tiles;

public abstract class Tile {
	private int index;
	@Override
	public String toString() {
		return "Tile [name=" + name + "]";
	}
	

	@SuppressWarnings("rawtypes")
    private Enum name;   
	//===========================================================
	// Constructor
	//===========================================================
	/**
	 * Abstract constructorfor Card object.
	 * @param name Enum name for card.
	 */
	Tile(@SuppressWarnings("rawtypes") Enum name,int index){
		this.name   = name;
		this.setIndex(index);
	}

	//===========================================================
	// Getters
	//===========================================================
	// getter for card's name
	@SuppressWarnings("rawtypes")
    public Enum getName() {
		return this.name;
	}
	
	public int indexNum() {
		return this.getIndex();
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}


}
