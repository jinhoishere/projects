package Hangman.src;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JPanel;

// RightPanel - TopPanel
public class TopPanel extends JPanel {
    public TopPanel() throws FileNotFoundException {
        this.setBackground(Color.yellow);
        // this.setBackground(new Color(211,211,211));
        // TODO: display word with underscores
        JLabel displayWord = new JLabel(getRandomWord(extractTextFile()));
        this.add(displayWord);
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
}
