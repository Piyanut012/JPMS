
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import com.formdev.flatlaf.*;


public class MainGUI implements ActionListener, WindowListener {

    private final Color c1 = new Color(204, 213, 174);
    private final Color c2 = new Color(233, 237, 201);
    private final Color c3 = new Color(254, 250, 224);
    private final Color c4 = new Color(250, 237, 205);
    private final Color c5 = new Color(212, 163, 115);
    private final Font regF = new Font("Century Gothic", Font.PLAIN, 18);
    private final ImageIcon prevIcon = new ImageIcon("image/prev.png");
    private final ImageIcon nextIcon = new ImageIcon("image/next.png");
    private JFrame fr;
    private JPanel north, mid, east, west, south,
            top, select_button, search;
    private DashBoard_GUI dashboard;
    private CustomerInfo_GUI customers;
    private pawn_droppings_GUI redemption;
    private JInternalFrame currentPanel;
    private JLabel head, name, lb_search1;
    private JTextField search_id;
    private JButton btn_dashboard, btn_customers, btn_redemption, btn_seacrh, btn_new_customer, prev, next, btn_chart;
    private Button_Sell btn_sell;
    private Button_SelectAll btn_selectall;
    private Button_AddPawngoods btn_addmoney;
    private Button_SendInterest btn_payinterest;
    private Button_Redeem btn_redeem;
    private static Information info;

    public MainGUI() {

        info = new Information();
        fr = new JFrame("JPMS");
        fr.setSize(1100, 800);
        fr.setLocation(100, 100);

        //North
        north = new JPanel();
        north.setPreferredSize(new Dimension(1100, 200));

        top = new JPanel();
        top.setLayout(new BorderLayout());

        select_button = new JPanel();
        select_button.setLayout(new FlowLayout());
        select_button.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
        north.setBackground(c3);
        top.setBackground(c5);
        select_button.setBackground(c4);

        //search
        search = new JPanel();
        search.setLayout(new FlowLayout());
        search.setVisible(false);
        search.setBackground(c3);
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
            btn_new_customer.setPreferredSize(new Dimension(150, 50));
            btn_seacrh.setPreferredSize(new Dimension(75, 50));
        } catch (IOException ex) {
            Logger.getLogger(DashBoard_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        search_id = new JTextField();
        search_id.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        search_id.setPreferredSize(new Dimension(500, 45));

         head = new JLabel("JPMS");
        head.setFont(new Font("Bauhaus 93", Font.PLAIN, 60));
        head.setHorizontalAlignment(JLabel.CENTER);
        head.setVerticalAlignment(JLabel.TOP);
        head.setPreferredSize(new Dimension(150, 0));

        name = new JLabel("Piyanut  *");
        name.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setPreferredSize(new Dimension(150, 0));

        btn_dashboard = new JButton("Dashboard");
        btn_dashboard.setFont(new Font("Century Gothic", Font.BOLD, 20));
        btn_dashboard.setPreferredSize(new Dimension(200, 50));
        btn_customers = new JButton("Customers");
        btn_customers.setFont(new Font("Century Gothic", Font.BOLD, 20));
        btn_customers.setPreferredSize(new Dimension(200, 50));
        btn_redemption = new JButton("Pawn Droppings");
        btn_redemption.setFont(new Font("Century Gothic", Font.BOLD, 20));
        btn_redemption.setPreferredSize(new Dimension(200, 50));

        //Mid
        dashboard = new DashBoard_GUI();
        currentPanel = dashboard;

        //East
        east = new JPanel();
        east.setPreferredSize(new Dimension(50, 500));
        east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
        next = new JButton(nextIcon);
        east.add(Box.createVerticalGlue());
        east.add(next);
        east.add(Box.createVerticalGlue());
        east.setBackground(c3);
        next.setVisible(false);
        next.setVerticalAlignment(SwingConstants.CENTER);
        next.setPreferredSize(new Dimension(40, 100));

        //West
        west = new JPanel();
        west.setPreferredSize(new Dimension(50, 500));
//        west.setBorder(BorderFactory.createLineBorder(Color.RED));
        west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
        prev = new JButton(prevIcon);
        west.add(Box.createVerticalGlue());
        west.add(prev);
        west.add(Box.createVerticalGlue());
        west.setBackground(c3);
        prev.setVisible(false);
        prev.setVerticalAlignment(SwingConstants.CENTER);
        prev.setPreferredSize(new Dimension(40, 100));

        //South
        south = new JPanel();
        south.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        south.setPreferredSize(new Dimension(1100, 100));
        south.setBackground(c1);
        btn_chart = new Button_Chart(fr,this);
        btn_chart.addActionListener(this);
        south.add(btn_chart);
        

        //Add Listener
        fr.addWindowListener(this);
        btn_dashboard.addActionListener(this);
        btn_customers.addActionListener(this);
        btn_redemption.addActionListener(this);
        btn_seacrh.addActionListener(this);
        btn_new_customer.addActionListener(this);
        prev.addActionListener(this);
        next.addActionListener(this);

        //Set Frame
        fr.setLayout(new BorderLayout());
        north.setLayout(new GridLayout(3, 1));
        north.add(top);
        north.add(select_button);
        north.add(search);
        top.add(Box.createRigidArea(new Dimension(0, 0)));
        top.add(head, BorderLayout.WEST);
        top.add(name, BorderLayout.EAST);
        select_button.add(btn_dashboard);
        select_button.add(btn_customers);
        select_button.add(btn_redemption);
        search.add(lb_search1);
        search.add(search_id);
        search.add(btn_seacrh);
        search.add(btn_new_customer);
        fr.add(north, BorderLayout.NORTH);
        fr.add(east, BorderLayout.EAST);
        fr.add(west, BorderLayout.WEST);
        fr.add(south, BorderLayout.SOUTH);
        fr.add(currentPanel);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setResizable(true);
        fr.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btn_dashboard)) {
            south.removeAll();
            search.setVisible(false);
            fr.remove(currentPanel);
            dashboard = new DashBoard_GUI();
            currentPanel = dashboard;
            fr.add(currentPanel);
            south.add(btn_chart);

            // unshow buttons
            prev.setVisible(false);
            next.setVisible(false);

        } else if (e.getSource().equals(btn_customers)) {
            search.setVisible(true);
            btn_new_customer.setVisible(true);
            fr.remove(currentPanel);
            customers = new CustomerInfo_GUI();
            currentPanel = customers;
            fr.add(currentPanel);

            //Add Button At South
            south.removeAll();
            btn_addmoney = new Button_AddPawngoods(fr, customers);
            btn_payinterest = new Button_SendInterest(fr, customers);
            btn_redeem = new Button_Redeem(fr, customers);
            
            btn_addmoney.setFont(regF);
            btn_addmoney.setPreferredSize(new Dimension(200, 50));
            btn_payinterest.setFont(regF);
            btn_payinterest.setPreferredSize(new Dimension(200, 50));
            btn_redeem.setFont(regF);
            btn_redeem.setPreferredSize(new Dimension(200, 50));

            btn_addmoney.addActionListener(btn_addmoney);
            btn_payinterest.addActionListener(btn_payinterest);
            btn_redeem.addActionListener(btn_redeem);
            south.add(btn_addmoney);
            south.add(btn_payinterest);
            south.add(btn_redeem);

            // show buttons
            prev.setVisible(true);
            next.setVisible(true);

        } else if (e.getSource().equals(btn_redemption)) {
            search.setVisible(true);
            btn_new_customer.setVisible(false);
            fr.remove(currentPanel);
            redemption = new pawn_droppings_GUI();
            currentPanel = redemption;
            fr.add(currentPanel);

            //Add Button At South
            south.removeAll();
            btn_sell = new Button_Sell((pawn_droppings_GUI) currentPanel);
            btn_sell.setFont(regF);
            btn_sell.setPreferredSize(new Dimension(200, 50));
            
            btn_selectall = new Button_SelectAll((pawn_droppings_GUI) currentPanel);
            btn_selectall.setFont(regF);
            btn_selectall.setPreferredSize(new Dimension(200, 50));
            
            south.add(btn_selectall);
            south.add(btn_sell);
            
            // unshow buttons
            prev.setVisible(false);
            next.setVisible(false);

        } else if (e.getSource().equals(btn_seacrh)) {
            try {
                if (currentPanel == customers) {
                    btn_addmoney.setEnabled(true);
                    btn_redeem.setEnabled(true);
                    btn_payinterest.setEnabled(true);
                    System.out.println(search_id.getText());
                    customers.UpdateGUI(search_id.getText());
                    search_id.setText(null);
                } else {
                    redemption.Search(search_id.getText());
                    search_id.setText(null);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter id!", "", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource().equals(btn_new_customer)) {
            new New_CustomerGUI(fr);
            
        } else if (e.getSource().equals(prev) ) {
            
            if (customers.getCurrent_customer() == null) {
                customers.UpdateGUI(-1);
            }
            else {
                customers.UpdateGUI(customers.getCurrent_customer().getId()-1);
            }
        } else if (e.getSource().equals(next)) {
            if (customers.getCurrent_customer() == null) {
                customers.UpdateGUI(1);
                btn_addmoney.setEnabled(true);
                btn_redeem.setEnabled(true);
                btn_payinterest.setEnabled(true);
            }
            else {
                customers.UpdateGUI(customers.getCurrent_customer().getId()+1);
            }
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
            
            //test add money 
            double money = 1500000;
            info.setCapital(money);
            info.setCurrent_money(money);
            info.update_customer();
            info.update_pawngoods();
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

    public JInternalFrame getCurrentPanel() {
        return currentPanel;
    }

    public void setCurrentPanel(JInternalFrame currentPanel) {
        this.currentPanel = currentPanel;
    }
    
    

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        new MainGUI();
    }

}
