// package Hangman.src;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

// mainPanel - RightPanel
public class RightPanel extends JPanel {
    // constructor
    public RightPanel() {
        setBackground(new Color(211,211,211));
        // setBackground(Color.orange);
        // setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(new GridLayout(3, 1));
    }
}
