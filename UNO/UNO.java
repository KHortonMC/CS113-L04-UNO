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

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < players.size(); j++) {
                players.getNext().drawCard(deck.pollFirst());
            }
        }
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
                while (discard.size() > 1) {
                    deck.add(discard.pollFirst());
                }
                shuffleDeck();
            }

            Player player = players.getNext();
            Card card = player.attemptToPlay(discard.peekLast());

            if (card == null) {
                player.drawCard(deck.pollFirst());
            } else {
                System.out.println(player.getName() + " plays [" + card + "]");
                discard.add(card);

                if (card.getValue() == Card.Values.Reverse) {
                    players.reverseDirection();
                }
            }
    
            if (player.handSize() == 1) {
                System.out.println("UNO!");
            }
            if (player.handSize() == 0) {
                System.out.println(player.getName() + " WINS!!!");
                gameOn = false;
            }
        }
    }

    public static void main(String[] args) {
        UNO game = new UNO();
        game.play();
    }
}