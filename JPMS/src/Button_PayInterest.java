import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Button_PayInterest extends JButton implements ActionListener{
    private JFrame parent;
    private CustomerInfo_GUI current;
    
    public Button_PayInterest(JFrame fr, CustomerInfo_GUI c){
        this.parent = fr;
        this.current = c;
        this.setText("PayInterest");
        this.setPreferredSize(new Dimension(150, 75));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        new SentInterest_GUI(parent, current);
        System.out.println("PayInterest");
    }
    
}
