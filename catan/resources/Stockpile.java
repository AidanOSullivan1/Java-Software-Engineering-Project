package resources;


public class Stockpile extends Resources {
	
	public String toString() {
		return "\nStockpile"+super.toString();
	}

	public Stockpile(int gold, int molasses, int goats, int cutlasses, int wood) {
		super(gold, molasses, goats, cutlasses, wood);
	}
	
	public int getResourceNum(int resource) {
		return super.getResourceNum(resource);
	}
	
	public void changeResourceNum(int resource, int changeNum) {
		super.changeResourceNum(resource, changeNum);
	}

	@Override
	public boolean checkResources() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resetMarketplace() {
		// TODO Auto-generated method stub
		
	}
	public String getResourceString(int resource) {
		return super.getResourceString(resource);
	}

}
