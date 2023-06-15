package Hangman.src;

// TODO2: choose a random word in the arraylist and display it with underscores
// make a label as many as the number of letters in the word ?
// TODO2-1: there will be 'n' underscores as proportion to the number of letters in the chosen word.
// TODO2-2: make a class named "word"

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File; // to find a path of ImageIcon named "icon"
import java.io.FileNotFoundException;
import java.util.*;

public class Hangman {
    // main method
    public static void main (String[] args) throws FileNotFoundException{
        System.out.println("----------------------------");
        System.out.println("| <Hangman by Jinho Nam>   |");
        System.out.println("|- Github: jinhoishere     |");
        System.out.println("|- Discord: jinhoishere    |");
        System.out.println("|- Email: nam.6@wright.edu |");
        System.out.println("----------------------------");
        new Hangman();
        
    }

    public Hangman() {
        // leftLabel belongs to mainPanel
        JLabel leftLabel = new JLabel();
        ImageIcon image0 = new ImageIcon("/home/jinhoishere/projects/Hangman/lib/0.png");
        // System.out.println(new File("/home/jinhoishere/projects/Hangman/lib/0.png").exists());
        leftLabel.setIcon(resizeIcon(image0, 700, 900));
        leftLabel.setVerticalAlignment(JLabel.CENTER);
        leftLabel.setHorizontalAlignment(JLabel.CENTER);
        // label1.setOpaque(true);
        
        // (JPanel)mainpanel = (JLabel)leftLabel + (JPanel)rightPanel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(211,211,211)); // light gray
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        mainPanel.add(leftLabel);

        // (JPanel)rightPanel = (JPanel)rightTopPanel + (JPanel)rightBottomPanel
        JPanel rightPanel = new JPanel();
        // rightPanel.setBackground(new Color(211,211,211));
        rightPanel.setBackground(Color.orange);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        mainPanel.add(rightPanel);

        // (JPanel)rightTopPanel will have blanks to fill in
        JPanel rightTopPanel = new JPanel();
        // rightTopPanel.setBackground(new Color(211,211,211));
        rightTopPanel.setBackground(Color.yellow);
        rightPanel.add(rightTopPanel);

        // (JPanel)rightBottomPanel will have keyboards with buttons to guess spelling of the word
        JPanel rightBottomPanel = new JPanel();
        // rightBottomPanel.setBackground(new Color(211,211,211));
        rightBottomPanel.setBackground(Color.green);
        setButtonsAt(rightBottomPanel);
        // TODO: There will be a way to customize the layout of buttons with GridBagLayout() and GridBagConstraints()
        rightBottomPanel.setLayout(new GridLayout(3, 9, 10, 20));
        rightPanel.add(rightBottomPanel);


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

    // a method to adjust the size of images comfortably.
    public static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, 0);
        return new ImageIcon(resizedImage);
    }

    // RightTopPanel
    // read contents of the file and make an arraylist of them
    public static ArrayList<String> extractTextFile() throws FileNotFoundException {
        ArrayList<String> wordList = new ArrayList<>();
        Scanner readFile = new Scanner(new File("/home/jinhoishere/projects/Hangman/lib/wordList.txt"));
        while (readFile.hasNextLine()) {
            String currentWord = readFile.nextLine();
            wordList.add(currentWord);
        }
        return wordList;
    }

    // RightTopPanel
    // choose a random word from the word list 
    public static String getRandomWord(ArrayList<String> wordList) {
        Random randNumGen = new Random();
        int randNum = randNumGen.nextInt(wordList.size()) + 1;
        String randomWord = wordList.get(randNum);
        return randomWord;
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