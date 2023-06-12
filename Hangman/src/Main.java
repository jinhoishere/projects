package Hangman.src;
import javax.swing.*;
import java.awt.*;
import java.io.File; // to find a path of ImageIcon named "icon"

public class Main {
    public static void main (String[] args) {
        JLabel leftLabel = new JLabel();
        // ImageIcon image1 = new ImageIcon("/home/jinhoishere/projects/Hangman/1.png");
        Image image1 = new Image("/home/jinhoishere/projects/Hangman/1.png");
        System.out.println(new File("/home/jinhoishere/projects/Hangman/1.png").exists());
        
        
        // panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(44, 44, 44));
        mainPanel.add(leftLabel);
        

        // frame
        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon("/home/jinhoishere/projects/Hangman/H.png");
        // System.out.println(new File("/home/jinhoishere/projects/Hangman/H.png").exists()); 
        frame.setIconImage(icon.getImage());
        frame.setTitle("Hangman by Jinho Nam");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(true);
        frame.getContentPane().setBackground(Color.black);
        frame.setVisible(true);
        frame.add(mainPanel);
      
    }
}