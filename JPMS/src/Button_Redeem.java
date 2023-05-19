import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Button_Redeem extends JButton implements ActionListener{
    private JFrame parent;
    private CustomerInfo_GUI current;
    
    public Button_Redeem(JFrame fr, CustomerInfo_GUI c){
        this.parent = fr;
        this.current = c;
        this.setText("Redeem");
        this.setPreferredSize(new Dimension(150, 75));
        this.setEnabled(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        new Redeem_GUI(parent, current);
    }
    
}
