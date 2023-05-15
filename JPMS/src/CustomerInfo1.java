
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomerInfo1 implements ActionListener {

    private final Font titleF = new Font("Bauhaus 93", Font.PLAIN, 54);
    private final Font regF = new Font("Century Gothic", Font.BOLD, 18);
//    private final Color bgClr = new Color(171, 120, 48); // brown
//    private final Color pnClr = new Color(230, 184, 69); // orange
    private final ImageIcon searchIcon = new ImageIcon("SearchIcon.png");
    private final ImageIcon addIcon = new ImageIcon("addIcon.png");
    private final ImageIcon gold = new ImageIcon("gold.jpg");
    private final ImageIcon checkIcon = new ImageIcon("checkIcon.png");
    private JFrame mainFr;
    private JPanel upperPn, midPn, lowerPn, titlePn, searchPn, leftPn, rightPn, itemPn, cstPn, iteminfoPn, cstinfo1Pn, cstinfo2Pn, pagePn, enterPn;
    private JLabel jpmsLb, adminLb, cstLb, itemLb, cinfoLb, itempicLb, itemidLb, itemnameLb, itempriceLb, itemstatusLb, nameLb, telLb, adrsLb, mailLb, mnyLb, intrLb;
    private JTextField searchTf, pageTf;
    private JButton addcstBtn, addmnyBtn, intrBtn, redeemBtn, prevBtn, nextBtn, enterBtn;
    
    public CustomerInfo1() {
        mainFr = new JFrame("Java Pawnbroker Management System");
        upperPn = new JPanel(new GridLayout(2, 1));
        midPn = new JPanel(new GridLayout(1, 2));
        lowerPn = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
        titlePn = new JPanel(new GridLayout(1, 2));
        searchPn = new JPanel(new BorderLayout(20, 0));
        leftPn = new JPanel(new BorderLayout());
        rightPn = new JPanel(new BorderLayout());
        itemPn = new JPanel(new GridLayout(1, 2));
        cstPn = new JPanel(new GridLayout(1, 2));
        pagePn = new JPanel();
        iteminfoPn = new JPanel(new GridLayout(4, 1));
        cstinfo1Pn = new JPanel(new GridLayout(4, 1));
        cstinfo2Pn = new JPanel(new GridLayout(2, 1));
        enterPn = new JPanel(new BorderLayout(20, 0));
        jpmsLb = new JLabel("J P M S");
        adminLb = new JLabel("Parit");
        cstLb = new JLabel("Customer");
        itemLb = new JLabel("Pawned Item(s)");
        cinfoLb = new JLabel("Customer's Info");
        itempicLb = new JLabel(gold);
        itemidLb = new JLabel("ID : ");
        itemnameLb = new JLabel("Name : ");
        itempriceLb = new JLabel("Price : ");
        itemstatusLb = new JLabel("Status : ");
        nameLb = new JLabel("Name : ");
        telLb = new JLabel("Phone Number : ");
        adrsLb = new JLabel("Address : ");
        mailLb = new JLabel("E-mail : ");
        mnyLb = new JLabel("Money : ");
        intrLb = new JLabel("Interest Rate : ");
        pageTf = new JTextField("1", 3);
        pageTf.setEditable(false);
        pageTf.setHorizontalAlignment(JTextField.CENTER);
        searchTf = new JTextField();
        addcstBtn = new JButton("Add Customer", addIcon);
        addmnyBtn = new JButton("Add Money");
        intrBtn = new JButton("Pay Interest");
        redeemBtn = new JButton("Redeem Item");
        prevBtn = new JButton("< Previous");
        nextBtn = new JButton("Next >");
        enterBtn = new JButton(checkIcon);

        // set jframe
        mainFr.setLayout(new BorderLayout());
        mainFr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // search Icon
        cstLb.setIcon(searchIcon);
        cstLb.setHorizontalTextPosition(SwingConstants.LEFT);

        // set panel space
        titlePn.setBorder(BorderFactory.createEmptyBorder(20, 20, -40, 20));
        searchPn.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        lowerPn.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        midPn.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 60));

        // set outer panels
        titlePn.add(jpmsLb);
        titlePn.add(adminLb);
        adminLb.setHorizontalAlignment(SwingConstants.RIGHT);
        searchPn.add(cstLb, BorderLayout.WEST);
        searchPn.add(searchTf, BorderLayout.CENTER);
        enterPn.add(enterBtn, BorderLayout.WEST);
        enterPn.add(addcstBtn, BorderLayout.CENTER);
        searchPn.add(enterPn, BorderLayout.EAST);
        upperPn.add(titlePn);
        upperPn.add(searchPn);
        lowerPn.add(addmnyBtn);
        lowerPn.add(intrBtn);
        lowerPn.add(redeemBtn);

        // set main panel
        leftPn.add(itemLb, BorderLayout.NORTH);
        itemLb.setHorizontalAlignment(SwingConstants.CENTER);
        itemLb.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        iteminfoPn.add(itemidLb);
        iteminfoPn.add(itemnameLb);
        iteminfoPn.add(itempriceLb);
        iteminfoPn.add(itemstatusLb);
        iteminfoPn.setBorder(BorderFactory.createEmptyBorder(60, 20, 60, 20));
        itemPn.add(itempicLb);
        itemPn.add(iteminfoPn);
        itemPn.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.BLACK));
        leftPn.add(itemPn, BorderLayout.CENTER);
        pagePn.add(prevBtn);
        pagePn.add(pageTf);
        pagePn.add(nextBtn);
        leftPn.add(pagePn, BorderLayout.SOUTH);

        rightPn.add(cinfoLb, BorderLayout.NORTH);
        cinfoLb.setHorizontalAlignment(SwingConstants.CENTER);
        cinfoLb.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        cstinfo1Pn.add(nameLb);
        cstinfo1Pn.add(telLb);
        cstinfo1Pn.add(adrsLb);
        cstinfo1Pn.add(mailLb);
        cstinfo2Pn.add(mnyLb);
        cstinfo2Pn.add(intrLb);
        cstinfo1Pn.setBorder(BorderFactory.createEmptyBorder(80, 20, 80, 20));
        cstinfo2Pn.setBorder(BorderFactory.createEmptyBorder(80, 20, 80, 20));
        cstPn.add(cstinfo1Pn);
        cstPn.add(cstinfo2Pn);
        rightPn.add(cstPn, BorderLayout.CENTER);
        cstPn.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));

        leftPn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        rightPn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        midPn.add(leftPn);
        midPn.add(rightPn);

        // set font and size
        jpmsLb.setFont(titleF);
        adminLb.setFont(regF);
        cstLb.setFont(regF);
        searchTf.setFont(regF);
        addcstBtn.setFont(regF);
        itemLb.setFont(regF);
        cinfoLb.setFont(regF);
        itemidLb.setFont(regF);
        itemnameLb.setFont(regF);
        itempriceLb.setFont(regF);
        itemstatusLb.setFont(regF);
        prevBtn.setFont(regF);
        prevBtn.setPreferredSize(new Dimension(130, 30));
        nextBtn.setFont(regF);
        nextBtn.setPreferredSize(new Dimension(130, 30));
        pageTf.setFont(regF);
        nameLb.setFont(regF);
        telLb.setFont(regF);
        adrsLb.setFont(regF);
        mailLb.setFont(regF);
        mnyLb.setFont(regF);
        intrLb.setFont(regF);
        addmnyBtn.setFont(regF);
        intrBtn.setFont(regF);
        redeemBtn.setFont(regF);
        
        // add listener
        addcstBtn.addActionListener(this);
        addmnyBtn.addActionListener(this);
        intrBtn.addActionListener(this);
        redeemBtn.addActionListener(this);
        prevBtn.addActionListener(this);
        nextBtn.addActionListener(this);
        enterBtn.addActionListener(this);
        
        // add to frame
        mainFr.add(upperPn, BorderLayout.NORTH);
        mainFr.add(midPn, BorderLayout.CENTER);
        mainFr.add(lowerPn, BorderLayout.SOUTH);

        // show
        mainFr.setSize(1000, 700);
        mainFr.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(addcstBtn)) {
            System.out.println("1");
        }
        if (ae.getSource().equals(addmnyBtn)) {
            System.out.println("2");
        }
        if (ae.getSource().equals(intrBtn)) {
            System.out.println("3");
        }
        if (ae.getSource().equals(redeemBtn)) {
            System.out.println("4");
        }
        if (ae.getSource().equals(prevBtn)) {
            System.out.println("5");
        }
        if (ae.getSource().equals(nextBtn)) {
            System.out.println("6");
        }
        if (ae.getSource().equals(enterBtn)) {
            System.out.println("7");
        }

    }

    public static void main(String[] args) {
        new CustomerInfo1();
    }
}
