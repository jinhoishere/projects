// package Hangman.src;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

// mainPanel - RightPanel - BottomPanel
public class BottomPanel extends JPanel {
    // field
    private ArrayList<Button> buttons = new ArrayList<>();
    private Button b;
    private GridBagConstraints c = new GridBagConstraints();

    // constructor
    public BottomPanel() {
        // this.setBackground(new Color(211,211,211));
        this.setBackground(Color.green);
        // There is a way to customize the layout of buttons with GridBagLayout() and GridBagConstraints()
        // this.setLayout(new GridBagLayout());
        this.setLayout(new GridLayout(3, 9, 10, 20));
    }

    // private void setMyConstraints(GridBagConstraints c, int gridx, int gridy, int gridwidth, int gridheight, int anchor, int fill) {
    //     c.gridx = gridx;
    //     c.gridy = gridy;
    //     c.gridwidth = gridwidth;
    //     c.gridheight = gridheight;
    //     c.anchor = anchor;
    //     c.fill = fill;
    // }

    // make buttons A-Z and add them in the rightBottomPanel
    public void setButtons(JPanel mainPanel, LeftLabel ll, TopPanel top, String randomWord, BottomPanel bottom) {
        char c = 'A';
        for (int i = 0; i < 26; i++) {
            b = new Button(c, mainPanel, ll, top, randomWord, bottom); 
            buttons.add(b);
            this.add(b);
            c += 1;
        }
    }

    // // make buttons A-Z and add them in the rightBottomPanel
    // public void setButtons_row1(JPanel mainPanel, LeftLabel ll, TopPanel top, String randomWord, BottomPanel bottom) {
    //     char buttonValue_row1 = 'A';
    //     int x = 0;
    //     for (int i = 0; i < 10; i++) {
    //         b = new Button(buttonValue_row1, mainPanel, ll, top, randomWord, bottom); 
    //         // adjust numbers to arrange buttons in the panel
    //         // Alphabet button = new Alphabet(c, 100, 70);
    //         setMyConstraints(c, x, 0, 2, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
    //         buttons.add(b);
    //         this.add(b, c);
    //         x += 2;
    //         buttonValue_row1 += 1;
    //     }
    // }

    // public void setButtons_row2(JPanel mainPanel, LeftLabel ll, TopPanel top, String randomWord, BottomPanel bottom) {
    //     char buttonValue_row2 = 'K';
    //     int x = 1;
    //     for (int i = 10; i < 19; i++) {
    //         b = new Button(buttonValue_row2, mainPanel, ll, top, randomWord, bottom);
    //         setMyConstraints(c, x, 3, 2, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
    //         buttons.add(b);
    //         this.add(b, c);
    //         x += 2;
    //         buttonValue_row2 += 1;
    //     }
    // }

    // public void setButtons_row3(JPanel mainPanel, LeftLabel ll, TopPanel top, String randomWord, BottomPanel bottom) {
    //     char buttonValue_row3 = 'T';
    //     int x = 3;
    //     for (int i = 19; i < 26; i++) {
    //         b = new Button(buttonValue_row3, mainPanel, ll, top, randomWord, bottom);
    //         setMyConstraints(c, x, 5, 2, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
    //         buttons.add(b);
    //         this.add(b, c);
    //         x += 2;
    //         buttonValue_row3 += 1;
    //     }
    // }

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
