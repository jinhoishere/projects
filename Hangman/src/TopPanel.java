package Hangman.src;

import java.util.*;
import javax.swing.*;
import java.awt.*;

// RightPanel - TopPanel
public class TopPanel extends JPanel {
    private String randomWord;
    private JLabel currentUnderscore;
    private ArrayList<JLabel> underscores = new ArrayList<>();
    private ArrayList<Character> answers = new ArrayList<>();

    public TopPanel() {
        // this.setBackground(Color.yellow);
        this.setBackground(new Color(211,211,211));
    }

    // set a random word from the word list
    public void setRandomWord(String randomWord) {
        this.randomWord = randomWord;
    }

    // choose a word from the word list randomly
    public String getRandomWord() {
        return this.randomWord;
    }

    // set an arraylist of (JLabel)underscores to display
    public void setUnderscores(String randomWord) {
        for (int i = 0; i < randomWord.length(); i++) {
            currentUnderscore = new JLabel();
            currentUnderscore.setText("_");
            currentUnderscore.setFont(new Font("Calibri", Font.PLAIN, 64));
            underscores.add(currentUnderscore);
        }
    }

    // get an arraylist of (JLabel)underscores
    public ArrayList<JLabel> getUnderscores() {
        return this.underscores;
    }

    // set an arraylist for answers
    public void setAnswers(String randomWord) {
        for (int i = 0; i < randomWord.length(); i++) {
            answers.add(randomWord.charAt(i));
        }
    }

    // get an arraylist of answers
    public ArrayList<Character> getAnswers() {
        return this.answers;
    }

    public boolean contains(char valueOfButton) {
        for (int i = 0; i < this.answers.size(); i++) {
            if (equalIgnoreCase(this.answers.get(i), (Character) valueOfButton)) {
                return true;
            }
        }
        return false;
    }

    // TODO1: how to show correct guesses
    public void openUp(char valueOfButton) {
        for (int i = 0; i < answers.size(); i++) {
            Character c = answers.get(i);
            if (equalIgnoreCase(c, (Character)valueOfButton)) {
                char data[] = {valueOfButton};
                String str = new String(data);
                underscores.get(i).setText(str);
            }
        }
    }

    public void addComponents() {
        for (int i = 0; i < underscores.size(); i++) {
            this.add(underscores.get(i));
        }
    }

    public static boolean equalIgnoreCase(Character c1, Character c2) {
        String s1 = String.valueOf(c1);
        String s2 = String.valueOf(c2);
        if (s1.equalsIgnoreCase(s2)) {
            return true;
        }
        else {
            return false;
        }
    }
}