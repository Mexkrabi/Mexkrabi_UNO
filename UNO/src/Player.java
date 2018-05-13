import java.util.*; //help with ArrayList -> http://www.codeadventurer.de/?p=1751

public class Player {

    private String playername;
    private int id;

    private int cards;
    private ArrayList<Card> playercards = new ArrayList<>();

    public Player(String playername, int id, int cards) {
        this.playername = playername;
        this.id = id;
        this.cards = cards;
    }

    public void drawCard() {
        Game g = Main.game;
        ListIterator<Card> deck_it = g.deck.listIterator(0); //NullPointerException Why???
        Card cardDrawn = deck_it.next();
        playercards.add(cardDrawn);
        g.deck.remove(0);
    }

    /**
     * Getters & Setters
     */
    public String getPlayername() {
        return this.playername;
    }
    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getCards() {
        return this.cards;
    }
    public void setCards(int cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getPlayercards() {
        return this.playercards;
    }
}
