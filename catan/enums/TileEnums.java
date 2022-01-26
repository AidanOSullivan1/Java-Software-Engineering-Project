package enums;

public enum TileEnums { //enums which correspond to charachters on thye map
	
    LAIR_SPOT   (" O "),
    MISC        ("   "),
    SHIP_PATH   (" ~ "),
    REDLAIR     ("\033[0;31m O \033[0m"), //colour codes from eclipse marketplace package
    BLUELAIR    ("\033[0;36m O \033[0m"),
    PURPLELAIR   ("\033[0;35m O \033[0m"),
    GREENLAIR  ("\033[0;32m O \033[0m"),
    REDSHIP     ("\033[0;31m ~ \033[0m"), //colour codes from eclipse marketplace package
    BLUESHIP    ("\033[0;36m ~ \033[0m"),
    PURPLESHIP   ("\033[0;35m ~ \033[0m"),
    GREENSHIP  ("\033[0;32m ~ \033[0m"),
    SHIP        (" S "),
	ISLAND      ("   "),
	GHOSTCAPT   (" X ");
    private String         mapChar;
    /*
	public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String PRINT_BLACK = "\033[0;30m";   // BLACK
    public static final String PRINT_RED = "\033[0;31m";     // RED
    public static final String PRINT_GREEN = "\033[0;32m";   // GREEN
    public static final String PRINT_YELLOW = "\033[0;33m";  // YELLOW
    public static final String PRINT_BLUE = "\033[0;34m";    // BLUE
    public static final String PRINT_PURPLE = "\033[0;35m";  // PURPLE
    public static final String PRINT_CYAN = "\033[0;36m";    // CYAN
    public static final String PRINT_WHITE = "\033[0;37m";   // WHITE
   */

    private TileEnums(String c){
        mapChar = c; // char for default representation on Board
    }
    
    public String getChar() {
        return mapChar;
    }
}
