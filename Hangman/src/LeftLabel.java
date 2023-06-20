package Hangman.src;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LeftLabel extends JLabel {
    private ImageIcon image;

    public LeftLabel(String path) {
        image = new ImageIcon(path);
        // System.out.println(new File("/home/jinhoishere/projects/Hangman/lib/0.png").exists());
        setIcon(resizeIcon(image, 600, 800));
        setVerticalAlignment(JLabel.CENTER);
        setHorizontalAlignment(JLabel.CENTER);
        // this.setOpaque(true);
    }

    // a method to adjust the size of images comfortably.
    public Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, 0);
        return new ImageIcon(resizedImage);
    }

    public void setImage(String path) {
        ImageIcon image = new ImageIcon(path);
        this.setIcon(resizeIcon(image, 600, 800));
    }

    public ImageIcon getImage() {
        return this.image;
    }
    
}
