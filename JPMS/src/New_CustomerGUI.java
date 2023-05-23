

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.*;

public class New_CustomerGUI implements ActionListener {
    
    private final Font regF = new Font("Century Gothic", Font.PLAIN, 14);
    private final Font regFB = new Font("Century Gothic", Font.BOLD, 16);
    private final Color c4 = new Color(250, 237, 205);
    private JDialog dialog;
    private JPanel pa;
    private JLabel lb1;
    private JLabel lb2;
    private JLabel lb3;
    private JLabel lb4;
    private JLabel lb5;
    private JLabel jcomp7;
    private JLabel lb6;
    private JTextField te1;
    private JTextField te2;
    private JTextField te3;
    private JTextField te4;
    private JTextField te5;
    private JTextField te6;
    private JButton bu;
    private int id;

    public New_CustomerGUI(JFrame parentFrame) {
        id = MainGUI.getInfo().getAdd_id_customer();
        dialog = new JDialog(parentFrame, "New Customer", true);  
        pa = new JPanel();
        lb1 = new JLabel ("ID : " + id); lb1.setFont(regFB);
        lb2 = new JLabel ("Name :"); lb2.setFont(regF);
        lb3 = new JLabel ("Phone : "); lb3.setFont(regF);
        lb4 = new JLabel ("Address :"); lb4.setFont(regF);
        lb5 = new JLabel ("E-mail :"); lb5.setFont(regF);
        jcomp7 = new JLabel ("FB :"); jcomp7.setFont(regF);
        lb6 = new JLabel ("Line : "); lb6.setFont(regF);
        te1 = new JTextField (); te1.setFont(regF);
        te2 = new JTextField (); te2.setFont(regF);
        te3 = new JTextField (); te3.setFont(regF);
        te4 = new JTextField (); te4.setFont(regF);
        te5 = new JTextField (); te5.setFont(regF);
        te6 = new JTextField (); te6.setFont(regF);
        bu = new JButton ("Next"); bu.setFont(regF);

        pa.setPreferredSize (new Dimension (350, 300));
        pa.setLayout (null);
        
        bu.addActionListener(this);
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MainGUI.getInfo().setAdd_id_customer(id - 1);
            }
        });

        pa.add (lb1);
        pa.add (lb2);
        pa.add (lb3);
        pa.add (lb4);
        pa.add (lb5);
        pa.add (jcomp7);
        pa.add (lb6);
        pa.add (te1);
        pa.add (te2);
        pa.add (te3);
        pa.add (te4);
        pa.add (te5);
        pa.add (te6);
        pa.add (bu);
        dialog.add(pa);
        
        lb1.setBounds (150, 10, 100, 25);
        lb2.setBounds (20, 55, 100, 25);
        lb3.setBounds (20, 80, 100, 25);
        lb4.setBounds (20, 105, 100, 25);
        lb5.setBounds (20, 130, 100, 25);
        jcomp7.setBounds (20, 155, 100, 25);
        lb6.setBounds (20, 180, 100, 25);
        te1.setBounds (85, 55, 240, 30);
        te2.setBounds (85, 80, 240, 30);
        te3.setBounds (85, 105, 240, 30);
        te4.setBounds (85, 130, 240, 30);
        te5.setBounds (85, 155, 240, 30);
        te6.setBounds (85, 180, 240, 30);
        bu.setBounds (250, 250, 75, 35);
        
        pa.setBackground(c4);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(parentFrame);
        dialog.setResizable(false);
        dialog.pack();
        dialog.setVisible (true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(bu)){
            Customer c = new New_Customer(id ,te1.getText(), te2.getText(), te3.getText(), te4.getText(), te5.getText(), te6.getText());
            new New_AddPawngoodsGUI(dialog, c);
        }
    }
}
