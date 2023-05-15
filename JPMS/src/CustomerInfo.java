
import javax.swing.*;
import java.awt.*;

public class CustomerInfo extends JInternalFrame {

    private final Font regF = new Font("Century Gothic", Font.BOLD, 18);
    private final ImageIcon gold = new ImageIcon("gold.jpg");
    private JPanel midPn, leftPn, rightPn, itemPn, cstPn, iteminfoPn, cstinfo1Pn, cstinfo2Pn, enterPn;
    private JLabel itemLb, cinfoLb, itempicLb, itemidLb, itemnameLb, itempriceLb, itemstatusLb, nameLb, telLb, adrsLb, mailLb, mnyLb, intrLb;

    public CustomerInfo() {
        midPn = new JPanel(new GridLayout(1, 2));
        leftPn = new JPanel(new BorderLayout());
        rightPn = new JPanel(new BorderLayout());
//        itemPn = new JPanel(new GridLayout(1, 2));
        cstPn = new JPanel(new GridLayout(1, 2));
//        iteminfoPn = new JPanel(new GridLayout(4, 1));
        cstinfo1Pn = new JPanel(new GridLayout(4, 1));
        cstinfo2Pn = new JPanel(new GridLayout(2, 1));
        enterPn = new JPanel(new BorderLayout(20, 0));
        itemLb = new JLabel("Pawned Item(s)");
        cinfoLb = new JLabel("Customer's Info");
//        itempicLb = new JLabel(gold);
//        itemidLb = new JLabel("ID : ");
//        itemnameLb = new JLabel("Name : ");
//        itempriceLb = new JLabel("Price : ");
//        itemstatusLb = new JLabel("Status : ");
        nameLb = new JLabel("Name : ");
        telLb = new JLabel("Phone Number : ");
        adrsLb = new JLabel("Address : ");
        mailLb = new JLabel("E-mail : ");
        mnyLb = new JLabel("Money : ");
        intrLb = new JLabel("Interest Rate : ");

        // set jframe
        this.setLayout(new BorderLayout());

        // set main panel
        leftPn.add(itemLb, BorderLayout.NORTH);
        itemLb.setHorizontalAlignment(SwingConstants.CENTER);
        itemLb.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
/////------***************************
        JPanel panelContainer = new JPanel();
        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));

        for (int i = 0; i < 6; i++) {
            itemPn = new JPanel(new GridLayout(1, 2));
            iteminfoPn = new JPanel(new GridLayout(4, 1));
            itempicLb = new JLabel(gold);
            itemidLb = new JLabel("ID : ");
            itemnameLb = new JLabel("Name : ");
            itempriceLb = new JLabel("Price : ");
            itemstatusLb = new JLabel("Status : ");
            iteminfoPn.add(itemidLb);
            iteminfoPn.add(itemnameLb);
            iteminfoPn.add(itempriceLb);
            iteminfoPn.add(itemstatusLb);
            iteminfoPn.setBorder(BorderFactory.createEmptyBorder(60, 20, 60, 20));
            itemPn.add(itempicLb);
            itemPn.add(iteminfoPn);
            itemPn.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.BLACK));
            itemLb.setFont(regF);
            cinfoLb.setFont(regF);
            itemidLb.setFont(regF);
            itemnameLb.setFont(regF);
            itempriceLb.setFont(regF);
            itemstatusLb.setFont(regF);
            nameLb.setFont(regF);
            telLb.setFont(regF);
            adrsLb.setFont(regF);
            mailLb.setFont(regF);
            mnyLb.setFont(regF);
            intrLb.setFont(regF);
            panelContainer.add(itemPn);
        }
        JScrollPane scroller = new JScrollPane(panelContainer);
        leftPn.add(scroller, BorderLayout.CENTER);
////-------*******************
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

        // add to frame
        this.add(midPn, BorderLayout.CENTER);

        // show
        this.setPreferredSize(new Dimension(1050, 500));
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.setFrameIcon(null);
        this.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        this.setVisible(true);
    }
}
