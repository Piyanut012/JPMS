import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class Test extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public Test() {
        setTitle("Checkbox Table Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the table model
        String[] columnNames = {"", "Name", "Age", "City"};
        Object[][] data = {
                {false, "John Smith", 25, "New York"},
                {false, "Jane Doe", 30, "San Francisco"},
                {false, "Bob Johnson", 40, "Seattle"}
        };
        model = new DefaultTableModel(data, columnNames);

        // Create the table and set the model
        table = new JTable(model);

        // Set the renderer for the checkbox column
        TableColumn checkboxColumn = table.getColumnModel().getColumn(0);
        checkboxColumn.setCellRenderer(table.getDefaultRenderer(Boolean.class));
        checkboxColumn.setCellEditor(table.getDefaultEditor(Boolean.class));

        // Set the width of the checkbox column
        checkboxColumn.setMaxWidth(50);
        checkboxColumn.setMinWidth(50);

        // Create the scroll pane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        add(scrollPane);

        // Pack the frame and make it visible
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Test();
    }
}

