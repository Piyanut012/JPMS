
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Button_SelectAll extends JButton implements ActionListener{ 
    private ArrayList<Integer> Pawn_droppings_sell;
    private pawn_droppings_GUI gui;
    
    public Button_SelectAll(pawn_droppings_GUI gui){
        this.setText("Select All");
        this.setPreferredSize(new Dimension(150, 75));
        this.gui = gui;
        this.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JTable table = gui.getTable();
        if(this.getText().equals("Select All")){
            int rowCount = table.getRowCount();
            for(int i = 0; i < rowCount; i++){
                table.setValueAt(true, i, 0);
            }
            this.setText("Clear All");
        }else if(this.getText().equals("Clear All")){
            int rowCount = table.getRowCount();
            for(int i = 0; i < rowCount; i++){
                table.setValueAt(false, i, 0);
            }
            this.setText("Select All");
        }
    }
    
}
