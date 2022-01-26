package board;


public class BoardLegend {
	
	
	public static void printLegend() {
		System.out.println("\n-------------Catan Junior Legend-------------");
		System.out.println("\n O - Lair location \t ~ - Ship Location");
		System.out.println("\n\033[0;31m O \033[0m- Red Lair  \t\033[0;36m  O \033[0m- Blue Lair");
		System.out.println("\n\033[0;35m O \033[0m- Purple Lair \033[0;32m O \033[0m- Green Lair");
		System.out.println("\n\033[0;31m ~ \033[0m- Red Ship  \t\033[0;36m  ~ \033[0m- Blue Ship");
		System.out.println("\n\033[0;35m ~ \033[0m- Purple Ship \033[0;32m ~ \033[0m- Green Ship");
		System.out.println("\n W - Wood \t  C - Cutlasses");
		System.out.println("\n G - Gold \t  S - Goats");
		System.out.println("\n M - Molasses \t  X - Ghost Captain  \t ? - Spooky Island\n");
		System.out.println("------------------------------------------------------\n");
		
	}

}
