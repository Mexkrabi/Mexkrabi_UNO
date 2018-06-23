package cards;

public class ActionCard extends UNOCard {

    public enum ACTION {
        SKIP, REVERSE, PLUS_2
    }

    private ACTION actionType; //SKIP = 10, REVERSE = 11, PLUS_2 = 12

    public ActionCard(Color color, int value, ACTION actionType) {
        super(Type.ACTION_CARD, color, value);
        this.actionType = actionType;
    }



}
