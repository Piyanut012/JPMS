import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

public class SentInterest_GUI implements ActionListener, TableModelListener{
    private JDialog dialog;
    private JFrame parentFrame;
    private CustomerInfo_GUI currentFrame; 
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel name;
    private JTable table;
    private JScrollPane scroll;
    private JButton confirm;
    private JButton cancel;
    private JCheckBox box;
    private DefaultTableModel model;
    private LinkedHashMap<Integer, Pawn> current_customer_allpawn;
    private ArrayList<Integer> id_pawn; 

    
    public SentInterest_GUI(JFrame pf, CustomerInfo_GUI cf){
        parentFrame = pf;
        currentFrame = cf;
        current_customer_allpawn =  currentFrame.getCurrent_customer().getItmes_data();
        id_pawn = new ArrayList<>();
        
        dialog = new JDialog(parentFrame, "SetInterest", true);
        dialog.setLayout(new BorderLayout());
        
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,2));
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        
        name = new JLabel("", JLabel.CENTER);
        
        box = new JCheckBox();
        
        scroll = new JScrollPane();
        
        confirm = new JButton("Confirm");
        confirm.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        
        
        String[] columnNames = {"","ID", "Name", "Pirce", "Status"};
        Object[][] data = new Object[current_customer_allpawn.size()][5];
        int i = 0;
        for (Pawn p : current_customer_allpawn.values()){
            Object[] rowData = {false, p.getID(), p.getName(), p.getValue(), p.getStr_status()};
            data[i++] = rowData;
        }
        
        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        table.setRowHeight(50);
//        System.out.println(table.getComponentCount());
        
        TableColumn checkboxColumn = table.getColumnModel().getColumn(0);
        checkboxColumn.setCellRenderer(table.getDefaultRenderer(Boolean.class));
        checkboxColumn.setCellEditor(table.getDefaultEditor(Boolean.class));
        
        model.addTableModelListener(this);
        
        // Set the width of the checkbox column
        checkboxColumn.setMaxWidth(50);
        checkboxColumn.setMinWidth(50);
        scroll.setViewportView(table);
        
        panel3.add(confirm);
        panel3.add(cancel);
        panel2.add(panel3);
        panel1.add(name, BorderLayout.NORTH);
        panel1.add(scroll, BorderLayout.CENTER);
        panel1.add(panel2, BorderLayout.SOUTH);
        
        dialog.add(panel1);

        
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setLocation(50, 100);
        dialog.setSize(600, 600);
        dialog.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        JButton btn = (JButton) ae.getSource();
        if(btn.equals(confirm)){
            int x = JOptionPane.showConfirmDialog(null, "Money", null, JOptionPane.YES_NO_OPTION);
            if(x == 0){
                for (Integer id : id_pawn){
                    current_customer_allpawn.get(id).SendInterest();
                }
                dialog.dispose();
            }
        }else if(btn.equals(cancel)){
            dialog.dispose();
        }
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
                id_pawn.add(id);

            }else{
                Integer id = (Integer) model.getValueAt(row, 1);
                id_pawn.remove(id);

            }
        }
    }
}