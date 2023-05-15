import java.awt.*;
import java.awt.event.*;
import java.util.LinkedHashMap;
import javax.swing.*;
import javax.swing.table.*;
public class Retrieve implements ActionListener{
    public JFrame frame;
    public JPanel panel1;
    public JPanel panel2;
    public JPanel panel3;
    public JLabel name;
    public JLabel price;
    public JTable table;
    public JScrollPane scroll;
    public JButton confirm;
    public JButton cancel;
    public JCheckBox box;
    private DefaultTableModel model;
    private LinkedHashMap<Integer, Pawn_droppings> Pawn_droppings_data;

    
    public Retrieve(){
        Pawn_droppings_data = MainGUI.getInfo().getPawn_droppings_data();
        
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,2));
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        
        name = new JLabel("Retrieve", JLabel.CENTER);
        price = new JLabel("Price :");
        
        box = new JCheckBox();
        
        scroll = new JScrollPane();
        
        confirm = new JButton("Confirm");
        confirm.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        
//        table = new JTable();
//        DefaultTableModel model = (DefaultTableModel)table.getModel();
//        model.addColumn("");
//        model.addColumn("ID");
//        model.addColumn("Name");
//        model.addColumn("Check");
//        Object [] item =new object[][];
//        for(int i = 0; i <= frame.getHeight(); i++){
//            Object [] item =(false,box , i, 2);
//            model.addRow(new Object[0]);
//            model.setValueAt(false,box , i, 2);
//        }
        
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
        scroll.setViewportView(table);
        
        panel3.add(confirm);
        panel3.add(cancel);
        panel2.add(price);
        panel2.add(panel3);
        panel1.add(name, BorderLayout.NORTH);
        panel1.add(scroll, BorderLayout.CENTER);
        panel1.add(panel2, BorderLayout.SOUTH);
        
        frame.add(panel1);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Retrieve();
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        JButton btn = (JButton) ae.getSource();
        if(btn.equals(confirm)){
            int x = JOptionPane.showConfirmDialog(null, "Money", null, JOptionPane.YES_NO_OPTION);
            if(x == 0){
                frame.dispose();
            }
        }else if(btn.equals(cancel)){
            frame.dispose();
        }
    }
}
