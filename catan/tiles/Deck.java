package tiles;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import enums.*;



public class Deck {

	//Deck is a singleton
	private static Deck deck1;
	private Queue<Tile> deck;

	public static Deck getInstance(){
        if(deck1 == null){
        	deck1 = new Deck();
        }
        return deck1;
    }
	
	
	public Queue<Tile> getDeck() {
		return deck;
	}

	
	private Deck() {
		this.deck = new LinkedList<Tile>();
		deck.add(new ResourcesCard1(ResourceCard1Enum.ResourceCard1_A,1));
		deck.add(new ResourcesCard1(ResourceCard1Enum.ResourceCard1_B,1));
		deck.add(new ResourcesCard1(ResourceCard1Enum.ResourceCard1_C,1));
		
		deck.add(new ResourcesCard2(ResourceCard2Enum.ResourceCard2_A,2));
		deck.add(new ResourcesCard2(ResourceCard2Enum.ResourceCard2_B,2));
		deck.add(new ResourcesCard2(ResourceCard2Enum.ResourceCard2_C,2));
		
		deck.add(new GhostCaptCard(GhostCaptCardEnum.GhostCaptCard_A,3));
		deck.add(new GhostCaptCard(GhostCaptCardEnum.GhostCaptCard_B,3));
		deck.add(new GhostCaptCard(GhostCaptCardEnum.GhostCaptCard_C,3));
		deck.add(new GhostCaptCard(GhostCaptCardEnum.GhostCaptCard_D,3));
		deck.add(new GhostCaptCard(GhostCaptCardEnum.GhostCaptCard_E,3));
		deck.add(new GhostCaptCard(GhostCaptCardEnum.GhostCaptCard_F,3));
		deck.add(new GhostCaptCard(GhostCaptCardEnum.GhostCaptCard_G,3));
		deck.add(new GhostCaptCard(GhostCaptCardEnum.GhostCaptCard_H,3));
		deck.add(new GhostCaptCard(GhostCaptCardEnum.GhostCaptCard_I,3));
		deck.add(new GhostCaptCard(GhostCaptCardEnum.GhostCaptCard_J,3));
		deck.add(new GhostCaptCard(GhostCaptCardEnum.GhostCaptCard_K,3));
		
		deck.add(new BuildLairCard(BuildLairCardEnum.BuildLairCard_A,4));
		deck.add(new BuildLairCard(BuildLairCardEnum.BuildLairCard_B,4));
		deck.add(new BuildLairCard(BuildLairCardEnum.BuildLairCard_C,4));
		
	}
	
	
	@Override
	public String toString() {
		return "Deck [deck=" + deck + "]";
	}


	public void ShuffleDeck() { //shuffles deck of cards
		Collections.shuffle((List<?>) deck);
	}
	
	public Tile dealCocoTile() {
		
		// Count number of cards remaining in Deck
		//int numberOfCards = deck.size();
		//int i;	
		// Deal the card
		Tile dealTile = deck.remove(); // Get from deck

		return dealTile;
	}
	/**
	 * 	Bool for whether Deck is empty of cards
	 * @return True if deck is empty false if not.
	 */
	public boolean isEmpty() {
		return deck.isEmpty();
	}
	//For Unit Testing purposes to reset the deck
	public void destroyMe() {
	    deck1 = null;
	}
	
}
