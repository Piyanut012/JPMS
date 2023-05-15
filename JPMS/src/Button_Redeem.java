import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Button_Redeem extends JButton implements ActionListener{
    
    public Button_Redeem(){
        this.setText("Redeem");
        this.setPreferredSize(new Dimension(150, 75));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Redeem");
    }
    
}
