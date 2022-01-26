package tiles;

import enums.GhostCaptCardEnum;


public class GhostCaptCard extends Tile{
	
	@Override
	public String toString() {
		return super.toString();
	}

		//calls the Super constructor
		public GhostCaptCard(GhostCaptCardEnum name,int index) {
			super(name,index);
		}
		
}
