import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Button_PayInterest extends JButton implements ActionListener{
    
    public Button_PayInterest(){
        this.setText("PayInterest");
        this.setPreferredSize(new Dimension(150, 75));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("PayInterest");
    }
    
}
