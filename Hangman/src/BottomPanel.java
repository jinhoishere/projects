package Hangman.src;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

// mainPanel - RightPanel - BottomPanel
public class BottomPanel extends JPanel {
    // field
    private ArrayList<Button> buttons = new ArrayList<>();
    private Button b;

    // constructor
    public BottomPanel() {
        this.setBackground(new Color(211,211,211));
        // this.setBackground(Color.green);
        // There is a way to customize the layout of buttons with GridBagLayout() and GridBagConstraints()
        this.setLayout(new GridLayout(3, 9, 10, 20));
    }

    // make buttons A-Z and add them in the rightBottomPanel
    public void setButtons(JPanel mainPanel, LeftLabel ll, TopPanel top, String randomWord, BottomPanel bottom) {
        char c = 'A';
        for (int i = 0; i < 26; i++) {
            b = new Button(c, mainPanel, ll, top, randomWord, bottom); 
            // adjust numbers to arrange buttons in the panel
            // Alphabet button = new Alphabet(c, 100, 70);
            buttons.add(b);
            this.add(b);
            c += 1;
        }
    }

    // a method to get buttons in bottom panel
    public ArrayList<Button> getButtons() {
        return this.buttons;
    }

    // a method to add all buttons to bottom panel
    public void addComponents() {
        for (int i = 0; i < buttons.size(); i++) {
            this.add(buttons.get(i));
        }
    }
}
