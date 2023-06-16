package Hangman.src;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class RightPanel extends JPanel {
    public RightPanel() {
        // this.setBackground(new Color(211,211,211));
        this.setBackground(Color.orange);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
