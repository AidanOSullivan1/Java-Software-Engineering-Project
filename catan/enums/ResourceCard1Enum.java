package enums;

public enum ResourceCard1Enum {
	ResourceCard1_A("ResourceCard1",1),
	ResourceCard1_B("ResourceCard1",2),
	ResourceCard1_C("ResourceCard1",3);
	
	private final String name;
	private final int index;
	
	ResourceCard1Enum(String s, int i) {
		name = s;
		index = i;
	}
	public String getName(){
		return this.name;
	}
	
	public int getIndex() {
	    return this.index;
	}
	public static Object ResourceCardA() {
		return ResourceCard1_A;
	}
	public static Object ResourceCardB() {
		return ResourceCard1_B;
	}
	public static Object ResourceCardC() {
		return ResourceCard1_C;
	}

}
