// package Hangman.src;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

// mainPanel - RightPanel - BottomPanel - button
public class Button extends JButton {
    // field
    private char value;
    // private int width = 0;
    // private int height = 0;

    // constructor
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

    // a method to set a value to a button
    public void setValue(char value) {
        char data[] = {value};
        String str = new String(data);
        this.setText(str);
    }

    // a method to get a value in a button
    public char getValue() {
        return this.value;
    }
}
