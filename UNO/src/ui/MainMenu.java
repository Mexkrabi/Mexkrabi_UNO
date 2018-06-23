package ui;

import game.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel implements ActionListener {

    private JPanel p = new JPanel();
    private JButton playButton = new JButton("Play");
    private JButton helpButton = new JButton("Help");
    private JButton quitButton = new JButton("Quit");

    public MainMenu() {

        if(Main.getGameState() == STATE.MENU) {

            p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
            p.add(new JLabel("Mexkrabi's UNO"));


            playButton.addActionListener(this);
            p.add(playButton);

            helpButton.addActionListener(this);
            p.add(helpButton);

            quitButton.addActionListener(this);
            p.add(quitButton);

            Main.mainFrame.add(p);
            //f.pack();
            p.setVisible(true);

            Main.mainFrame.setVisible(true);

        } else {
            throw new IllegalArgumentException("game.STATE is not MENU");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton src = (JButton) e.getSource();

        if(src == playButton) {
            Main.setGameState(STATE.LOGIN);
            p.setVisible(false);
        }
        if(src == helpButton) {
            Main.setGameState(STATE.HELP);
            p.setVisible(false);
        }
        if(src == quitButton) {
            System.out.println("Programm closed by 'Quit' button");
            System.exit(0);
        }

    }
}
