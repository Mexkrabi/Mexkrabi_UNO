package game;

import cards.*;

public class GameLogic {

    public boolean isCardPlayable(Game game, Player player, UNOCard cardOnTable, UNOCard cardSelected) {
        //Check for players turn
        if (game.getCurrentPlayerNr() == player.getNr()) {
            //Check for legal card
            if (cardSelected.getColor() == cardOnTable.getColor() || cardSelected.getValue() == cardOnTable.getValue()) {
                return true;
            } else if (cardSelected.getType() == Type.WILD_CARD) {
                return true;
            }
        }
        return false;
    }

    public boolean validJump(Game game, Player player, UNOCard cardOnTable, UNOCard cardSelected) {
        //Check for valid jump
        if (cardSelected.getColor() == cardOnTable.getColor() && cardSelected.getValue() == cardOnTable.getValue()) {
            return true;
        }
        return false;
    }

}
