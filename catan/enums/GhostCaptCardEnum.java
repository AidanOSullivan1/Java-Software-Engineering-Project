package enums;

public enum GhostCaptCardEnum {
	GhostCaptCard_A("GhostCaptCard",1),
	GhostCaptCard_B("GhostCaptCard",2),
	GhostCaptCard_C("GhostCaptCard",3),
	GhostCaptCard_D("GhostCaptCard",4),
	GhostCaptCard_E("GhostCaptCard",5),
	GhostCaptCard_F("GhostCaptCard",6),
	GhostCaptCard_G("GhostCaptCard",7),
	GhostCaptCard_H("GhostCaptCard",8),
	GhostCaptCard_I("GhostCaptCard",9),
	GhostCaptCard_J("GhostCaptCard",10),
	GhostCaptCard_K("GhostCaptCard",11);
	
	private final String name;
	private final int index;

	GhostCaptCardEnum(String s, int i) {
		name = s;
		index = i;
	}
	public String getName(){
		return this.name;
	}
	
	public int getIndex() {
	    return this.index;
	}
	


}
