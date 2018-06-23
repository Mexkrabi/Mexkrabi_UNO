package game;

import cards.*;

import java.util.ArrayList;
import java.util.Collections;

public class Game extends GameLogic {

    public ArrayList<UNOCard> deck = new ArrayList<>(108);
    public ArrayList<Player> players = new ArrayList<>(4);

    private int currentPlayerNr;

    //private GameLogic logic = new GameLogic();

    public Game() {

        //creating wild cards
        System.out.println("creating wild cards");
        for(int i = 0; i < 4; i++) {
            deck.add(new WildCard(false, 13));
            deck.add(new WildCard(true, 14));
        }
        System.out.println("wild cards created");

        //creating action cards
        System.out.println("creating action cards");
        for(int i = 0; i < 2; i++) {
            deck.add(new ActionCard(Color.RED, 10, ActionCard.ACTION.SKIP));
            deck.add(new ActionCard(Color.YELLOW, 10, ActionCard.ACTION.SKIP));
            deck.add(new ActionCard(Color.GREEN, 10, ActionCard.ACTION.SKIP));
            deck.add(new ActionCard(Color.BLUE, 10, ActionCard.ACTION.SKIP));

            deck.add(new ActionCard(Color.RED, 11, ActionCard.ACTION.REVERSE));
            deck.add(new ActionCard(Color.YELLOW, 11, ActionCard.ACTION.REVERSE));
            deck.add(new ActionCard(Color.GREEN, 11, ActionCard.ACTION.REVERSE));
            deck.add(new ActionCard(Color.BLUE, 11, ActionCard.ACTION.REVERSE));

            deck.add(new ActionCard(Color.RED, 12, ActionCard.ACTION.PLUS_2));
            deck.add(new ActionCard(Color.YELLOW, 12, ActionCard.ACTION.PLUS_2));
            deck.add(new ActionCard(Color.GREEN, 12, ActionCard.ACTION.PLUS_2));
            deck.add(new ActionCard(Color.BLUE, 12, ActionCard.ACTION.PLUS_2));
        }
        System.out.println("action cards created");

        //creating color cards
        System.out.println("creating color cards");
        deck.add(new ColorCard(Color.RED, 0));
        deck.add(new ColorCard(Color.YELLOW, 0));
        deck.add(new ColorCard(Color.GREEN, 0));
        deck.add(new ColorCard(Color.BLUE, 0));

        for(int z = 0; z < 2; z++) {
            for (int i = 1; i < 10; i++) {
                deck.add(new ColorCard(Color.RED, i));
                deck.add(new ColorCard(Color.YELLOW, i));
                deck.add(new ColorCard(Color.GREEN, i));
                deck.add(new ColorCard(Color.BLUE, i));
            }
        }
        System.out.println("color cards created");

        System.out.println("All cards created. List:");
        for(UNOCard card : deck) {
            System.out.println("Card: " + card.getType() + ", " + card.getValue() + ", " + card.getColor());
        }

        //mix deck
        Collections.shuffle(deck);
        System.out.println("Deck mixed\nOrder:");
        for(UNOCard card : deck) {
            System.out.println("Card: " + card.getType() + ", " + card.getValue() + ", " + card.getColor());
        }

        System.out.println("Deck size: " + deck.size());

    }

    public UNOCard topCard() {
        System.out.println("Top Card: " + deck.get(0));
        return deck.get(0);
    }
    public void removeTopCard() {
        deck.remove(0);
    }

    //Getters and Setters
    public int getCurrentPlayerNr() {
        return currentPlayerNr;
    }

}
