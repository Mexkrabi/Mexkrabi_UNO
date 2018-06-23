package ui;

import game.Main;
import game.STATE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel implements ActionListener {

    private JButton start_btn = new JButton("Start");
    private JPanel panel = new JPanel();

    public Login() {

        if (Main.getGameState() == STATE.LOGIN) {

            System.out.println("Login screen opened.");

            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            JPanel p = new JPanel(new GridLayout(4, 2));
            //setLayout(new GridLayout(4, 2));

            for (int i = 1; i < 5; i++) {
                p.add(new JLabel("Player " + i + ":"));
                switch (i) {
                    case 1:
                        JTextField name1 = new JTextField("", 10);
                        p.add(name1);
                        break;
                    case 2:
                        JTextField name2 = new JTextField("", 10);
                        p.add(name2);
                        break;
                    case 3:
                        JTextField name3 = new JTextField("", 10);
                        p.add(name3);
                        break;
                    case 4:
                        JTextField name4 = new JTextField("", 10);
                        p.add(name4);
                        break;
                }
            }

            panel.add(p);
            p.setVisible(true);
            start_btn.addActionListener(this);
            panel.add(start_btn);
            this.add(panel);
            Main.mainFrame.add(this);
            panel.setVisible(true);
            this.setVisible(true);
            Main.mainFrame.setVisible(true);

        } else {
            throw new IllegalArgumentException("game.STATE is not LOGIN");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton src = (JButton) e.getSource();

        if(src == start_btn) {
            System.out.println("All right!");
        }
    }
}
