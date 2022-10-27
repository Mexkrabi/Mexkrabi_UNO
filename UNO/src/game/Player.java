package game;

import Cards.UNOCard;

import java.util.ArrayList;

public class Player {

    private String name;
    private int nr;
    private ArrayList<UNOCard> hand;
    private int cards;

    private Game game;

    public Player(String name, int nr) {
        this.name = name;
        this.nr = nr;

        hand = new ArrayList<>();
        cards = 0;
    }


    public void drawCard(Game game) {
        UNOCard c = game.topCard();
        addCard(c);
        game.removeTopCard();
    }
    private void addCard(UNOCard card) {
        hand.add(card);
        cards += 1;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getNr() {
        return nr;
    }
    public void setNr(int nr) {
        this.nr = nr;
    }

    public ArrayList<UNOCard> getHand() {
        return hand;
    }

    public int getCards() {
        return cards;
    }
}
