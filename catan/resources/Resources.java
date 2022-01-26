package resources;

public abstract class Resources {
	private int gold;
	private int molasses;
	private int sheep;
	private int cutlasses;
	private int wood;
	
	
	public Resources(int gold, int molasses, int sheep, int cutlasses, int wood) {
		this.gold = gold;
		this.molasses = molasses;
		this.sheep = sheep;
		this.cutlasses = cutlasses;
		this.wood = wood;
	}
	
	@Override
	public String toString() {
		return   "\n\n(1) Gold =\t\t\t" + gold + "\n(2) Molasses =\t\t\t" + molasses + "\n(3) Sheep =\t\t\t"
				+ sheep + "\n(4) Cutlasses =\t\t\t" + cutlasses + "\n(5) Wood =\t\t\t" + wood + "\n----------------------------\n";
	}
	
	public String getResourceString(int resource) {
		String resourceName = null;
		switch (resource) {
		case 1:
			resourceName= "gold";
			break;
		case 2:
			resourceName = "molasses";
			break;
		case 3:
			resourceName= "sheep";
			break;
		case 4:
			resourceName = "cutlasses";
			break;
		case 5:
			resourceName = "wood";
			break;
		 default: 	
		}
		return resourceName;
	}

	public int getGold() {
		return gold;
	}


	public int getMolasses() {
		return molasses;
	}


	public int getSheep() {
		return sheep;
	}


	public int getCutlasses() {
		return cutlasses;
	}


	public int getWood() {
		return wood;
	}
	
	public static int getResourceIndex(String resource) {
		
		int resourceIndex = 6; // variable to hold resource index (5 out of bounds)
		
		/* Variable Index Key
		 * gold =      1
		 * molasses =  2
		 * sheep =     3
		 * cutlasses = 4
		 * wood =      5
		 */
		
		switch (resource) {
		case "gold":
			resourceIndex = 1;
			break;
		case "molasses":
			resourceIndex = 2;
			break;
		case "sheep":
			resourceIndex = 3;
			break;
		case "cutlasses":
			resourceIndex = 4;
			break;
		case "wood":
			resourceIndex = 5;
			break;
		}
		return resourceIndex;
	}


	public int getResourceNum(int resource) {
		int resourceNum = 0;
		switch (resource) {
		case 1:
			resourceNum = gold;
			break;
		case 2:
			resourceNum = molasses;
			break;
		case 3:
			resourceNum = sheep;
			break;
		case 4:
			resourceNum = cutlasses;
			break;
		case 5:
			resourceNum = wood;
			break;	
		}
		return resourceNum;
	}
	
	public void changeResourceNum(int resource, int changeNum) {
		switch (resource) {
		case 1:
			this.gold = changeNum + this.gold;
			break;
		case 2:
			this.molasses = changeNum + this.molasses;
			break;
		case 3:
			this.sheep = changeNum + this.sheep;
			break;
		case 4:
			this.cutlasses = changeNum + this.cutlasses;
			break;
		case 5:
			this.wood = changeNum + this.wood;
			break;
		}
		
	}

    public abstract boolean checkResources();

    public abstract void resetMarketplace();
	
}
