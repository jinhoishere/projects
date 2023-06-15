package Hangman.src;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Alphabet extends JButton {
    private char value;
    // private int width = 0;
    // private int height = 0;

    public Alphabet(char value) {
        this.value = value;
        char data[] = {value}; // (char)content needs to be changed into (string)
        String str = new String(data); // to use the content in setText()
        this.setText(str);
        this.setBorder(BorderFactory.createEtchedBorder());
    }

    // public Alphabet(char content, int x, int y) {
    //     this.content = content;
    //     this.setText(content);
    //     this.setBorder(BorderFactory.createEtchedBorder());
    //     this.setBounds(x, y, width, height);
    // }

    public char getValue() {
        return this.value;
    }
    
    // TODO: add action listener
}
