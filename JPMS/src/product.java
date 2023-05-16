
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.List;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class product implements ActionListener{
    private JFrame fr;
    private JPanel top,mid,panel,low;
    private JLabel sum,lb1,lb2;
    private JButton ok, cancel, add;
    private int number;
    private ArrayList<JPanel> array;
    
    public product(){
        array = new ArrayList<JPanel>();
        number = 0;
        fr = new JFrame();
        top = new JPanel();
        mid = new JPanel();
        panel = new JPanel();
        low = new JPanel();
        sum = new JLabel(String.valueOf(number));
        lb1 = new JLabel("pawn goods");
        lb2 = new JLabel("Total : ");
        ok = new JButton("OK");
        cancel = new JButton("Cancel");
        add = new JButton("+");
        
        ok.addActionListener(this);
        cancel.addActionListener(this);
        add.addActionListener(this);
        
        JScrollPane scrollPane = new JScrollPane(mid);
        
        top.setLayout(new BorderLayout());
        fr.setLayout(new BorderLayout());
        mid.setLayout(new BoxLayout(mid, BoxLayout.Y_AXIS));
        addpanel();
        
        top.add(lb1, BorderLayout.EAST);
        top.add(add, BorderLayout.WEST);
        
        low.add(lb2);
        low.add(sum);
        low.add(ok);
        low.add(cancel);
        
        fr.add(top, BorderLayout.NORTH);
        fr.add(scrollPane, BorderLayout.CENTER);
        fr.add(low, BorderLayout.SOUTH);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(300, 250);
//        fr.setResizable(false);
        fr.setVisible(true);
        
        
        
        
    }
    public void addpanel(){
        JPanel pa = new JPanel();
        pa.setPreferredSize(new Dimension(250,150));
        JPanel pa2 = new JPanel();
        JPanel pa3 = new JPanel();
        pa.setLayout(new BorderLayout());
        pa2.setLayout(new GridLayout(4,2));
        JLabel label = new JLabel("Click to add image");
        label.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
               if (e.getSource().equals(label)){
                   JFileChooser fileChooser = new JFileChooser();
                   fileChooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "jpeg", "png"));
                   int result = fileChooser.showOpenDialog(fr);
                   if (result == JFileChooser.APPROVE_OPTION) {
                       File selectedFile = fileChooser.getSelectedFile();
                       try {

                           BufferedImage originalImage = ImageIO.read(selectedFile);

                           int width = 125;
                           int height = 125;
                           BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                           Graphics2D g = resizedImage.createGraphics();
                           g.drawImage(originalImage, 0, 0, width, height, null);
                           g.dispose();

                           //ตัวเเปร รูปภาพ
                           ImageIcon resizedIcon = new ImageIcon(resizedImage);
//                                label.setIcon(resizedIcon);
                       }
                       catch (IOException ex) {
                           ex.printStackTrace();
                       }
                   }
               }
           }
            
            });
        pa3.add(label);
        JLabel lab1 = new JLabel("Name :");
        JLabel lab2 = new JLabel("Cost :");
        JLabel cater = new JLabel("category");
        JTextField name = new JTextField();
        JTextField cost = new JTextField();
        ButtonGroup grop = new ButtonGroup();
        JRadioButton accessories = new JRadioButton("accessories");
        JRadioButton appliance = new JRadioButton("appliance");
        grop.add(accessories);
        grop.add(appliance);

        pa2.add(lab1);
        pa2.add(name);
        pa2.add(lab2);
        pa2.add(cost);
        pa2.add(cater);
        pa2.add(accessories);
        JLabel space = new JLabel("");
        pa2.add(space);
        pa2.add(appliance);
        pa.add(pa3, BorderLayout.SOUTH);
        pa.add(pa2, BorderLayout.CENTER);
        pa.setSize(300, 200);
        
        mid.add(pa);
        array.add(pa);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(add)){
            addpanel();
        }
    }
    public static void main(String[] args) {
        new product();
    }
}
