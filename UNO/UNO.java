package UNO;

import java.util.LinkedList;
import java.util.Random;

public class UNO {
    LinkedList<Card> deck = new LinkedList<>();
    LinkedList<Card> discard = new LinkedList<>();
    PlayQueue<Player> players = new PlayQueue<>();
    Random random = new Random();

    public UNO() { }

    void buildDeck() {
        for (int c = 0; c < 2; c++) {
            for (int i = 0; i < Card.Colors.values().length; i++) {
                Card.Colors color = Card.Colors.values()[i];

                for (int j = 0; j < Card.Values.values().length; j++) {
                    Card.Values value = Card.Values.values()[j];

                    Card card = new Card(value, color);
                    deck.add(card);
                }
            }
        }

        shuffleDeck();

        // notice: poll removes and returns an element
        discard.add(deck.pollFirst());
    }

    void shuffleDeck() {
        int count = deck.size();
        for (int i = 0; i < count; i++) {
            int setFrom = random.nextInt(count);
            int setTo = random.nextInt(count);
            Card from = deck.get(setFrom);
            Card to = deck.get(setTo);
            deck.set(setFrom, to);
            deck.set(setTo, from);
        }
    }

    void setupPlayers() {
        players.add(new Player("Alice"));
        players.add(new Player("Bob"));
        players.add(new Player("Charlie"));
        players.add(new Player("Dana"));

        // todo: have each player draw four cards
        // from the front of the deck. 
        // tip: pollFirst removes and returns an item
    }

    boolean takeTurn(Player player) {
        System.out.println(player);

        return player.handSize() != 0;
    }

    void play() {
        buildDeck();
        setupPlayers();
        
        boolean gameOn = true;

        while (gameOn) {
            if (deck.isEmpty()) {
                // todo: copy cards from the discard pile to the deck
                // while preserving the current last card from the 
                // discard pile, then call shuffleDeck() when finished
            }

            Player player = players.getNext();
            if (player == null) {
                throw new NullPointerException("Not getting a player from PlayQueue.getNext()");
            }
            Card card = player.attemptToPlay(discard.peekLast());

            // todo: create logic to handle the playing of a card
            // 1) if a null card is returned, have the player draw
            // 2) if a valid card is returned, display a system message with player's name and card
            // 3) if the card is a reverse card, change the direction of play
            // 4) if the player has one card left after play, print out "UNO!"
            // 5) if the player has zero cards left after play, gameOn = false and print a message
        }
    }

    public static void main(String[] args) {
        UNO game = new UNO();
        game.play();
    }
}