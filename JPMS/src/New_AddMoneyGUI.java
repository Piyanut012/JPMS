
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import javax.imageio.ImageIO;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;

public class New_AddMoneyGUI implements ActionListener{
    private JDialog dialog;
    private JDialog parentDialog;
    private JPanel top,mid,panel,low;
    private JLabel lb1;
    private JButton ok, cancel, add;
    private ArrayList<JPanel> array;
    private Customer new_customer;
    private ArrayList<ImageIcon> array_image;

    public New_AddMoneyGUI(JDialog parentdialog, Customer c){
        new_customer = c;
        array = new ArrayList<JPanel>();
        array_image = new ArrayList<>();

        this.parentDialog = parentdialog;
        dialog = new JDialog(parentDialog, "AddPawngoods", true);
        top = new JPanel();
        mid = new JPanel();
        panel = new JPanel();
        low = new JPanel();
        lb1 = new JLabel("pawn goods");
        ok = new JButton("OK");
        cancel = new JButton("Cancel");
        add = new JButton("+");
        
        ok.addActionListener(this);
        cancel.addActionListener(this);
        add.addActionListener(this);
        
        JScrollPane scrollPane = new JScrollPane(mid);
        
        top.setLayout(new FlowLayout());
        dialog.setLayout(new BorderLayout());
        mid.setLayout(new BoxLayout(mid, BoxLayout.Y_AXIS));
        addpanel();
        
        top.add(lb1);
        
        low.add(Box.createRigidArea(new Dimension(60, 30)));
        low.add(ok);
        low.add(cancel);
        low.add(Box.createRigidArea(new Dimension(50, 30)));
        low.add(add);
        
        dialog.add(top, BorderLayout.NORTH);
        dialog.add(scrollPane, BorderLayout.CENTER);
        dialog.add(low, BorderLayout.SOUTH);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(parentDialog);
        dialog.setSize(350, 230);
        dialog.setResizable(false);
        dialog.setVisible(true);
        
    }
    public void addpanel(){
        JPanel pa = new JPanel();
        pa.setPreferredSize(new Dimension(250,150));
        pa.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel pa2 = new JPanel();
        JPanel pa3 = new JPanel();
        pa.setLayout(new BorderLayout());
        pa2.setLayout(new GridLayout(4,2));
        JLabel label = new JLabel("Click to add image");
        label.setBorder(BorderFactory.createLineBorder(Color.RED));
        array_image.add(null);
        label.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
               if (e.getSource().equals(label)){
                   JFileChooser fileChooser = new JFileChooser();
                   fileChooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "jpeg", "png"));
                   int result = fileChooser.showOpenDialog(dialog);
                   if (result == JFileChooser.APPROVE_OPTION) {
                       File selectedFile = fileChooser.getSelectedFile();
                       try {

                           BufferedImage originalImage = ImageIO.read(selectedFile);

                           int width = 200;
                           int height = 200;
                           BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                           Graphics2D g = resizedImage.createGraphics();
                           g.drawImage(originalImage, 0, 0, width, height, null);
                           g.dispose();

                           //ตัวเเปร รูปภาพ
                           ImageIcon resizedIcon = new ImageIcon(resizedImage);
                           array_image.set(array.indexOf(pa),resizedIcon);
                           label.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                           
                       }
                       catch (IOException ex) {
                           ex.printStackTrace();
                       }
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
        pa2.add(cater);
        pa2.add(accessories);
        JLabel space = new JLabel("");
        pa2.add(space);
        pa2.add(appliance);
        pa.add(pa3, BorderLayout.SOUTH);
        pa.add(pa2, BorderLayout.CENTER);
        pa.setSize(300, 200);
        
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
                    int num = 0;
                    for (JPanel p : array){
                        JPanel innerPanel = (JPanel) p.getComponent(1); // Assuming the nested panel is at index 1
                        JTextField nameField = (JTextField) innerPanel.getComponent(1); // Assuming name text field is at index 1
                        JTextField costField = (JTextField) innerPanel.getComponent(3); // Assuming cost text field is at index 3
                        JRadioButton accessories = (JRadioButton) innerPanel.getComponent(5);
                        JRadioButton appliance = (JRadioButton) innerPanel.getComponent(7);
                        String name = nameField.getText();
                        double cost = Double.parseDouble(costField.getText());
                        ImageIcon image = array_image.get(num);
                        if (accessories.isSelected()){
                            Pawn ag = new AccessoryAndGem(MainGUI.getInfo().getId_item(), name, cost, image);
                            new_customer.getItmes_data().put(ag.getID(), ag);
                        }else if (appliance.isSelected()){
                            Pawn a = new Appliance(MainGUI.getInfo().getId_item(), name, cost, image);
                            new_customer.getItmes_data().put(a.getID(), a);
                        }else{
                            JOptionPane.showMessageDialog(null, name +" : Please select a category", "Category", JOptionPane.PLAIN_MESSAGE);
                            x = 1;
                        }
                        num++;
                    }
                    if (x == 0){
                        new_customer.setPrinciple(total);
                        MainGUI.getInfo().getCustomers_Data().put(new_customer.getId(), new_customer);
                        dialog.dispose();
                        parentDialog.dispose();
                        JOptionPane.showMessageDialog(null, "Add customer complete!", "", JOptionPane.PLAIN_MESSAGE);
                        
                    }else{
                        new_customer.getItmes_data().clear();
                    } 
                }else{
                    System.err.println("Cancel");
                }
            }
            
        }
    }
      
}
