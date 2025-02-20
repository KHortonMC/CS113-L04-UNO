package UNO;

import java.util.LinkedList;

public class Player {
    private String name;
    private LinkedList<Card> hand = new LinkedList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + " " + hand;
    }

    /**
     * Returns the number of cards the player has
     * @return the number of cards in the hand
     */
    public int handSize() { 
        // todo: return the size of the player's hand
        return 0;
    }

    /**
     * Draws a card and adds it to the player hand
     * @param drawnCard A playing card
     */
    public void drawCard(Card drawnCard) { 
        // todo: add the drawn card to the player's hand    
    }

    /**
     * Check the current hand and play a card if able
     * If a card is played, remove it from the hand
     * @param topOfDiscard the card showing at the top of the deck
     * @return the card the player plays, or null
     */
    public Card attemptToPlay(Card topOfDiscard) { 
        // todo: add logic to check the hand for possible plays
        // if a valid match is found via card.canPlay(topOfDiscard)
        // remove that card from the hand and return it
        // otherwise return null
        return null; 
    }
}