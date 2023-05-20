
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
        int i = 0;
        for (Integer id : Pawn_droppings_sell){
            MainGUI.getInfo().getPawn_droppings_data().remove(id);
        }
        gui.setTable(MainGUI.getInfo().getPawn_droppings_data());
        System.out.println("Sell All");
    }
    
}
