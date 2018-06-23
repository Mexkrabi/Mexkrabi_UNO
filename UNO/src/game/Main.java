package game;

import ui.*;

public class Main {

    public static MainFrame mainFrame;
    private static STATE gameState;
    private static PanelChanger panelChanger;

    public static void main(String[] args) {

        gameState = STATE.MENU;
        mainFrame = new MainFrame();
        panelChanger = new PanelChanger();

        Game game = new Game();
    }

    public static STATE getGameState() {
        return gameState;
    }
    public static void setGameState(STATE newGameState) {
        gameState = newGameState;
        panelChanger.update();
    }
}
