package tiles;

import enums.ResourceCard2Enum;

public class ResourcesCard2 extends Tile{

	@Override
	public String toString() {
		return super.toString();
	}

	//calls the Super constructor
	public ResourcesCard2(ResourceCard2Enum name, int index) {
		super(name, index);
	}
	
	public int indexNum() {
		setIndex(2);
		return super.indexNum();
	}


}
