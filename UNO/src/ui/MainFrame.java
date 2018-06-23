package ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mexkrabi's UNO");
        setSize(new Dimension(800, 600));

        setLayout(new FlowLayout());

        setLocationRelativeTo(null);
        setVisible(true);
    }

}
