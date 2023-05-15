import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class pawn_droppings_GUI extends JInternalFrame implements TableModelListener{
    private JTable table;
    private JScrollPane sp;
    private DefaultTableModel model;
    private LinkedHashMap<Integer, Pawn_droppings> filteredData;
    private LinkedHashMap<Integer, Pawn_droppings> Pawn_droppings_data;
    private ArrayList<Integer> Pawn_droppings_sell;
     
    public pawn_droppings_GUI(){
        Pawn_droppings_data = MainGUI.getInfo().getPawn_droppings_data();
        Pawn_droppings_sell = new ArrayList<>();
        
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(1050, 500));
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        this.setFrameIcon(null);
        this.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        this.setVisible(true);
        
        String[] columnNames = {"","ID", "Name", "Pirce"};
        Object[][] data = new Object[Pawn_droppings_data.size()][4];
        int i = 0;
        for (Pawn_droppings item : Pawn_droppings_data.values()){
            Object[] rowData = {false, item.getID(), item.getName(), item.getValue()};
            data[i++] = rowData;
        }
        
        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        table.setRowHeight(50);
//        System.out.println(table.getComponentCount());
        
        TableColumn checkboxColumn = table.getColumnModel().getColumn(0);
        checkboxColumn.setCellRenderer(table.getDefaultRenderer(Boolean.class));
        checkboxColumn.setCellEditor(table.getDefaultEditor(Boolean.class));

        // Set the width of the checkbox column
        checkboxColumn.setMaxWidth(50);
        checkboxColumn.setMinWidth(50);
        
        model.addTableModelListener(this);
        
       // Create a scroll pane and add the table to it
        sp = new JScrollPane(table);
        // Add the scroll pane to the frame
        this.add(sp);
        
    }
    
    public void Search(String kw){
        filteredData = new LinkedHashMap<>();
        String keyword = kw;
        for (Pawn_droppings item : Pawn_droppings_data.values()) {
            if (String.valueOf(item.getID()).contains(keyword)) {
                filteredData.put(item.getID(), item);
            }else if (item.getName().contains(keyword)) {
                filteredData.put(item.getID(), item);
            }
        }
        setTable(filteredData);
    }
    
    public void setTable(LinkedHashMap<Integer, Pawn_droppings> filteredData){
        // Clear the existing data from the model
         model.setRowCount(0);

         // Add the new data to the model
        for (Pawn_droppings item : filteredData.values()) {
            Object[] rowData = {false, item.getID(), item.getName(), item.getValue()};
            model.addRow(rowData);
        }

        table.repaint();
    }

    public ArrayList<Integer> getPawn_droppings_sell() {
        return Pawn_droppings_sell;
    }

    public void setPawn_droppings_sell(ArrayList<Integer> Pawn_droppings_sell) {
        this.Pawn_droppings_sell = Pawn_droppings_sell;
    }

    @Override
    public void tableChanged(TableModelEvent e) {

        // Check if the event is a cell update
        if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == 0) {
            // Get the row and column that was updated
            int row = e.getFirstRow();
            int col = e.getColumn();

            // Get the value of the checkbox in the first column
            Boolean checked = (Boolean) model.getValueAt(row, col);

            // If the checkbox was checked, print the name of the customer in the second column
            if (checked) {
                Integer id = (Integer) model.getValueAt(row, 1);
                Pawn_droppings_sell.add(id);

            }else{
                Integer id = (Integer) model.getValueAt(row, 1);
                Pawn_droppings_sell.remove(id);

            }
        }
    }
    
}


