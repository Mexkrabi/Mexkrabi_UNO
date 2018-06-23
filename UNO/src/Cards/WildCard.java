package cards;

public class WildCard extends UNOCard {

    private boolean plus4;

    public WildCard(boolean plus4, int val) {

        //val can be either 13(!plus4) or 14(plus4)
        super(Type.WILD_CARD, Color.BLACK, val);
        this.plus4 = plus4;
    }

    public Color changeColor(Color color) {
        if(color == Color.BLACK) {
            setColor(color);
        } else {
            throw new IllegalArgumentException("Color can not be set to BLACK");
        }
        return color;
    }

    //Getters and Setters
    public boolean isPlus4() {
        return plus4;
    }
}
