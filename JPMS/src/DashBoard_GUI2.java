
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;


public class DashBoard_GUI2 extends JInternalFrame{
    private JPanel pl1, pl2, pl3, pl4, pl5, pl6, pl7, pl8,
            pl9, pl10, pl11, pl12, pl13, pl14, pl15, pl16, 
            pl17, pl18, pl19, pl20, pl21, pl22, pl23, pl24;
    private JLabel lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8,
            lb9, lb10, lb11, lb12, lb13, lb14, lb15, lb16,
            lb17, lb18, lb19, lb20, lb21, lb22, lb23, lb24;
    
    public DashBoard_GUI2(){
        pl1 = new JPanel(new BorderLayout());
        pl2 = new JPanel(new BorderLayout());
        pl3 = new JPanel(new BorderLayout());
        pl4 = new JPanel(new BorderLayout());
        pl5 = new JPanel(new BorderLayout());
        pl6 = new JPanel(new BorderLayout());
        pl7 = new JPanel(new BorderLayout());
        pl8 = new JPanel(new BorderLayout());
        
        pl9 = new JPanel(new GridLayout(2, 1));
        pl10 = new JPanel(new GridLayout(2, 1));
        pl11 = new JPanel(new GridLayout(2, 1));
        pl12 = new JPanel(new GridLayout(2, 1));
        pl13 = new JPanel(new GridLayout(2, 1));
        pl14 = new JPanel(new GridLayout(2, 1));
        pl15 = new JPanel(new GridLayout(2, 1));
        pl16 = new JPanel(new GridLayout(2, 1));
        
        pl17 = new JPanel(new BorderLayout());
        pl18 = new JPanel(new BorderLayout());
        pl19 = new JPanel(new BorderLayout());
        pl20 = new JPanel(new BorderLayout());
        pl21 = new JPanel(new BorderLayout());
        pl22 = new JPanel(new BorderLayout());
        pl23 = new JPanel(new BorderLayout());
        pl24 = new JPanel(new BorderLayout());

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
            Logger.getLogger(DashBoard_GUI2.class.getName()).log(Level.SEVERE, null, ex);
        }
        lb2 = new JLabel("Funds");
        lb2.setFont(new Font("Arial", Font.PLAIN, 20));
        lb3 = new JLabel("1,250,000");
        lb3.setFont(new Font("Arial", Font.BOLD, 25));
        lb3.setForeground(Color.CYAN);
        
        lb5 = new JLabel("Profit");
        lb5.setFont(new Font("Arial", Font.PLAIN, 20));
        lb6 = new JLabel("627,020");
        lb6.setFont(new Font("Arial", Font.BOLD, 25));
        lb6.setForeground(Color.ORANGE);
        
        lb8 = new JLabel("Loaned");
        lb8.setFont(new Font("Arial", Font.PLAIN, 20));
        lb9 = new JLabel("500,000");
        lb9.setFont(new Font("Arial", Font.BOLD, 25));
        lb9.setForeground(Color.RED);
        
        lb11 = new JLabel("Users");
        lb11.setFont(new Font("Arial", Font.PLAIN, 20));
        lb12 = new JLabel("100");
        lb12.setFont(new Font("Arial", Font.BOLD, 25));
        lb12.setForeground(Color.BLUE);
        
        lb14 = new JLabel("Pledged");
        lb14.setFont(new Font("Arial", Font.PLAIN, 20));
        lb15 = new JLabel("150");
        lb15.setFont(new Font("Arial", Font.BOLD, 25));
        lb15.setForeground(Color.MAGENTA);
        
        lb17 = new JLabel("Pawned");
        lb17.setFont(new Font("Arial", Font.PLAIN, 20));
        lb18 = new JLabel("11");
        lb18.setFont(new Font("Arial", Font.BOLD, 25));
        lb18.setForeground(Color.GREEN);
        
        lb20 = new JLabel("Difference");
        lb20.setFont(new Font("Arial", Font.PLAIN, 20));
        lb21 = new JLabel("100,000");
        lb21.setFont(new Font("Arial", Font.BOLD, 25));
        lb21.setForeground(Color.GREEN);
        
        lb23 = new JLabel("Sold");
        lb23.setFont(new Font("Arial", Font.PLAIN, 20));
        lb24 = new JLabel("50");
        lb24.setFont(new Font("Arial", Font.BOLD, 25));
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
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.add(pl1);
        this.add(pl2);
        this.add(pl3);
        this.add(pl7);
        this.add(pl4);
        this.add(pl5);
        this.add(pl6);
        this.add(pl8);
        this.setFrameIcon(null);
        this.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        this.setVisible(true);
    }
}
