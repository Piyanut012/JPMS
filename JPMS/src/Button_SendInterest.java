import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Button_SendInterest extends JButton implements ActionListener{
    private JFrame parent;
    private CustomerInfo_GUI current;
    
    public Button_SendInterest(JFrame fr, CustomerInfo_GUI c){
        this.parent = fr;
        this.current = c;
        this.setText("SendInterest");
        this.setPreferredSize(new Dimension(150, 75));
        this.setEnabled(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        new SentInterest_GUI(parent, current);
    }
    
}
