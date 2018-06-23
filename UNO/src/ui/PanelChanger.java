package ui;

import game.Main;

public class PanelChanger {

    public PanelChanger() {
        update();
    }

    public void update(){
        switch(Main.getGameState()) {
            case MENU:
                Main.mainFrame.add(new MainMenu());
                break;
            case HELP:
                Main.mainFrame.add(new Help());
                break;
            case LOGIN:
                Main.mainFrame.add(new Login());
                break;
        }
    }

}
