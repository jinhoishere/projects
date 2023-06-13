package Hangman.src;
// TODO: JTextField (We don't need this), JButton (We need this w a separate class)
import javax.swing.*;
import java.awt.*;
import java.io.File; // to find a path of ImageIcon named "icon"

public class Hangman {
    public static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, 0);
        return new ImageIcon(resizedImage);
    }

    public Hangman() {
        // a label in leftpanel
        JLabel leftLabel = new JLabel();
        ImageIcon image0 = new ImageIcon("/home/jinhoishere/github/projects/Hangman/0.png");
        // System.out.println(new File("/home/jinhoishere/github/projects/Hangman/0.png").exists());
        // ImageIcon image1 = new ImageIcon("/home/jinhoishere/projects/Hangman/0.png");
        // System.out.println(new File("/home/jinhoishere/projects/Hangman/0.png").exists());
        leftLabel.setIcon(resizeIcon(image0, 700, 900));
        leftLabel.setVerticalAlignment(JLabel.CENTER);
        leftLabel.setHorizontalAlignment(JLabel.CENTER);
        // label1.setOpaque(true);
        
        // main panel = (JLabel)leftLabel + (JPanel)rightPanel
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(211,211,211)); // light gray
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        mainPanel.add(leftLabel);

        // rightPanel = rightTopPanel + rightBottomPanel
        JPanel rightPanel = new JPanel();
        // rightPanel.setBackground(new Color(211,211,211));
        rightPanel.setBackground(Color.orange);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        mainPanel.add(rightPanel);

        // rightTopPanel will have blanks to fill in
        JPanel rightTopPanel = new JPanel();
        // rightTopPanel.setBackground(new Color(211,211,211));
        rightTopPanel.setBackground(Color.yellow);
        rightPanel.add(rightTopPanel);

        // rightBottomPanel will have keyboards with buttons to select letters
        JPanel rightBottomPanel = new JPanel();
        // rightBottomPanel.setBackground(new Color(211,211,211));
        rightBottomPanel.setBackground(Color.green);
        rightPanel.add(rightBottomPanel);


        // frame
        JFrame frame = new JFrame("Hangman by Jinho Nam");
        ImageIcon icon = new ImageIcon("/home/jinhoishere/github/projects/Hangman/H.png");
        // System.out.println(new File("/home/jinhoishere/github/projects/Hangman/H.png").exists()); 
        // ImageIcon icon = new ImageIcon("/home/jinhoishere/projects/Hangman/H.png");
        // System.out.println(new File("/home/jinhoishere/projects/Hangman/H.png").exists()); 
        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 1024);
        frame.setResizable(true);
        frame.getContentPane().setBackground(Color.black);
        frame.setVisible(true);

        frame.add(mainPanel);
        frame.pack();
      
    }
    public static void main (String[] args) {
        new Hangman();
    }
}