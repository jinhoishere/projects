package Hangman.src;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class RightPanel extends JPanel {
    public RightPanel() {
        // setBackground(new Color(211,211,211));
        setBackground(Color.orange);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
