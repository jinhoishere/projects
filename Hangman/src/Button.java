package Hangman.src;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Button extends JButton {
    private char value;
    // private int width = 0;
    // private int height = 0;

    public Button(char value, JPanel mainPanel, LeftLabel ll, TopPanel top, String randomWord, BottomPanel bottom) {
        char data[] = {value}; // (char) value needs to be changed into (string) value
        String str = new String(data);
        this.setText(str); // this.value = value;
        this.setBorder(BorderFactory.createEtchedBorder());
        this.addActionListener(new MyActionListener(mainPanel, ll, top, randomWord, bottom));
    }

    // public Alphabet(char content, int x, int y) {
    //     this.content = content;
    //     this.setText(content);
    //     this.setBorder(BorderFactory.createEtchedBorder());
    //     this.setBounds(x, y, width, height);
    // }

    public void setValue(char value) {
        char data[] = {value};
        String str = new String(data);
        this.setText(str);
    }

    public char getValue() {
        return this.value;
    }
}
