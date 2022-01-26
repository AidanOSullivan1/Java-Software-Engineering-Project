package resources;

import java.util.ArrayList;


public class MarketPlace extends Resources {
	
	private static MarketPlace market;
	private ArrayList<Integer> marketplaceResources;

	int b = 1;
	int m = 2;
	int g = 3;
	int c = 4;
	int w = 5;
	
	public String toString() {
		return "\nMarketplace"+super.toString();
	}

	public MarketPlace(int gold, int molasses, int goats, int cutlasses, int wood) {
		super(gold, molasses, goats, cutlasses, wood);
	}
	
	public int getResourceNum(int resource) {
		return super.getResourceNum(resource);
	}
	
	public void changeResourceNum(int resource, int changeNum) {
		super.changeResourceNum(resource, changeNum);
	}
	
	public boolean checkResources() {
		return (getResourceNum(b) == 5 || getResourceNum(m) == 5 || getResourceNum(g) == 5 || getResourceNum(c) == 5 || getResourceNum(w) == 5); 
		
	}
	
	public void resetMarketplace() {
		Resources stockpile = ResourceList.getInstance().getResource(1);
		//i is the resource that is being checked to see  if 5 of its kind are in the marketplace
		//The For loop tries each resource to determine which has 5 of their type present
		for (int i = 1; i < 6; i++){
			if(getResourceNum(i) == 5) {
			for (int j = 1; j < 6; j++){
				//The overstocked resource must return 4 to the stockpile so there is only 1 remaining
				if(j==i) {
					changeResourceNum(i,-4);
					stockpile.changeResourceNum(i,4);
				}
				//One of the rest of the resources are added to the marketplace from the stockpile
				else {
					stockpile.changeResourceNum(j,-1);
					changeResourceNum(j,1);
				}
			}
			}
		}
		
		

	}

}
