package Hangman.src;
// TODO: JTextField (We don't need this), JButton (We need this w a separate class)
import javax.swing.*;
import java.awt.*;
import java.io.File; // to find a path of ImageIcon named "icon"

public class Hangman {
    public Hangman() {
        // a label in leftpanel
        JLabel label1 = new JLabel();
        ImageIcon image1 = new ImageIcon("/home/jinhoishere/github/projects/Hangman/1.png");
        // System.out.println(new File("/home/jinhoishere/github/projects/Hangman/1.png").exists());
        // ImageIcon image1 = new ImageIcon("/home/jinhoishere/projects/Hangman/1.png");
        // System.out.println(new File("/home/jinhoishere/projects/Hangman/1.png").exists());
        label1.setIcon(image1);
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);
        // label1.setBounds(0,0,75,75);

        // main panel = panel 1 (left panel) + panel 2 (right panel)
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(44,44,44)); // dark gray
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        // panel 1, this panel will have a hangman image in it
        JPanel leftPanel = new JPanel();
        // leftPanel.setBackground(new Color(44,44,44));
        leftPanel.setBackground(Color.red);
        leftPanel.add(label1);
        mainPanel.add(leftPanel);

        // panel 2, this panel will have rightTopPanel(panel 2-1) and rightBottomPanel (panel 2-2)
        JPanel rightPanel = new JPanel();
        // rightPanel.setBackground(new Color(44,44,44));
        rightPanel.setBackground(Color.orange);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        mainPanel.add(rightPanel);

        // panel 2-1, this panel will have blanks to fill in
        JPanel rightTopPanel = new JPanel();
        // rightTopPanel.setBackground(new Color(44,44,44));
        rightTopPanel.setBackground(Color.yellow);
        rightPanel.add(rightTopPanel);

        // panel 2-2, this panell will have keyboards with buttons to select letters
        JPanel rightBottomPanel = new JPanel();
        // rightBottomPanel.setBackground(new Color(44,44,44));
        rightBottomPanel.setBackground(Color.green);
        rightPanel.add(rightBottomPanel);


        // frame
        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon("/home/jinhoishere/github/projects/Hangman/H.png");
        // System.out.println(new File("/home/jinhoishere/github/projects/Hangman/H.png").exists()); 
        // ImageIcon icon = new ImageIcon("/home/jinhoishere/projects/Hangman/H.png");
        // System.out.println(new File("/home/jinhoishere/projects/Hangman/H.png").exists()); 
        frame.setIconImage(icon.getImage());
        frame.setTitle("Hangman by Jinho Nam");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
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