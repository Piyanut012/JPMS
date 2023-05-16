import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Button_AddMoney extends JButton implements ActionListener{
    
    public Button_AddMoney(){
        this.setText("AddMoney");
        this.setPreferredSize(new Dimension(150, 75));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        System.out.println("AddMoney");
    }
    
}
