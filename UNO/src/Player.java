import java.util.*;

public class Player {

    private String name;
    private int id;
    private ArrayList<Card> hand;

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
        hand = new ArrayList<>(15);
    }

    public void drawCard(Card drawnCard) {
        hand.add(drawnCard);
        System.out.println("New Hand from " + getName() + ":");
        for(Card hand : hand) {
            System.out.println(hand);
        }
        //remove card HERE (in Game.java)
    }

    //Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
