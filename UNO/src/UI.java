import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {

    private JFrame frame = new JFrame();
    private JButton button = new JButton();
    private boolean readyToStart;

    public UI() {

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setTitle("Mexkrabi's UNO");
        frame.setVisible(true);
        frame.setSize(300, 100);

        button.setText("Start Game");
        button.setSize(100, 100);
        frame.add(button);

        button.add(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button pressed -> starting new game");
                UI.setReadyToStart(true);
            }
        });
    }

    public void setReadyToStart(boolean readyToStart) {
        this.readyToStart = readyToStart;
    }
    public boolean isReadyToStart() {
        return readyToStart;
    }
}
