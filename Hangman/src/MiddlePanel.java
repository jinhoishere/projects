import java.awt.Color;
import java.awt.Font;
// import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MiddlePanel extends JPanel {
    // fields
    private JLabel l;

    // constructor
    public MiddlePanel() {
        // this.setBackground(Color.PINK);
        this.setBackground(new Color(211, 211, 211));
        this.setLayout(new GridLayout(10, 1));
        // this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
    }

    public JLabel getLabel() {
        return l;
    }

    public void setJLabelText(String s) {
        l = new JLabel();
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setText(s);
        l.setFont(new Font("Calibri", Font.PLAIN, 20));
        this.add(l);
    }

}
