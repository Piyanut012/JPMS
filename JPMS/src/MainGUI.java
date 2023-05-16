import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class MainGUI implements ActionListener, WindowListener{
    private JFrame fr;
    private JPanel north, mid, east, west, south,
                top, select_button, search;
    private DashBoard_GUI dashboard;
    private CustomerInfo_GUI customers;
    private pawn_droppings_GUI redemption;
    private JInternalFrame currentPanel;
    private JLabel head, name, lb_search1;
    private JTextField search_id;
    private JButton btn_dashboard, btn_customers, btn_redemption, btn_seacrh, btn_new_customer;
    private Button_Sell btn_sell;
    private Button_AddMoney btn_addmoney;
    private Button_PayInterest btn_payinterest;
    private Button_Redeem btn_redeem;
    private static Information info;
    
    private MainGUI(){
        info = new Information();
        fr = new JFrame("JPSM");
        fr.setSize(1100, 800);
        fr.setLocation(100, 100);
        
        //North
        north = new JPanel();
        north.setPreferredSize(new Dimension(1100, 200));
        north.setBorder(BorderFactory.createLineBorder(Color.RED));
        top = new JPanel();
        top.setLayout(new BorderLayout());
        top.setBorder(BorderFactory.createLineBorder(Color.RED));
        select_button = new JPanel();
        select_button.setLayout(new FlowLayout());
        select_button.setBorder(BorderFactory.createLineBorder(Color.RED));
        
        //search
        search = new JPanel();
        search.setLayout(new FlowLayout());
        search.setBorder(BorderFactory.createLineBorder(Color.RED));
        search.setVisible(false);
        ImageIcon icon;
        BufferedImage image;
        try {
            image = ImageIO.read(new File("image/search1.png"));
            icon = new ImageIcon(image);
            lb_search1 = new JLabel(icon);
            image = ImageIO.read(new File("image/correct.png"));
            icon = new ImageIcon(image); 
            btn_seacrh = new JButton(icon);
            image = ImageIO.read(new File("image/addcustomer.png"));
            icon = new ImageIcon(image); 
            btn_new_customer = new JButton(icon);
            btn_new_customer.setPreferredSize(new Dimension(150, 55));
        } catch (IOException ex) {
            Logger.getLogger(DashBoard_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        search_id = new JTextField();
        search_id.setFont(new Font("Arial", Font.PLAIN, 20));
        search_id.setPreferredSize(new Dimension(700, 40));

        head = new JLabel("JPSM");
        head.setFont(new Font("Arial", Font.PLAIN, 20));
        head.setHorizontalAlignment(JLabel.CENTER);
        head.setPreferredSize(new Dimension(150, 0));
        head.setBorder(BorderFactory.createLineBorder(Color.RED));
        name = new JLabel("Piyanut  *");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setPreferredSize(new Dimension(150, 0));
        name.setBorder(BorderFactory.createLineBorder(Color.RED));
        
        btn_dashboard = new JButton("DashBoard");
        btn_dashboard.setFont(new Font("Arial", Font.BOLD, 20));
        btn_dashboard.setPreferredSize(new Dimension(150, 50));
        btn_customers = new JButton("Customers");
        btn_customers.setFont(new Font("Arial", Font.BOLD, 20));
        btn_customers.setPreferredSize(new Dimension(150, 50));
        btn_redemption = new JButton("Redemption");
        btn_redemption.setFont(new Font("Arial", Font.BOLD, 20));
        btn_redemption.setPreferredSize(new Dimension(150, 50));
        
        //Mid
        dashboard = new DashBoard_GUI();
        currentPanel = dashboard;
        
        //East
        east = new JPanel();
        east.setPreferredSize(new Dimension(50, 500));
        east.setBorder(BorderFactory.createLineBorder(Color.RED));
        
        //West
        west = new JPanel();
        west.setPreferredSize(new Dimension(50, 500));
        west.setBorder(BorderFactory.createLineBorder(Color.RED));
        
        //South
        south = new JPanel();
        south.setLayout(new FlowLayout());
        south.setPreferredSize(new Dimension(1100, 100));
        south.setBorder(BorderFactory.createLineBorder(Color.RED));
        
        //Add Listener
        fr.addWindowListener(this);
        btn_dashboard.addActionListener(this);
        btn_customers.addActionListener(this);
        btn_redemption.addActionListener(this);
        btn_seacrh.addActionListener(this);
        btn_new_customer.addActionListener(this);
        
        //Set Frame
        fr.setLayout(new BorderLayout());
        north.setLayout(new GridLayout(3, 1));
        north.add(top); north.add(select_button); north.add(search);
        top.add(Box.createRigidArea(new Dimension(0, 0))); top.add(head, BorderLayout.WEST); top.add(name, BorderLayout.EAST);
        select_button.add(btn_dashboard); select_button.add(btn_customers); select_button.add(btn_redemption);
        search.add(lb_search1); search.add(search_id); search.add(btn_seacrh); search.add(btn_new_customer);
        fr.add(north, BorderLayout.NORTH);
        fr.add(east, BorderLayout.EAST);
        fr.add(west, BorderLayout.WEST);
        fr.add(south, BorderLayout.SOUTH);
        fr.add(currentPanel);
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setResizable(false);
        fr.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> { new MainGUI(); });
//        new MainGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btn_dashboard)){
            south.removeAll();
            search.setVisible(false);
            fr.remove(currentPanel); 
            dashboard = new DashBoard_GUI();
            currentPanel = dashboard;
            fr.add(currentPanel);
        }else if (e.getSource().equals(btn_customers)){
            search.setVisible(true);
            btn_new_customer.setVisible(true);
            fr.remove(currentPanel);
            customers = new CustomerInfo_GUI();
            currentPanel = customers;
            fr.add(currentPanel);

            //Add Button At South
            south.removeAll();
            btn_addmoney = new Button_AddMoney(fr, customers);
            btn_payinterest = new Button_PayInterest(fr, customers);
            btn_redeem = new Button_Redeem();
                
            btn_addmoney.addActionListener(btn_addmoney);
            btn_payinterest.addActionListener(btn_payinterest);
            btn_redeem.addActionListener(btn_redeem);
            south.add(btn_addmoney); south.add(btn_payinterest); south.add(btn_redeem);
        }else if (e.getSource().equals(btn_redemption)){
            search.setVisible(true);
            btn_new_customer.setVisible(false);
            fr.remove(currentPanel);
            redemption = new pawn_droppings_GUI();
            currentPanel = redemption;
            fr.add(currentPanel);
            
            //Add Button At South
            south.removeAll();
            btn_sell = new Button_Sell((pawn_droppings_GUI) currentPanel);
            south.add(btn_sell);
        }else if (e.getSource().equals(btn_seacrh)){
            try{
                if (currentPanel == customers){
                    System.out.println(search_id.getText());
                    customers.Search(search_id.getText());
                    search_id.setText(null);
                    System.out.println("Search");
                }else{
                    redemption.Search(search_id.getText());
                    search_id.setText(null);
                    System.out.println("Search");
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Please enter id!", "", JOptionPane.ERROR_MESSAGE);
            }
            
            
        }else if (e.getSource().equals(btn_new_customer)){
            new New_CustomerGUI(fr);
        }
        fr.revalidate();
        fr.repaint();
    }

    @Override
    public void windowOpened(WindowEvent e) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Infomation.data"));
            info = (Information) ois.readObject();
            ois.close();
            System.out.println("Load data");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Infomation.data"));
            oos.writeObject(info);
            oos.close(); 
            System.out.println("Save data");
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    public static Information getInfo() {
        return info;
    }

    public static void setInfo(Information info) {
        MainGUI.info = info;
    }
    
}

