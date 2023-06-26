// package Hangman.src;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private String image_0 = "/home/jinhoishere/projects/Hangman/lib/0.png";
    private String wordList = "/home/jinhoishere/projects/Hangman/lib/wordList.txt";
    private String mainIcon = "/home/jinhoishere/projects/Hangman/lib/H.png";

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
        // (JPanel) mainPanel = (LeftLabel) lb + (RightPanel) rp
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(211,211,211)); // light gray
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        // (LeftLabel) lb
        LeftLabel ll = new LeftLabel(image_0);
        mainPanel.add(ll);

        // (RightPanel) rp = (TopPanel) top + (BottomPanel) bottom
        RightPanel rp = new RightPanel();
        mainPanel.add(rp);
        
        // (TopPanel) top will have blanks to fill in
        TopPanel top = new TopPanel();
        top.setRandomWord(pickRandomWord(new File(wordList)));
        top.setUnderscores(top.getRandomWord());
        top.setAnswers(top.getRandomWord());
        top.addComponents();
        rp.add(top);

        MiddlePanel mid = new MiddlePanel();
        rp.add(mid);

        // (BottomPanel) bottom will have keyboards with buttons to guess alphabets of the word
        BottomPanel bottom = new BottomPanel();
        // bottom.setButtons_row1(mainPanel, ll, top, top.getRandomWord(), bottom);
        // bottom.setButtons_row2(mainPanel, ll, top, top.getRandomWord(), bottom);
        // bottom.setButtons_row3(mainPanel, ll, top, top.getRandomWord(), bottom);
        bottom.setButtons(mainPanel, ll, top, top.getRandomWord(), bottom);
        rp.add(bottom);

        // (JFrame)frame = (JPanel)mainPanel
        JFrame frame = new JFrame("Hangman");
        ImageIcon icon = new ImageIcon(mainIcon);
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

    public static String pickRandomWord(File f) throws FileNotFoundException {
        Scanner readFile = new Scanner(f);
        ArrayList<String> randomWords = new ArrayList<>();
        while (readFile.hasNextLine()) {
            String currentWord = readFile.nextLine();
            randomWords.add(currentWord);
        }
        Random randNumGen = new Random();
        int randNum = randNumGen.nextInt(randomWords.size()) + 1;
        String randomWord = randomWords.get(randNum);
        return randomWord;
    }
}