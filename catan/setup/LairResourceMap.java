package setup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LairResourceMap {
	//islands being created
	static IslandSetup island1 = new IslandSetup(1, 6, 2, 10, 2, 10, 4, 6, 4, 3, 'W');
	static IslandSetup island2 = new IslandSetup(2, 6, 6, 10, 6, 10, 8, 6, 8, 5, 'G');
	static IslandSetup island3 = new IslandSetup(3, 2, 8, 6, 8, 6, 10, 2, 10, 1, 'W');
	static IslandSetup island4 = new IslandSetup(4, 6, 10, 10, 10, 10, 12, 6, 12, 6, '?');
	static IslandSetup island5 = new IslandSetup(5, 10, 8, 14, 8, 14, 10, 10, 10, 2, 'W');
	static IslandSetup island6 = new IslandSetup(6, 2, 12, 6, 12, 6, 14, 2, 14, 2, 'S');
	static IslandSetup island7 = new IslandSetup(7, 6, 14, 10, 14, 10, 16, 6, 16, 3, 'G');
	static IslandSetup island8 = new IslandSetup(8, 10, 12, 14, 12, 14, 14, 10, 14, 1, 'S');
	static IslandSetup island9 = new IslandSetup(9, 6, 18, 10, 18, 10, 20, 6, 20, 5, 'S');

	static IslandSetup eIsland1 = new IslandSetup(10, 2, 4, 6, 4, 6, 6, 2, 6, 4, 'C');
	static IslandSetup eIsland2 = new IslandSetup(11, 10, 4, 14, 4, 14, 6, 10, 6, 1, 'C');
	static IslandSetup eIsland3 = new IslandSetup(12, 2, 16, 6, 16, 6, 18, 2, 18, 4, 'M');
	static IslandSetup eIsland4 = new IslandSetup(13, 10, 16, 14, 16, 14, 18, 10, 18, 2, 'M');

	//Lair locations being created
	static List<Integer> islandLocations1 = Arrays.asList(71, 91, 53, 113, 75, 95); // Lair locations adjacent to island 1															
	static List<Integer> islandLocations2 = Arrays.asList(75, 95, 57, 117, 79, 99);
	static List<Integer> islandLocations3 = Arrays.asList(37, 57, 19, 79, 311, 511);
	static List<Integer> islandLocations4 = Arrays.asList(79, 99, 511, 1111, 713, 913);
	static List<Integer> islandLocations5 = Arrays.asList(117, 137, 99, 159, 1111, 1311);
	static List<Integer> islandLocations6 = Arrays.asList(311, 511, 113, 713, 315, 515);
	static List<Integer> islandLocations7 = Arrays.asList(713, 913, 515, 1115, 717, 917);
	static List<Integer> islandLocations8 = Arrays.asList(1111, 1311, 913, 1513, 1115, 1315);
	static List<Integer> islandLocations9 = Arrays.asList(717, 917, 519, 1119, 721, 921);

	static List<Integer> eIslandLocations1 = Arrays.asList(53, 75, 37, 57); // Lair locations adjacent to edge island 1
	static List<Integer> eIslandLocations2 = Arrays.asList(113, 95, 117, 137);
	static List<Integer> eIslandLocations3 = Arrays.asList(315, 515, 717, 519);
	static List<Integer> eIslandLocations4 = Arrays.asList(1115, 1315, 917, 1119);

	//array list to hold dice lair link
	static ArrayList<Integer> diceLairLink1 = new ArrayList<Integer>();
	static ArrayList<Integer> diceLairLink2 = new ArrayList<Integer>();
	static ArrayList<Integer> diceLairLink3 = new ArrayList<Integer>();
	static ArrayList<Integer> diceLairLink4 = new ArrayList<Integer>();
	static ArrayList<Integer> diceLairLink5 = new ArrayList<Integer>();
	
	

	public static ArrayList<Integer> islandLairLink(IslandSetup island) { //method which links island to its lairs

		int islID = island.getIslID(); // gets id of input island
		ArrayList<Integer> islandLairList = new ArrayList<Integer>();
		islandLairList.clear();

		switch (islID) {
		case 1:
			islandLairList.addAll(islandLocations1);
			break;
		case 2:
			islandLairList.addAll(islandLocations2);
			break;
		case 3:
			islandLairList.addAll(islandLocations3);
			break;
		case 4:
			islandLairList.addAll(islandLocations4);
			break;
		case 5:
			islandLairList.addAll(islandLocations5);
			break;
		case 6:
			islandLairList.addAll(islandLocations6);
			break;
		case 7:
			islandLairList.addAll(islandLocations7);
			break;
		case 8:
			islandLairList.addAll(islandLocations8);
			break;
		case 9:
			islandLairList.addAll(islandLocations9);
			break;
		case 10:
			islandLairList.addAll(eIslandLocations1);
			break;
		case 11:
			islandLairList.addAll(eIslandLocations2);
			break;
		case 12:
			islandLairList.addAll(eIslandLocations3);
			break;
		case 13:
			islandLairList.addAll(eIslandLocations4);
			break;
		}
		return islandLairList;
	}

	public static void createIslands() { //sets islands on map
		// add islands to the board
		getIsland1().setIsland();
		island2.setIsland();
		island3.setIsland();
		island4.setIsland();
		island5.setIsland();
		island6.setIsland();
		island7.setIsland();
		island8.setIsland();
		island9.setIsland();

		eIsland1.setEdgeIslandL();
		eIsland2.setEdgeIslandR();
		eIsland3.setEdgeIslandL();
		eIsland4.setEdgeIslandR();
	}

	public static ArrayList<IslandSetup> diceIslandLink(int diceRoll) { // links dice roll with islands
		ArrayList<IslandSetup> islandList = new ArrayList<IslandSetup>();
		
		switch (diceRoll) {
		case 1:
			islandList.add(eIsland2);
			islandList.add(island3);
			islandList.add(island8);
			break;
		case 2:
			islandList.add(eIsland4);
			islandList.add(island5);
			islandList.add(island6);
			break;
		case 3:
			islandList.add(getIsland1());
			islandList.add(island7);
			break;
		case 4:
			islandList.add(eIsland1);
			islandList.add(eIsland3);
			break;
		case 5:
			islandList.add(island2);
			islandList.add(island9);
			break;

		}
		return islandList;
	}

	public static void diceLairLink() { // links the dice roll with the island locations
		diceLairLink1.addAll(islandLocations3);
		diceLairLink1.addAll(islandLocations8);
		diceLairLink1.addAll(eIslandLocations2);
		diceLairLink2.addAll(islandLocations5);
		diceLairLink2.addAll(islandLocations6);
		diceLairLink2.addAll(eIslandLocations4);
		diceLairLink3.addAll(islandLocations1);
		diceLairLink3.addAll(islandLocations7);
		diceLairLink4.addAll(eIslandLocations1);
		diceLairLink4.addAll(eIslandLocations3);
		diceLairLink5.addAll(islandLocations2);
		diceLairLink5.addAll(islandLocations9);
	}

	// getters for islands

	public static IslandSetup getIsland1() {
		return island1;
	}

	public static IslandSetup getIsland2() {
		return island2;
	}

	public static IslandSetup getIsland3() {
		return island3;
	}

	public static IslandSetup getIsland4() {
		return island4;
	}

	public static IslandSetup getIsland5() {
		return island5;
	}

	public static IslandSetup getIsland6() {
		return island6;
	}

	public static IslandSetup getIsland7() {
		return island7;
	}

	public static IslandSetup getIsland8() {
		return island8;
	}

	public static IslandSetup getIsland9() {
		return island9;
	}

	public static IslandSetup geteIsland1() {
		return eIsland1;
	}

	public static IslandSetup geteIsland2() {
		return eIsland2;
	}

	public static IslandSetup geteIsland3() {
		return eIsland3;
	}

	public static IslandSetup geteIsland4() {
		return eIsland4;
	}

}
