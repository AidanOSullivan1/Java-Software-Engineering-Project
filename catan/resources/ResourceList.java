package resources;

import java.util.ArrayList;
import java.util.List;


public class ResourceList {
	private static ResourceList resourceList1;
	private List<Resources>      resourceList;
	
	public static ResourceList getInstance(){
        if(resourceList1 == null){
        	resourceList1 = new ResourceList();
        }
        return resourceList1; //change 
    }

	
	private ResourceList() { //constructor
		this.resourceList = new ArrayList<Resources>();
		
	}
	
	public void addResourcetoList(Resources resources) { //add player to playerlist
		resourceList.add(resources);
	}
	
	public List<Resources> getList(){ //returns list of all players
    	//System.out.println(this.resourceList.toString());
    	return resourceList;
    }
	
	public Resources getResource(int index) {
		return resourceList.get(index);
	}
	

}
