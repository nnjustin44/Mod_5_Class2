/* Justin Nguyen
Professor Sarah North
CS W01 Online 1302
MOD_5
 */






import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
    public class Fruit extends JPanel implements ActionListener {
        JLabel picture;
        public Fruit() {
            String[] FruitsStrings = { "Mango", "Apple", "Banana", "Pineapple","Orange"};
// Create the combo box, select the pig
            JComboBox FruitList = new JComboBox(FruitsStrings);
            FruitList.setSelectedIndex(0);
            FruitList.addActionListener(this);
// Set up the picture
            picture = new JLabel(new ImageIcon("images/" +
                    FruitsStrings[FruitList.getSelectedIndex()] +
                    ".gif"));
            picture.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
// The preferred size is hard-coded to be the width of the
// widest image and the height of the tallest image + the border.
// A real program would compute this.
            picture.setPreferredSize(new Dimension(177, 122+10));
// Layout the demo
            setLayout(new BorderLayout());
            add(FruitList, BorderLayout.NORTH);
            add(picture, BorderLayout.SOUTH);
            setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        }
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox)e.getSource();
            String FruitName = (String)cb.getSelectedItem();
            picture.setIcon(new ImageIcon("images/" + FruitName + ".gif"));
        }
        public static void main(String s[]) {
            JFrame frame = new JFrame("ComboBoxDemo");
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {System.exit(0);}
            });
            frame.getContentPane().add(new Fruit(), BorderLayout.CENTER);
            frame.pack();
            frame.setVisible(true);
        }
    }

