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
//        Pawn_droppings item = new Pawn_droppings(MainGUI.getInfo().getId(), "Fan", 500);
//        MainGUI.getInfo().getPawn_droppings_data().put(item.getID(), item);
        System.out.println("AddMoney");
    }
    
}
