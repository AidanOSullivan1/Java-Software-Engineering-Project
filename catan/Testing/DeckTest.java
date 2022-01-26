package Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import tiles.BuildLairCard;
import tiles.Deck;
import tiles.GhostCaptCard;
import tiles.ResourcesCard1;
import tiles.ResourcesCard2;
import tiles.Tile;

class DeckTest {

	@Test
	public void testDeck() {
		 
		  //Checks the number of cards in the deck
		 
		 assertEquals("The deck of cocotiles should have  20",   20, Deck.getInstance().getDeck().size());
		 
		 //Using the known initial order, a check is carried out to ensure that all 4 cocotiles are present
		 
		 assertTrue("The first card should be a Resource Card 1",  Deck.getInstance().getDeck().peek() instanceof ResourcesCard1  );
		 removeQueueElements(3);
		 assertTrue("The fourth card should be a Resource Card 2",  Deck.getInstance().getDeck().peek() instanceof ResourcesCard2  );
		 removeQueueElements(3);
		 assertTrue("The seventh card should be a Ghost Capatain Card",  Deck.getInstance().getDeck().peek() instanceof GhostCaptCard  );
		 removeQueueElements(11);
		 assertTrue("The seventeenth card should be a Build Lair Card",  Deck.getInstance().getDeck().peek() instanceof BuildLairCard  );
		 //Resets the Deck
		 Deck.getInstance().destroyMe();
	}
	
	 @Test
	    // tests that when all the cards have been dealt from the deck that it returns that it is empty.
	 public void testIsEmpty() {
	    	Deck testDeck= Deck.getInstance();
	        
	        @SuppressWarnings("unused")
	        Tile dealtCocotile;
	        
	        // Initial Deck size is 20 cards
	        assertFalse("Deck should not yet be empty!",Deck.getInstance().isEmpty());
	        
	        for (int i=0; i<19; i++) { // Deal 19 cards
	        	dealtCocotile = Deck.getInstance().dealCocoTile();
	            assertFalse("Deck should not yet be empty!",Deck.getInstance().isEmpty());
	        }
	        
	        dealtCocotile = Deck.getInstance().dealCocoTile();
	        assertTrue("Deck should be empty!",Deck.getInstance().isEmpty());
	        testDeck.destroyMe();
	    }
	
	
	
	public void removeQueueElements(int remove)
	{
		 for (int i = 0; i < remove; i++) {
			 Deck.getInstance().getDeck().remove();
		 }
	}
}
