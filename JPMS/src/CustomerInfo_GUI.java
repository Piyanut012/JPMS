
import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.awt.event.*;

public class CustomerInfo_GUI extends JInternalFrame implements ActionListener {

    private final Font regF = new Font("Century Gothic", Font.PLAIN, 18);
    private final Font regFB = new Font("Century Gothic", Font.BOLD, 20);
    private final ImageIcon gold = new ImageIcon("gold.jpg");
    private JPanel midPn, leftPn, rightPn, itemPn, cstPn, iteminfoPn, cstinfo1Pn, editcstPn;
    private JLabel itemLb, cinfoLb, itempicLb, itemidLb, itemnameLb, itempriceLb, itemstatusLb, idLb, nameLb, telLb, adrsLb, mailLb, fbLb, lineLb, loanLb;
    private Customer current_customer;
    private LinkedHashMap<Integer, Pawn> itmes_data;
    private JPanel panelContainer;
    private JTextField nameTf, telTf, adrsTf, mailTf, fbTf, lineTf, loanTf;
    private JButton editBtn;

    public CustomerInfo_GUI() {
        midPn = new JPanel(new GridLayout(1, 2));
        leftPn = new JPanel(new BorderLayout());
        rightPn = new JPanel(new BorderLayout());
//        itemPn = new JPanel(new GridLayout(1, 2));
        cstPn = new JPanel(new GridLayout(1, 2));
//        iteminfoPn = new JPanel(new GridLayout(4, 1));
        cstinfo1Pn = new JPanel(new GridLayout(8, 2));
        editcstPn = new JPanel(new BorderLayout());
        itemLb = new JLabel("Pawned Item(s)");
        cinfoLb = new JLabel("Customer's Info");
//        itempicLb = new JLabel(gold);
//        itemidLb = new JLabel("ID : ");
//        itemnameLb = new JLabel("Name : ");
//        itempriceLb = new JLabel("Price : ");
//        itemstatusLb = new JLabel("Status : ");
        idLb = new JLabel("ID : ");
        nameLb = new JLabel("Name : ");
        telLb = new JLabel("Phone Number : ");
        adrsLb = new JLabel("Address : ");
        mailLb = new JLabel("E-mail : ");
        loanLb = new JLabel("Loan : ");
        fbLb = new JLabel("Facebook : ");
        lineLb = new JLabel("Line : ");
        nameTf = new JTextField();
        nameTf.setEditable(false);
        telTf = new JTextField();
        telTf.setEditable(false);
        adrsTf = new JTextField();
        adrsTf.setEditable(false);
        mailTf = new JTextField();
        mailTf.setEditable(false);
        fbTf = new JTextField();
        fbTf.setEditable(false);
        lineTf = new JTextField();
        lineTf.setEditable(false);
        loanTf = new JTextField();
        loanTf.setEditable(false);
        editBtn = new JButton("Edit");
        editBtn.setFont(regF);

        // set jframe
        this.setLayout(new BorderLayout());

        // set main panel
        leftPn.add(itemLb, BorderLayout.NORTH);
        itemLb.setHorizontalAlignment(SwingConstants.CENTER);
        itemLb.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
/////------***************************
        panelContainer = new JPanel();
        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));

        setPawnedItem(0, "", 0, "");
        idLb.setFont(regFB);
        nameLb.setFont(regF);
        telLb.setFont(regF);
        adrsLb.setFont(regF);
        mailLb.setFont(regF);
        fbLb.setFont(regF);
        lineLb.setFont(regF);
        loanLb.setFont(regFB);
        nameTf.setFont(regF);
        telTf.setFont(regF);
        adrsTf.setFont(regF);
        mailTf.setFont(regF);
        fbTf.setFont(regF);
        lineTf.setFont(regF);
        loanTf.setFont(regFB);

        JScrollPane scroller = new JScrollPane(panelContainer);
        leftPn.add(scroller, BorderLayout.CENTER);
////-------*******************
        editcstPn.add(cinfoLb, BorderLayout.CENTER);
        editcstPn.add(editBtn, BorderLayout.EAST);
        rightPn.add(editcstPn, BorderLayout.NORTH);
        cinfoLb.setHorizontalAlignment(SwingConstants.CENTER);
        editcstPn.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        cstinfo1Pn.add(idLb);
        cstinfo1Pn.add(new JPanel());
        cstinfo1Pn.add(nameLb);
        cstinfo1Pn.add(nameTf);
        cstinfo1Pn.add(telLb);
        cstinfo1Pn.add(telTf);
        cstinfo1Pn.add(adrsLb);
        cstinfo1Pn.add(adrsTf);
        cstinfo1Pn.add(mailLb);
        cstinfo1Pn.add(mailTf);
        cstinfo1Pn.add(fbLb);
        cstinfo1Pn.add(fbTf);
        cstinfo1Pn.add(lineLb);
        cstinfo1Pn.add(lineTf);
        cstinfo1Pn.add(loanLb);
        cstinfo1Pn.add(loanTf);
        cstinfo1Pn.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        cstPn.add(cstinfo1Pn);
        rightPn.add(cstPn, BorderLayout.CENTER);
        cstPn.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));

        leftPn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        rightPn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        midPn.add(leftPn);
        midPn.add(rightPn);

        // set button
        editBtn.addActionListener(this);

        // add to frame
        this.add(midPn, BorderLayout.CENTER);

        // show
        this.setPreferredSize(new Dimension(1050, 500));
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.setFrameIcon(null);
        this.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        this.setVisible(true);
    }

    public void Search(String kw) {
        int keyword = Integer.parseInt(kw);
        try {
            //Set Infomation Customer
            current_customer = MainGUI.getInfo().getCustomers_Data().get(keyword);
            idLb.setText("ID : " + current_customer.getId());
            nameTf.setText(current_customer.getName());
            telTf.setText(current_customer.getPhone_number());
            adrsTf.setText(current_customer.getAddress());
            mailTf.setText(current_customer.getEmail());
            fbTf.setText(current_customer.getFB());
            lineTf.setText(current_customer.getIDline());
            loanTf.setText(current_customer.getPrinciple() + "");

            //Set Pawned Item
            panelContainer.removeAll();
            System.out.println("Yes");
            itmes_data = current_customer.getItmes_data();
            for (Pawn p : itmes_data.values()) {
                String status = p.getDate() + "/" + p.getMonth() + "/" + p.getYear();
                setPawnedItem(p.getID(), p.getName(), p.getValue(), status);
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Customer not found!", "", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void setPawnedItem(int id, String name, double price, String status) {
        itemPn = new JPanel(new GridLayout(1, 2));
        iteminfoPn = new JPanel(new GridLayout(4, 1));
        itempicLb = new JLabel(gold);
        itemidLb = new JLabel("ID : " + id);
        itemnameLb = new JLabel("Name : " + name);
        itempriceLb = new JLabel("Price : " + price);
        itemstatusLb = new JLabel("Status : " + status);
        iteminfoPn.add(itemidLb);
        iteminfoPn.add(itemnameLb);
        iteminfoPn.add(itempriceLb);
        iteminfoPn.add(itemstatusLb);
        iteminfoPn.setBorder(BorderFactory.createEmptyBorder(60, 20, 60, 20));
        itemPn.add(itempicLb);
        itemPn.add(iteminfoPn);
        itemPn.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.BLACK));
        itemLb.setFont(regFB);
        cinfoLb.setFont(regFB);
        itemidLb.setFont(regF);
        itemnameLb.setFont(regF);
        itempriceLb.setFont(regF);
        itemstatusLb.setFont(regF);
        panelContainer.add(itemPn);
    }

    boolean notEditing = true;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (notEditing) {
            notEditing = !notEditing;
            editBtn.setText("Edit");
            nameTf.setEditable(notEditing);
            telTf.setEditable(notEditing);
            adrsTf.setEditable(notEditing);
            mailTf.setEditable(notEditing);
            fbTf.setEditable(notEditing);
            lineTf.setEditable(notEditing);
//            loanTf.setEditable(notEditing);
            
            current_customer = MainGUI.getInfo().getCustomers_Data().get(current_customer.getId());
            current_customer.setName(nameTf.getText());
            current_customer.setPhone_number(telTf.getText());
            current_customer.setAddress(adrsTf.getText());
            current_customer.setEmail(mailTf.getText());
            current_customer.setFB(fbTf.getText());
            current_customer.setIDline(lineTf.getText());
//            customer.setPrinciple(Double.parseDouble(loanTf.getText()));
            current_customer.setName(nameTf.getText());
        } else {
            notEditing = !notEditing;
            editBtn.setText("Save");
            nameTf.setEditable(notEditing);
            telTf.setEditable(notEditing);
            adrsTf.setEditable(notEditing);
            mailTf.setEditable(notEditing);
            fbTf.setEditable(notEditing);
            lineTf.setEditable(notEditing);
//            loanTf.setEditable(notEditing);
        }
    }
}
