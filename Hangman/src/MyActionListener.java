package Hangman.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyActionListener implements ActionListener {
    private static int numTry; // max 6 - game ends
    private JPanel mainPanel;
    private LeftLabel ll;
    private TopPanel top;
    private String randomWord;
    private BottomPanel bottom;

    public MyActionListener(JPanel mainPanel, LeftLabel ll, TopPanel top, String randomWord, BottomPanel bottom) {
        this.mainPanel = mainPanel;
        this.ll = ll;
        this.top = top;
        this.randomWord = randomWord;
        this.bottom = bottom;
    }


    public void actionPerformed(ActionEvent e) {
        char currentValue = e.getActionCommand().charAt(0);
        JButton b = (JButton) e.getSource();
        if (top.contains(currentValue)) {
            top.openUp(currentValue);
            // b.setEnabled(false);
            b.setVisible(false);
        }
        else {
            numTry += 1;
            if (numTry == 5) {
                ll.setImage("/home/jinhoishere/projects/Hangman/lib/5.png");
                JOptionPane.showMessageDialog(null, "You have ONLY 1 chance left!", "Notice", JOptionPane.WARNING_MESSAGE);
            }
            else if (numTry == 6) {
                ll.setImage("/home/jinhoishere/projects/Hangman/lib/6.png");
                JOptionPane.showMessageDialog(null, "You used all chances :(" + "\n" + "The answer was \"" + randomWord + "\"" + "\n" + "Game ends.", "Notice", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            ll.setImage("/home/jinhoishere/projects/Hangman/lib/" + numTry + ".png");
            b.setEnabled(false);
            System.out.println("The answer word doesn't have " + currentValue + ". You have " + (6-numTry) + " chances left.");
        }
    }
}
