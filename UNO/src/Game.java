import java.util.*;

public class Game {

    private Card[] allCards;
    public ArrayList<Card> deck;
    public ArrayList<Player> players;

    private ListIterator<Player> players_it;
    private int currentPlayerId;
    private boolean gameDirectionIncreasing;
    private Card cardOnTable;
    private int stacker; //value for stacking +2 and +4 cards

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

        gameDirectionIncreasing = true;
        //Starting player:
        players_it = players.listIterator();
        playerChange();

        //first card:
        cardOnTable = topCard();
        removeTopCard();
        System.out.println("Card on the table: " + cardOnTable);

        System.out.println("Ready to start");
    }

    //turn
    public void newTurn() {
        for (int i = 0; i < 4; i++)
            //check for current player
            if (currentPlayerId == players.get(i).getId()) {
                Player p = players.get(i);
                p.playCard(card); //not ready yet
                break;
        }
    }

    public Card topCard() {
        System.out.println("Top Card: " + deck.get(0));
        return deck.get(0);
    }
    public void removeTopCard() {
        deck.remove(0);
    }

    private void playerChange() {
        if (isGameDirectionIncreasing()) {
            if (players_it.hasNext()) {
                currentPlayerId = players_it.next().getId();
            } else {
                players_it = players.listIterator(0);
                currentPlayerId = players.get(0).getId();
            }
        } else {
            if (players_it.hasPrevious()) {
                currentPlayerId = players_it.previous().getId();
            } else {
                players.listIterator(3);
                currentPlayerId = players.get(3).getId();
            }
        }
    System.out.println("Now Playing: Player " + currentPlayerId);
    }

    //card actions
    public void cardAction(Card card) {
        if (card.getValue() == 10) { //skip card
            playerChange();
        }
        if (card.getValue() == 11) { //reverse card
            changeGameDirection();
            playerChange(); //needed to get the right player afterwards
        }
        if (card.getValue() == 12) { //+2 cards
            stacker += 2;
        }
        if (card.getValue() == 13) { //choose card
            //change color
        }
        if (card.getValue() == 14) { //+4 card
            stacker += 4;
            //change color
        }
    }

    public boolean isCardPlayable(Card card) {
        if (card.getValue() == cardOnTable.getValue() || card.getColor().equals(cardOnTable.getColor()) || card.isWildCard()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isGameWon() {
        boolean gameWon = false;
        for (int i = 0; i < 4; i++) {
            if (!players.get(i).getHand().isEmpty()) {
                gameWon = true;
                System.out.println(players.get(i).getName() + " won the game!");
            }
        }
        return gameWon;
    }

    //Getters and Setters
    public boolean isGameDirectionIncreasing() {
        return gameDirectionIncreasing;
    }
    public void changeGameDirection() {
        gameDirectionIncreasing = !gameDirectionIncreasing;
    }

    public int getCurrentPlayerId() {
        return currentPlayerId;
    }
    public void setCurrentPlayerId(int currentPlayerId) {
        this.currentPlayerId = currentPlayerId;
    }

    public Card getCardOnTable() {
        return cardOnTable;
    }
    public void setCardOnTable(Card cardOnTable) {
        this.cardOnTable = cardOnTable;
    }
}
