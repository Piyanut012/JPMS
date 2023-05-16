import java.awt.*;
import java.awt.event.*;
import java.util.LinkedHashMap;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.*;

public class SentInterest_GUI implements ActionListener{
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

    
    public SentInterest_GUI(JFrame pf, CustomerInfo_GUI cf){
        parentFrame = pf;
        currentFrame = cf;
        current_customer_allpawn =  currentFrame.getCurrent_customer().getItmes_data();
        
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
                dialog.dispose();
            }
        }else if(btn.equals(cancel)){
            dialog.dispose();
        }
    }
}
