
import java.awt.*;
import javax.swing.*;


public class Customer_GUI extends JPanel{
    private JTextField txt;
    
    public Customer_GUI(){
        txt = new JTextField("Customers");
        txt.setFont(new Font("Arial", Font.PLAIN, 20));
        txt.setPreferredSize(new Dimension(300, 300));
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(1050, 500));
        this.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        this.add(txt);
           
    }
}
