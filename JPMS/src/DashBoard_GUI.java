
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;


public class DashBoard_GUI extends JPanel{
    private JPanel pl1, pl2, pl3, pl4, pl5, pl6, pl7, pl8,
            pl9, pl10, pl11, pl12, pl13, pl14, pl15, pl16;
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
        pl9 = new JPanel(new GridLayout(2, 1));
        pl10 = new JPanel(new GridLayout(2, 1));
        pl11 = new JPanel(new GridLayout(2, 1));
        pl12 = new JPanel(new GridLayout(2, 1));
        pl13 = new JPanel(new GridLayout(2, 1));
        pl14 = new JPanel(new GridLayout(2, 1));
        pl15 = new JPanel(new GridLayout(2, 1));
        pl16 = new JPanel(new GridLayout(2, 1));

        ImageIcon icon;
        BufferedImage image;
        try {
            image = ImageIO.read(new File("image/capital.png"));
            icon = new ImageIcon(image); 
            lb1 = new JLabel(icon);
            image = ImageIO.read(new File("image/current_money.png"));
            icon = new ImageIcon(image); 
            lb4 = new JLabel(icon);
        } catch (IOException ex) {
            Logger.getLogger(DashBoard_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        lb2 = new JLabel("Capital");
        lb2.setFont(new Font("Arial", Font.PLAIN, 20));
        lb3 = new JLabel("1,250,000");
        lb3.setFont(new Font("Arial", Font.PLAIN, 20));
        
        lb5 = new JLabel("CurrentMoney");
        lb5.setFont(new Font("Arial", Font.PLAIN, 20));
        lb6 = new JLabel("627,020");
        lb6.setFont(new Font("Arial", Font.PLAIN, 20));
        
        lb7 = new JLabel();
        lb8 = new JLabel();
        lb9 = new JLabel();
        lb10 = new JLabel();
        lb11 = new JLabel();
        lb12 = new JLabel();
        lb13 = new JLabel();
        lb14 = new JLabel();
        lb15 = new JLabel();
        lb16 = new JLabel();
        lb17 = new JLabel();
        lb18 = new JLabel();
        lb19 = new JLabel();
        lb20 = new JLabel();
        lb21 = new JLabel();
        lb22 = new JLabel();
        lb23 = new JLabel();
        lb24 = new JLabel();
        
        pl1.add(lb1, BorderLayout.WEST);
        pl1.add(pl9);
        pl9.add(lb2); pl9.add(lb3);
        
        pl2.add(lb4, BorderLayout.WEST);
        pl2.add(pl10);
        pl10.add(lb5); pl10.add(lb6);

        
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(1050, 500));
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.add(pl1);
        this.add(pl2);

           
    }
}
