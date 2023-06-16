package Hangman.src;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

// RightPanel - BottomPanel
public class BottomPanel extends JPanel {
    public BottomPanel() {
        // this.setBackground(new Color(211,211,211));
        this.setBackground(Color.green);
        //TODO: There will be a way to customize the layout of buttons with GridBagLayout() and GridBagConstraints()
        this.setLayout(new GridLayout(3, 9, 10, 20));
        setButtonsAt(this);
    }

    // RightBottomPanel
    // make buttons A-Z and add them in the rightBottomPanel
    public static void setButtonsAt(JPanel rightBottomPanel) {
        char c = 'A';
        for (int i = 0; i < 26; i++) {
            Alphabet button = new Alphabet(c); // adjust numbers to arrange buttons in the panel
            // Alphabet button = new Alphabet(c, 100, 70);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("You chose " + "\"" + button.getValue() + "\"");
                    button.setEnabled(false);
                }
            });
            rightBottomPanel.add(button);
            c += 1;
        }
    }
}
