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
    public int handSize() { return hand.size(); }

    /**
     * Draws a card and adds it to the player hand
     * @param drawnCard A playing card
     */
    public void drawCard(Card drawnCard) { hand.add(drawnCard); }

    /**
     * Check the current hand and play a card if able
     * If a card is played, remove it from the hand
     * @param topOfDiscard the card showing at the top of the deck
     * @return the card the player plays, or null
     */
    public Card attemptToPlay(Card topOfDiscard) { 
        Card play = null;
        for (Card card : hand) {
            if (card.canPlay(topOfDiscard)) {
                play = card;
                break;
            }
        }
        if (play != null) {
            hand.remove(play);
        }
        return play;
     }
}