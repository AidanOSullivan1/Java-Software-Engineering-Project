package enums;

public enum BuildLairCardEnum {
	BuildLairCard_A("BuildLairCard",1),
	BuildLairCard_B("BuildLairCard",2),
	BuildLairCard_C("BuildLairCard",3);
	
	private final String name;
	private final int index;
	
	BuildLairCardEnum(String s, int i) {
		name = s;
		index = i;
	}
	

}
