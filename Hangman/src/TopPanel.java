package Hangman.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.*;
import java.awt.*;

// RightPanel - TopPanel
public class TopPanel extends JPanel {
    private String randomWord;
    private ArrayList<String> randomWords;
    private ArrayList<JLabel> underscores;

    public TopPanel() throws FileNotFoundException {
        // this.setBackground(Color.yellow);
        setBackground(new Color(211,211,211));
        setRandomWords();
        setRandomWord();
        setUnderscores();
        randomWord = this.getRandomWord();
        randomWords = this.getRandomWords();
        underscores = this.getUnderscores();
    }


    // read words in the file and set an arraylist of them
    public void setRandomWords() throws FileNotFoundException {
        randomWords = new ArrayList<>();
        Scanner readFile = new Scanner(new File("/home/jinhoishere/projects/Hangman/lib/wordList.txt"));
        while (readFile.hasNextLine()) {
            String currentWord = readFile.nextLine();
            randomWords.add(currentWord);
        }
    }

    // get an arraylist of random words
    public ArrayList<String> getRandomWords() {
        return randomWords;
    }

    // set a random word from the word list
    public void setRandomWord() {
        Random randNumGen = new Random();
        int randNum = randNumGen.nextInt(randomWords.size()) + 1;
        randomWord = randomWords.get(randNum);
    }

    // choose a word from the word list randomly
    public String getRandomWord() {
        return randomWord;
    }

    // set an arraylist of (JLabel)underscores
    public void setUnderscores() {
        for (int i = 0; i < randomWord.length(); i++) {
            JLabel l = new JLabel();
            l.setText("_");
            l.setFont(new Font("Calibri", Font.PLAIN, 64));
            this.add(l);
        }
    }

    // get an arraylist of (JLabel)underscores
    public ArrayList<JLabel> getUnderscores() {
        return underscores;
    }
}
