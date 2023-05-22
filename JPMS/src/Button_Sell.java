
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Button_Sell extends JButton implements ActionListener{ 
    private ArrayList<Integer> Pawn_droppings_sell;
    private pawn_droppings_GUI gui;
    
    public Button_Sell(pawn_droppings_GUI gui){
        this.setText("Sell");
        this.setPreferredSize(new Dimension(150, 75));
        this.gui = gui;
        this.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Pawn_droppings_sell = gui.getPawn_droppings_sell();
        //total
        double total = 0;
        for(Integer id : Pawn_droppings_sell){
           total += MainGUI.getInfo().getPawn_droppings_data().get(id).getValue();
        }
        
        if (total == 0){
            JOptionPane.showConfirmDialog(null, "Out of stock!", null, JOptionPane.PLAIN_MESSAGE);
            return;
        }
        int x = JOptionPane.showConfirmDialog(null, total, null, JOptionPane.YES_NO_OPTION);
            if(x == 0){
                int i = 0;
                for (Integer id : Pawn_droppings_sell){
                    MainGUI.getInfo().getPawn_droppings_data().remove(id);
                }
                gui.setTable(MainGUI.getInfo().getPawn_droppings_data());
                MainGUI.getInfo().sellpawndroppings(Pawn_droppings_sell.size(), total);
                JOptionPane.showMessageDialog(null, "Sell Complete!", "", JOptionPane.PLAIN_MESSAGE);
            }
      
    }
    
}
