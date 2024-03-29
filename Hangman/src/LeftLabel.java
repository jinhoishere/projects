// package Hangman.src;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

// mainPanel - LeftLabel
public class LeftLabel extends JLabel {
    // fields
    private ImageIcon image;

    // constructor
    public LeftLabel(String path) {
        image = new ImageIcon(path);
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

    // a method to set an image at the left label
    public void setImage(String path) {
        ImageIcon image = new ImageIcon(path);
        this.setIcon(resizeIcon(image, 600, 800));
    }

    // a method to get an image at the left label
    public ImageIcon getImage() {
        return this.image;
    }
    
}
