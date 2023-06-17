package Hangman.src;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

// RightPanel - BottomPanel
public class BottomPanel extends JPanel {
    private ArrayList<Alphabet> buttons;

    public BottomPanel() {
        setBackground(new Color(211,211,211));
        // this.setBackground(Color.green);
        //TODO: There will be a way to customize the layout of buttons with GridBagLayout() and GridBagConstraints()
        setLayout(new GridLayout(3, 9, 10, 20));
        setButtons();
    }

    // RightBottomPanel
    // make buttons A-Z and add them in the rightBottomPanel
    public void setButtons() {
        char c = 'A';
        buttons = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            Alphabet button = new Alphabet(c); // adjust numbers to arrange buttons in the panel
            // Alphabet button = new Alphabet(c, 100, 70);
            button.addActionListener(new MyActionListener());
            buttons.add(button);
            this.add(button);
            c += 1;
        }
    }

    public ArrayList<Alphabet> getButtons() {
        return buttons;
    }
}
