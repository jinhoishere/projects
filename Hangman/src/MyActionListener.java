// package Hangman.src;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class MyActionListener implements ActionListener {
    // fields
    private String image_5 = "./lib/5.png";
    private String image_6 = "./lib/6.png";
    private static int numTry; // max 6 - game ends
    private JPanel mainPanel;
    private LeftLabel ll;
    private TopPanel top;
    private String randomWord;
    private MiddlePanel mid;
    private BottomPanel bottom;

    // constructor
    public MyActionListener(JPanel mainPanel, LeftLabel ll, TopPanel top, String randomWord, MiddlePanel mid, BottomPanel bottom) {
        this.mainPanel = mainPanel;
        this.ll = ll;
        this.top = top;
        this.randomWord = randomWord;
        this.mid = mid;
        this.bottom = bottom;
    }

    // set a reaction for each button
    public void actionPerformed(ActionEvent e) {
        char currentValue = e.getActionCommand().charAt(0);
        JButton b = (JButton) e.getSource();
        // if a value of button is in the random word,
        if (top.contains(currentValue)) {
            top.openUp(currentValue);
            b.setEnabled(false);
            printMessage_correct(currentValue);
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
                mid.setJLabelText("You used all chances. The answer was " + "\"" + randomWord + "\".");
                JOptionPane.showMessageDialog(null, "You used all chances :(" + "\n" + "The answer was \"" + randomWord + "\"" + "\n" + "Click OK to end the game.", "Notice", JOptionPane.ERROR_MESSAGE);
                System.out.println("You used all chance, the answer was \"" + randomWord + "\"" + "\n" + "Game ends.");
                System.exit(0);
            }
            ll.setImage("./lib/" + numTry + ".png"); // change this path whenever this file path changes
            b.setEnabled(false);
            printMessage_incorrect(currentValue);
        }
    }

    // print a reaction message when the guess is correct
    public void printMessage_correct(char currentValue) {
        Random randNumGen = new Random();
        int randNum = randNumGen.nextInt(3);
            switch (randNum) {
                case 0: System.out.println("The word has " + "\"" + currentValue + "\"" + ". " + "Nice shot.");
                        mid.setJLabelText("The word has " + "\"" + currentValue + "\"" + ". " + "Nice shot.");
                break;
                case 1: System.out.println("The word has " + "\"" + currentValue + "\"" + ". " + "Well tried.");
                        mid.setJLabelText("The word has " + "\"" + currentValue + "\"" + ". " + "Well tried.");
                break;
                case 2: System.out.println("The word has " + "\"" + currentValue + "\"" + ". " + "Good guess.");
                        mid.setJLabelText("The word has " + "\"" + currentValue + "\"" + ". " + "Good guess.");
                break;
            }
    }

    // print a reaction message when the guess is NOT correct
    public void printMessage_incorrect(char currentValue) {
        System.out.println("The word doesn't have " + "\"" + currentValue + "\"" + ". You have " + (6-numTry) + " chance(s) left.");
        mid.setJLabelText("The word doesn't have " + "\"" + currentValue + "\"" + ". You have " + (6-numTry) + " chance(s) left.");
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
        JOptionPane.showOptionDialog(null, "You got it!" + "\n"+ "Click OK to close the window.", "NOTICE", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options);
        System.exit(0);
    }
}
