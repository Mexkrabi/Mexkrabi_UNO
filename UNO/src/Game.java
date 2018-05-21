import java.util.*;

public class Game {

    public Card[] allCards;
    public ArrayList<Card> deck;
    public ArrayList<Player> players;

    public Game() {
        //create cards
        /**
         * card order/ids:
         *      0-9: red_1 0-9
         *      10-19: yellow_1 0-9
         *      20-29: green_1 0-9
         *      30-39: blue_1 0-9
         *
         *      40-48: red_2 1-9
         *      49-57: yellow_2 1-9
         *      58-66: green_2 1-9
         *      67-75: blue_2 1-9
         *
         *      76-77: red skip
         *      78-79: yellow skip
         *      80-81: green skip
         *      82-83: blue skip
         *
         *      84-85: red reverse
         *      86-87: yellow reverse
         *      88-89: green reverse
         *      90-91: blue reverse
         *
         *      92-93: red +2
         *      94-95: yellow +2
         *      96-97: green +2
         *      98-99: blue +2
         *
         *      100-103: black choose
         *      104-107: black +4
         */
        System.out.println("Creating Cards...");
        allCards = new Card[108];
        for(int id = 0; id < 108; id++) {
            allCards[id] = new Card(id);
            System.out.println(allCards[id] + ", ID: " + allCards[id].getId() + ", Color: " + allCards[id].getColor() + ", Value: " + allCards[id].getValue() + ", Wildcard: " + allCards[id].isWildCard());

        }

        //mix deck
        deck = new ArrayList<>(108);
        Collections.addAll(deck, allCards);
        Collections.shuffle(deck);
        deck.trimToSize();
        System.out.println("Deck Order:");
        for(Card deck : deck) {            //Link: http://www.dreamincode.net/forums/topic/185660-how-to-get-class-attributes-from-arraylist/
            System.out.println(deck.getId());//how to access an attribute
        }

        //create players
        players = new ArrayList<>(4);
        System.out.println("Players:");
        players.add(0,new Player("Player 1", 1));
        players.add(1,new Player("Player 2", 2));
        players.add(2,new Player("Player 3", 3));
        players.add(3,new Player("Player 4", 4));
        for(Player players : players) {
            System.out.println("Name: " + players.getName() + ", ID: " + players.getId());
        }

        //players draw cards (7 at the beginning)
        for(int i = 0; i < 7; i++) {
            /**
             * Card drawing sequence:
             * 1. use method drawCard(Card drawnCard) from Player.java
             * 2. insert method topCard() from Game.java as parameter drawnCard
             * 3. execute method removeTopCard() from Game.java immediatly after steps 1. and 2.
             */
            players.get(0).drawCard(topCard());
            removeTopCard();
            players.get(1).drawCard(topCard());
            removeTopCard();
            players.get(2).drawCard(topCard());
            removeTopCard();
            players.get(3).drawCard(topCard());
            removeTopCard();
        }
    }

    public Card topCard() {
        System.out.println(deck.get(0));
        return deck.get(0);
    }
    public void removeTopCard() {
        deck.remove(0);
    }
}
