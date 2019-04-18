/* Justin Nguyen
Professor Sarah North
CS W01 Online 1302
MOD_5
 */





import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class Menu extends JFrame implements ItemListener{
    private JCheckBox[] foodItem;//for food items
    private JLabel[] selectedItem;
    private JPanel p1,p2;//panel for food item and selected item
    private JTextArea area1;
    public Menu(){
        super("Food Menu");//title of the gui
        setSize(450,400);//size of he frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//for default closing operation
        setResizable(false);//for not to resize the Frame
        setLayout(new FlowLayout());//setting layout for frame
        p1 = new JPanel();//panel 1
        p2 = new JPanel();//panel 2
        p1.setPreferredSize(new Dimension(200,400));//setting size of the panel
        p2.setPreferredSize(new Dimension(200,400));//setting size of the panel
        p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
        p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));
        p1.add(new JLabel("     == Food Items =="));
        p2.add(new JLabel(" == My Orders =="));
        foodItem = new JCheckBox[10];//array of food item you can change the number here
        //assign all the food item here
        foodItem[0] = new JCheckBox("Hydrabadi Biryani");
        foodItem[1] = new JCheckBox("Hydrabadi Pulaw");
        foodItem[2] = new JCheckBox("Hydrabadi Dum Biryani");
        foodItem[3] = new JCheckBox("Hydrabadi Chicken Biryani");
        foodItem[4] = new JCheckBox("Hydrabadi Aloo Matar");
        foodItem[5] = new JCheckBox("paneer Pyaza");
        foodItem[6] = new JCheckBox("etc1 ");
        foodItem[7] = new JCheckBox("etc2");
        foodItem[8] = new JCheckBox("etc3");
        foodItem[9] = new JCheckBox("etc 4");
        //add action listener on all fooditem
        for(int i = 0;i<10;i++){
            foodItem[i].addItemListener(this);
            p1.add(foodItem[i]);//add all item into panel 1
        }
        selectedItem = new JLabel[10];//label for selceted item;
        for(int i = 0;i<10;i++){
            selectedItem[i] = new JLabel(" ");
        }
        area1 = new JTextArea(12,6);
        p2.add(area1);
        add(p1);
        add(p2);
        setVisible(true);
    }
    //overriding the function of ItemListener to change the selected item
    public void itemStateChanged(ItemEvent e){
        //looping throw every item to check which item state got changed
        for(int i = 0;i<10;i++){
            if(e.getSource() == foodItem[i]){
                if(e.getStateChange() == 1){
                    //if food Item is selected we are assigning the name of food item to
                    //selected Item JLabel
                    selectedItem[i].setText(foodItem[i].getText());
                }else{
                    selectedItem[i].setText(" ");
                }
            }
        }
        setAreaText();
    }
    //here we are changing the text area text according to selected items
    public void setAreaText(){
        String str = " \n";
        //looping throw each selected Item and adding its text to the text area
        for(int i = 0;i<10;i++){
            if(!selectedItem[i].getText().equals(" ")){
                str += selectedItem[i].getText();
                str += " \n ";
            }
        }
        area1.setText(str);
    }
    public static void main(String[] args) {
        //simply for texting
        Menu f = new Menu();
    }
}
