package Hangman.src;

// TODO2: choose a random word in the arraylist and display it with underscores
// make a label as many as the number of letters in the word ?
// TODO2-1: there will be 'n' underscores as proportion to the number of letters in the chosen word.
// TODO2-2: make a class named "word"

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class Main {

    // main method
    public static void main (String[] args) throws FileNotFoundException {
        System.out.println("----------------------------");
        System.out.println("| <Hangman by Jinho Nam>   |");
        System.out.println("|- Github: jinhoishere     |");
        System.out.println("|- Discord: jinhoishere    |");
        System.out.println("|- Email: nam.6@wright.edu |");
        System.out.println("----------------------------");
        new Main();
        
    }

    public Main() throws FileNotFoundException {        
        // (JPanel) mainpanel = (LeftLabel) lb + (RightPanel) rp
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(211,211,211)); // light gray
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        // (LeftLabel) lb
        LeftLabel lb = new LeftLabel();
        mainPanel.add(lb);

        // (RightPanel) rp = (TopPanel) top + (BottomPanel) bottom
        RightPanel rp = new RightPanel();
        mainPanel.add(rp);
        
        // (TopPanel) top will have blanks to fill in
        TopPanel top = new TopPanel();
        rp.add(top);

        // (BottomPanel) bottom will have keyboards with buttons to guess spelling of the word
        BottomPanel bottom = new BottomPanel();
        rp.add(bottom);

        // (JFrame)frame = (JPanel)mainPanel
        JFrame frame = new JFrame("Hangman");
        ImageIcon icon = new ImageIcon("/home/jinhoishere/projects/Hangman/lib/H.png");
        // System.out.println(new File("/home/jinhoishere/projects/Hangman/lib/H.png").exists()); 
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 1024);
        frame.setResizable(true);
        frame.getContentPane().setBackground(Color.black);
        frame.setVisible(true);

        frame.add(mainPanel);
        frame.pack();
    }
}