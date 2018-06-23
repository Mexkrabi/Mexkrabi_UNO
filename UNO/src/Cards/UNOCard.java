package Cards;

public class UNOCard {

    private Type type;
    private Color color;
    private int value;


    public UNOCard(Type type, Color color, int value) {

        this.type = type;
        this.color = color;
        this.value = value;

    }

    //Getters and Setters
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }

    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
