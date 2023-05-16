
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AddMoneyGUI implements ActionListener{
    private JDialog dialog;
    private JPanel top,mid,panel,low;
    private JLabel sum,lb1,lb2;
    private JButton ok, cancel, add;
    private int number;
    private ArrayList<JPanel> array;
    private Customer current_customer;

    public AddMoneyGUI(JFrame parentFrame, Customer c){
        current_customer = c;
        array = new ArrayList<JPanel>();
        number = 0;
        dialog = new JDialog(parentFrame, "AddMoney", true);
        top = new JPanel();
        mid = new JPanel();
        panel = new JPanel();
        low = new JPanel();
        sum = new JLabel(String.valueOf(number));
        lb1 = new JLabel("pawn goods");
        lb2 = new JLabel("Total : ");
        ok = new JButton("OK");
        cancel = new JButton("Cancel");
        add = new JButton("+");
        
        ok.addActionListener(this);
        cancel.addActionListener(this);
        add.addActionListener(this);
        
        JScrollPane scrollPane = new JScrollPane(mid);
        
        top.setLayout(new BorderLayout());
        dialog.setLayout(new BorderLayout());
        mid.setLayout(new BoxLayout(mid, BoxLayout.Y_AXIS));
        addpanel();
        
        top.add(lb1, BorderLayout.EAST);
        top.add(add, BorderLayout.WEST);
        
        low.add(lb2);
        low.add(sum);
        low.add(ok);
        low.add(cancel);
        
        dialog.add(top, BorderLayout.NORTH);
        dialog.add(scrollPane, BorderLayout.CENTER);
        dialog.add(low, BorderLayout.SOUTH);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setSize(350, 230);
        dialog.setResizable(false);
        dialog.setVisible(true);
        
    }
    public void addpanel(){
        JPanel pa = new JPanel();
        pa.setPreferredSize(new Dimension(250, 150));
        pa.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel pa2 = new JPanel();
        JPanel pa3 = new JPanel();
        pa.setLayout(new BorderLayout());
        pa2.setLayout(new GridLayout(4,2));
        JLabel label = new JLabel("Add image");
        label.addMouseListener(new MouseAdapter(){
                 @Override
                 public void mouseClicked(MouseEvent e) {
                    if (e.getSource().equals(label)){
                        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "jpeg", "png"));
                        int result = fileChooser.showOpenDialog(dialog);
                        if (result == JFileChooser.APPROVE_OPTION) {
                            File selectedFile = fileChooser.getSelectedFile();
                            ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());
                            //here image
                            label.setIcon(icon);
                        }
                    }
                }
            });
        pa3.add(label);
        JLabel lab1 = new JLabel("Name :");
        JLabel lab2 = new JLabel("Cost :");
        JLabel cater = new JLabel("category");
        JTextField name = new JTextField();
        JTextField cost = new JTextField();
        ButtonGroup grop = new ButtonGroup();
        JRadioButton accessories = new JRadioButton("accessories");
        JRadioButton appliance = new JRadioButton("appliance");
        grop.add(accessories);
        grop.add(appliance);
        
        pa2.add(lab1);
        pa2.add(name);
        pa2.add(lab2);
        pa2.add(cost);
        pa2.add(accessories);
        pa2.add(cater);
        pa2.add(appliance);
        pa.add(pa3, BorderLayout.WEST);
        pa.add(pa2, BorderLayout.CENTER);
        mid.add(pa);
        array.add(pa);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(add)){
            addpanel();
            dialog.repaint();
        }else if (e.getSource().equals(cancel)){
            dialog.dispose();
        }else if (e.getSource().equals(ok)){
            int x = 0;
            double total = 0;
            for (JPanel p : array){
                JPanel innerPanel = (JPanel) p.getComponent(1); 
                JTextField nameField = (JTextField) innerPanel.getComponent(1);
                JTextField costField = (JTextField) innerPanel.getComponent(3);
                try{
                    double cost = Double.parseDouble(costField.getText());
                    total += cost;
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, nameField.getText() +" : Please enter a number", "Value", JOptionPane.PLAIN_MESSAGE);
                    x = 1;
                }
            }
            if (x == 0){
                x = JOptionPane.showConfirmDialog(panel, "Value All : "+ total + " Baht", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (x == 0){
                    System.out.println("OK");
                    for (JPanel p : array){
                        JPanel innerPanel = (JPanel) p.getComponent(1); // Assuming the nested panel is at index 1
                        JTextField nameField = (JTextField) innerPanel.getComponent(1); // Assuming name text field is at index 1
                        JTextField costField = (JTextField) innerPanel.getComponent(3); // Assuming cost text field is at index 3
                        JRadioButton accessories = (JRadioButton) innerPanel.getComponent(4);
                        JRadioButton appliance = (JRadioButton) innerPanel.getComponent(6);
                        String name = nameField.getText();
                        double cost = Double.parseDouble(costField.getText());
                        if (accessories.isSelected()){
                            Pawn ag = new AccessoryAndGem(MainGUI.getInfo().getId_item(), name, cost);
                            current_customer.getItmes_data().put(ag.getID(), ag);
                        }else if (appliance.isSelected()){
                            Pawn ag = new Appliance(MainGUI.getInfo().getId_item(), name, cost);
                            current_customer.getItmes_data().put(ag.getID(), ag);
                        }else{
                            JOptionPane.showMessageDialog(null, name +" : Please select a category", "Category", JOptionPane.PLAIN_MESSAGE);
                            x = 1;
                        }

                    }
                    if (x == 0){
                        System.out.println("AddComplete");
                        dialog.dispose();
                    }else{
                        current_customer.getItmes_data().clear();
                    } 
                }else{
                    System.err.println("Cancel");
                }
            }
            
        }
    }
      
}
