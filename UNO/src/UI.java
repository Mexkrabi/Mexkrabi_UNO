import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {

    private STATE gameState;

    private JFrame frame = new JFrame();

    public UI(STATE gameState) {

        this.gameState = gameState;
        if(gameState == STATE.MENU) {
            openMenu();
        } else {
            System.out.println("UI has not been created!");
        }

    }

    public void openMenu() {
        if (this.gameState == STATE.MENU) {

            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setTitle("Mexkrabi's UNO");
            frame.setSize(new Dimension(800, 600));

            frame.setLayout(new FlowLayout());

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            JPanel p = new JPanel();

                p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
                p.add(new JLabel("Mexkrabi's UNO"));

                    JButton playButton = new JButton("Play");
                    playButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            gameState = STATE.GAME;
                            openGame();
                            p.setVisible(false);
                        }
                    });
                p.add(playButton);

                    JButton helpButton = new JButton("Help");
                    helpButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            gameState = STATE.HELP;
                            openHelp();
                            p.setVisible(false);
                        }
                    });
                p.add(helpButton);

                    JButton quitButton = new JButton("Quit");
                    quitButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("Programm closed by 'Quit' button");
                            System.exit(0);
                        }
                    });
                p.add(quitButton);

            frame.add(p);
            //frame.pack();
            p.setVisible(true);

            frame.setVisible(true);

        } else {
            throw new IllegalArgumentException("Game.STATE is not 'MENU'");
        }
    }

    public void openGame() {
        System.out.println("Game opened.");

        JPanel p = new JPanel();
            p.setLayout(new GridLayout(4, 2));

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
            JButton start_btn = new JButton("Start");
                start_btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("All right!");
                    }
                });
            p.add(start_btn);
        frame.add(p);
        p.setVisible(true);
        //frame.setVisible(true);
    }

    public void openHelp() {
        System.out.println("Help opened.");
    }

    //Getters and Setters
    public STATE getGameState() {
        return gameState;
    }
    public void setGameState(STATE gameState) {
        this.gameState = gameState;
    }
}
