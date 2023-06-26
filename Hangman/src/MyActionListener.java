// package Hangman.src;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class MyActionListener implements ActionListener {
    // fields
    private String image_5 = "/home/jinhoishere/projects/Hangman/lib/5.png";
    private String image_6 = "/home/jinhoishere/projects/Hangman/lib/6.png";
    private static int numTry; // max 6 - game ends
    private int randNum;
    private JPanel mainPanel;
    private LeftLabel ll;
    private TopPanel top;
    private String randomWord;
    private BottomPanel bottom;

    // constructor
    public MyActionListener(JPanel mainPanel, LeftLabel ll, TopPanel top, String randomWord, BottomPanel bottom) {
        this.mainPanel = mainPanel;
        this.ll = ll;
        this.top = top;
        this.randomWord = randomWord;
        this.bottom = bottom;
    }

    // set a reaction for each button
    public void actionPerformed(ActionEvent e) {
        Random randNumGen = new Random();
        char currentValue = e.getActionCommand().charAt(0);
        JButton b = (JButton) e.getSource();
        // if a value of button is in the random word,
        if (top.contains(currentValue)) {
            top.openUp(currentValue);
            b.setEnabled(false);
            // b.setVisible(false);
            randNum = randNumGen.nextInt(3);
            switch (randNum) {
                case 0: System.out.println("The word has " + "\"" + currentValue + "\"" + ". " + "Nice shot.");
                break;
                case 1: System.out.println("The word has " + "\"" + currentValue + "\"" + ". " + "Well tried.");
                break;
                case 2: System.out.println("The word has " + "\"" + currentValue + "\"" + ". " + "Good guess.");
                break;
            }
            // if a player meets win condition, the player wins
            if (meetsWinCondition()) {
                win();
            }
        }
        // if a value of button is NOT in the random word,
        else {
            numTry += 1;
            if (numTry == 5) {
                ll.setImage(image_5);
                JOptionPane.showMessageDialog(null, "You have ONLY 1 chance left!", "Notice", JOptionPane.WARNING_MESSAGE);
            }
            else if (numTry == 6) {
                ll.setImage(image_6);
                JOptionPane.showMessageDialog(null, "You used all chances :(" + "\n" + "The answer was \"" + randomWord + "\"" + "\n" + "Game ends.", "Notice", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            ll.setImage("/home/jinhoishere/projects/Hangman/lib/" + numTry + ".png"); // change this path whenever this file path changes
            b.setEnabled(false);
            System.out.println("The answer word doesn't have " + currentValue + ". You have " + (6-numTry) + " chances left.");
        }
    }

    // check if a player wins or not
    public boolean meetsWinCondition() {
        ArrayList<JLabel> underscores = this.top.getUnderscores();
        for (int i = 0; i < underscores.size(); i++) {
            if (underscores.get(i).getText().equals("_")) {
                return false;
            }
        }
        return true;
    }

    // if a player meets a win condition, show a message and end game
    public void win() {
        System.out.println("<You got it! The word was \"" + this.top.getRandomWord() + "\">");
        Object[] options = {"OK"};
        JOptionPane.showOptionDialog(null, "You got it!" + "\n"+ "Click OK to close the window.", "Notice", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options);
        System.exit(0);
    }
}
