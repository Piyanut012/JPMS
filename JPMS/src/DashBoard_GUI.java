
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;


public class DashBoard_GUI extends JInternalFrame{
    private final Font regF = new Font("Century Gothic", Font.PLAIN, 18);
    private final Font regFB = new Font("Century Gothic", Font.BOLD, 20);
    private final Color c3 = new Color(250, 237, 205);
    private JPanel pl1, pl2, pl3, pl4, pl5, pl6, pl7, pl8,
            pl9, pl10, pl11, pl12, pl13, pl14, pl15, pl16, 
            pl17, pl18, pl19, pl20, pl21, pl22, pl23, pl24;
    private JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8,
            lb9, lb10, lb11, lb12, lb13, lb14, lb15, lb16,
            lb17, lb18, lb19, lb20, lb21, lb22, lb23, lb24;
    
    public DashBoard_GUI(){
        pl1 = new JPanel(new BorderLayout());
        pl2 = new JPanel(new BorderLayout());
        pl3 = new JPanel(new BorderLayout());
        pl4 = new JPanel(new BorderLayout());
        pl5 = new JPanel(new BorderLayout());
        pl6 = new JPanel(new BorderLayout());
        pl7 = new JPanel(new BorderLayout());
        pl8 = new JPanel(new BorderLayout());
        
        pl9 = new JPanel(new GridLayout(2, 1)); pl9.setBackground(c3);
        pl10 = new JPanel(new GridLayout(2, 1)); pl10.setBackground(c3);
        pl11 = new JPanel(new GridLayout(2, 1)); pl11.setBackground(c3);
        pl12 = new JPanel(new GridLayout(2, 1)); pl12.setBackground(c3);
        pl13 = new JPanel(new GridLayout(2, 1)); pl13.setBackground(c3);
        pl14 = new JPanel(new GridLayout(2, 1)); pl14.setBackground(c3);
        pl15 = new JPanel(new GridLayout(2, 1)); pl15.setBackground(c3);
        pl16 = new JPanel(new GridLayout(2, 1)); pl16.setBackground(c3);

        pl17 = new JPanel(new BorderLayout()); pl17.setBackground(c3);
        pl18 = new JPanel(new BorderLayout()); pl18.setBackground(c3);
        pl19 = new JPanel(new BorderLayout()); pl19.setBackground(c3);
        pl20 = new JPanel(new BorderLayout()); pl20.setBackground(c3);
        pl21 = new JPanel(new BorderLayout()); pl21.setBackground(c3);
        pl22 = new JPanel(new BorderLayout()); pl22.setBackground(c3);
        pl23 = new JPanel(new BorderLayout()); pl23.setBackground(c3);
        pl24 = new JPanel(new BorderLayout()); pl24.setBackground(c3);

        ImageIcon icon;
        BufferedImage image;
        try {
            image = ImageIO.read(new File("image/funds.png"));
            icon = new ImageIcon(image); 
            lb1 = new JLabel(icon);
            
            image = ImageIO.read(new File("image/current.png"));
            icon = new ImageIcon(image); 
            lb4 = new JLabel(icon);
            
            image = ImageIO.read(new File("image/loan.png"));
            icon = new ImageIcon(image);
            lb7 = new JLabel(icon);
            
            image = ImageIO.read(new File("image/user.png"));
            icon = new ImageIcon(image);
            lb10 = new JLabel(icon);
            
            image = ImageIO.read(new File("image/pledged.png"));
            icon = new ImageIcon(image);
            lb13 = new JLabel(icon);
            
            image = ImageIO.read(new File("image/pawned.png"));
            icon = new ImageIcon(image);
            lb16 = new JLabel(icon);
            
            image = ImageIO.read(new File("image/difference.png"));
            icon = new ImageIcon(image);
            lb19 = new JLabel(icon);
            
            image = ImageIO.read(new File("image/sold.png"));
            icon = new ImageIcon(image);
            lb22 = new JLabel(icon);
            
        } catch (IOException ex) {
            Logger.getLogger(DashBoard_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lb2 = new JLabel("Capital");
        lb2.setFont(regF);
        lb3 = new JLabel(MainGUI.getInfo().getCapital()+"");
        lb3.setFont(regFB);
        lb3.setForeground(Color.CYAN);
        
        lb5 = new JLabel("Current Money");
        lb5.setFont(regF);
        lb6 = new JLabel(MainGUI.getInfo().getCurrent_money()+"");
        lb6.setFont(regFB);
        lb6.setForeground(Color.ORANGE);
        
        lb8 = new JLabel("Loan");
        lb8.setFont(regF);
        lb9 = new JLabel(MainGUI.getInfo().getLoan()+"");
        lb9.setFont(regFB);
        lb9.setForeground(Color.RED);
        
        lb11 = new JLabel("Users");
        lb11.setFont(regF);
        lb12 = new JLabel(MainGUI.getInfo().getId_customer_all()+"");
        lb12.setFont(regFB);
        lb12.setForeground(Color.BLUE);
        
        lb14 = new JLabel("Pawn Goods");
        lb14.setFont(regF);
        lb15 = new JLabel(MainGUI.getInfo().getPawn_goods()+"");
        lb15.setFont(regFB);
        lb15.setForeground(Color.MAGENTA);
        
        lb17 = new JLabel("Pawn Droppings");
        lb17.setFont(regF);
        lb18 = new JLabel(MainGUI.getInfo().getPawn_droppings()+"");
        lb18.setFont(regFB);
        lb18.setForeground(Color.GREEN);
        
        lb20 = new JLabel("Profit");
        lb20.setFont(regF);
        lb21 = new JLabel(MainGUI.getInfo().getProfit()+"");
        lb21.setFont(regFB);
        lb21.setForeground(Color.GREEN);
        
        lb23 = new JLabel("Sale");
        lb23.setFont(regF);
        lb24 = new JLabel(MainGUI.getInfo().getSold()+"");
        lb24.setFont(regFB);
        lb24.setForeground(Color.RED);
        
        pl1.add(lb1, BorderLayout.WEST);
        pl1.add(pl17);
        pl17.add(Box.createRigidArea(new Dimension(80, 80)), BorderLayout.NORTH); pl17.add(Box.createRigidArea(new Dimension(80, 80)), BorderLayout.SOUTH); pl17.add(pl9);
        pl9.add(lb2); pl9.add(lb3);
        
        pl2.add(lb4, BorderLayout.WEST);
        pl2.add(pl18);
        pl18.add(Box.createRigidArea(new Dimension(80, 80)), BorderLayout.NORTH); pl18.add(Box.createRigidArea(new Dimension(80, 80)), BorderLayout.SOUTH); pl18.add(pl10);
        pl10.add(lb5); pl10.add(lb6);
        
        pl3.add(lb7, BorderLayout.WEST);
        pl3.add(pl19);
        pl19.add(Box.createRigidArea(new Dimension(80, 80)), BorderLayout.NORTH); pl19.add(Box.createRigidArea(new Dimension(80, 80)), BorderLayout.SOUTH); pl19.add(pl11);
        pl11.add(lb8); pl11.add(lb9);
        
        pl4.add(lb10, BorderLayout.WEST);
        pl4.add(pl20);
        pl20.add(Box.createRigidArea(new Dimension(80, 80)), BorderLayout.NORTH); pl20.add(Box.createRigidArea(new Dimension(80, 80)), BorderLayout.SOUTH); pl20.add(pl12);
        pl12.add(lb11); pl12.add(lb12);
        
        pl5.add(lb13, BorderLayout.WEST);
        pl5.add(pl21);
        pl21.add(Box.createRigidArea(new Dimension(80, 80)), BorderLayout.NORTH); pl21.add(Box.createRigidArea(new Dimension(80, 80)), BorderLayout.SOUTH); pl21.add(pl13);
        pl13.add(lb14); pl13.add(lb15);
        
        pl6.add(lb16, BorderLayout.WEST);
        pl6.add(pl22);
        pl22.add(Box.createRigidArea(new Dimension(80, 80)), BorderLayout.NORTH); pl22.add(Box.createRigidArea(new Dimension(80, 80)), BorderLayout.SOUTH); pl22.add(pl14);
        pl14.add(lb17); pl14.add(lb18);
        
        pl7.add(lb19, BorderLayout.WEST);
        pl7.add(pl23);
        pl23.add(Box.createRigidArea(new Dimension(80, 80)), BorderLayout.NORTH); pl23.add(Box.createRigidArea(new Dimension(80, 80)), BorderLayout.SOUTH); pl23.add(pl15);
        pl15.add(lb20); pl15.add(lb21);
        
        pl8.add(lb22, BorderLayout.WEST);
        pl8.add(pl24);
        pl24.add(Box.createRigidArea(new Dimension(80, 80)), BorderLayout.NORTH); pl24.add(Box.createRigidArea(new Dimension(80, 80)), BorderLayout.SOUTH); pl24.add(pl16);
        pl16.add(lb23); pl16.add(lb24);

        this.setLayout(new GridLayout(2,4));
        this.setPreferredSize(new Dimension(1050, 500));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        this.add(pl1); pl1.setBackground(c3);
        this.add(pl2); pl2.setBackground(c3);
        this.add(pl3); pl3.setBackground(c3);
        this.add(pl7); pl7.setBackground(c3);
        this.add(pl4); pl4.setBackground(c3);
        this.add(pl5); pl5.setBackground(c3);
        this.add(pl6); pl6.setBackground(c3);
        this.add(pl8); pl8.setBackground(c3);
        this.setFrameIcon(null);
        this.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        this.setVisible(true);
    }
}
