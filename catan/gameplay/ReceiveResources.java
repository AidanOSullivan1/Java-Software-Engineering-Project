package gameplay;

import java.util.ArrayList;

import players.*;
import resources.Resources;
import setup.IslandSetup;
import setup.LairResourceMap;

public class ReceiveResources {

	

public static void diceResources(int diceRoll) { //gives reources to player from dice roll

	ArrayList<IslandSetup> islandList = new ArrayList<IslandSetup>(); 
	islandList.addAll(LairResourceMap.diceIslandLink(diceRoll)); //list of islands which match dice roll

	for (int j = 0; j < PlayerList.getInstance().getNumPlayers(); j++) { //cycles through players in playerlist
		for(int k=0 ; k< islandList.size();k++) { //cycle through diff islands which are activated by dice
			for(int o=0; o < PlayerList.getInstance().getPlayer(j).getLairsBuilt().size(); o++){ //cycles through players lairs
				for(int p =0 ; p < LairResourceMap.islandLairLink(islandList.get(k)).size(); p++){ //cycles through islands lairs
					if((LairResourceMap.islandLairLink(islandList.get(k)).get(p)).equals(PlayerList.getInstance().getPlayer(j).getLairsBuilt().get(o))){ //matches players lair with island its on
						if(islandList.get(k).getGhostCapt() == 0) { //if no ghost captain
							PlayerList.getInstance().getPlayer(j).changeResourceNum(Resources.getResourceIndex(islandList.get(k).getIslandRes()), 1); //gives resource from island it matched with
							}
						}
					}	
			
				}
			}
		}
	}

}

