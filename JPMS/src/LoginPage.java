
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class LoginPage implements ActionListener {

    private final Font JPMSFont = new Font("Bauhaus 93", Font.PLAIN, 60);
    private final Font regFont = new Font("Century Gothic", Font.BOLD, 16);
    private final Color c4 = new Color(250, 237, 205);
    private final Color c5 = new Color(212, 163, 115);
    private JFrame mainFr;
    private JPanel rightPn, mainPn, btnPn;
    private JTextField userTf;
    private JPasswordField passTf;
    private JButton loginBtn, cancelBtn;
    private JLabel JPMSLb, userLb, passLb;
    private ImageIcon logo;

    public LoginPage() {

        mainFr = new JFrame("JPMS Login Page");
        mainFr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFr.setLayout(new BorderLayout());

        // create stuff
        rightPn = new JPanel(new BorderLayout());
        mainPn = new JPanel(new GridLayout(4, 1));
        btnPn = new JPanel(new BorderLayout());
        userTf = new JTextField();
        passTf = new JPasswordField();
        loginBtn = new JButton("Log in");
        cancelBtn = new JButton("Cancel");
        logo = new ImageIcon("Images/JPMSIcon.png");
        JPMSLb = new JLabel("JPMS");
        userLb = new JLabel("Username :");
        passLb = new JLabel("Password :");

        // left side, logo and name
        JPMSLb.setBackground(c5);
        JPMSLb.setOpaque(true);
        JPMSLb.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        JPMSLb.setIcon(logo);
        JPMSLb.setFont(JPMSFont);
        JPMSLb.setForeground(Color.white);
        JPMSLb.setVerticalAlignment(JLabel.CENTER);
        JPMSLb.setHorizontalAlignment(SwingConstants.CENTER);
        JPMSLb.setHorizontalTextPosition(JLabel.CENTER);
        JPMSLb.setVerticalTextPosition(JLabel.BOTTOM);

        // right side, username n paswsword
        rightPn.setBackground(c4);
        mainPn.setBackground(c4);
        btnPn.setBackground(c4);
        rightPn.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPn.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
        mainPn.add(userLb);
        userLb.setFont(regFont);
        userLb.setHorizontalAlignment(SwingConstants.LEFT);
        mainPn.add(userTf);
        userTf.setFont(regFont);
        userTf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        mainPn.add(passLb);
        passLb.setFont(regFont);
        passLb.setHorizontalAlignment(SwingConstants.LEFT);
        mainPn.add(passTf);
        passTf.setFont(regFont);
        passTf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        btnPn.add(loginBtn, BorderLayout.WEST);
        btnPn.add(cancelBtn, BorderLayout.EAST);
        loginBtn.setFont(regFont);
        cancelBtn.setFont(regFont);
        loginBtn.setPreferredSize(new Dimension(120, 35));
        cancelBtn.setPreferredSize(new Dimension(80, 35));
        loginBtn.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.GRAY, Color.BLACK));
        cancelBtn.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.GRAY, Color.BLACK));
        loginBtn.setBackground(c4);
        cancelBtn.setBackground(c4);

        loginBtn.addActionListener(this);
        cancelBtn.addActionListener(this);

        // add stuff to other stuff
        rightPn.add(mainPn, BorderLayout.CENTER);
        rightPn.add(btnPn, BorderLayout.SOUTH);
        mainFr.add(JPMSLb, BorderLayout.WEST);
        mainFr.add(rightPn, BorderLayout.CENTER);

        // show
        mainFr.setLocationRelativeTo(null);
        mainFr.setUndecorated(true);
        mainFr.setSize(500, 300);
        mainFr.setResizable(false);
        mainFr.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String username = userTf.getText();
        String password = new String(passTf.getPassword());
        if (ae.getSource().equals(loginBtn)) {
            if (username.equals("admin") && (password.equals("12345"))) {
                try {
                    UIManager.setLookAndFeel(new FlatIntelliJLaf());
                } catch (Exception ex) {
                    System.err.println("Failed to initialize LaF");
                }
                new MainGUI();
                mainFr.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Wrong username or password!", "", JOptionPane.WARNING_MESSAGE);
            }
        } else if (ae.getSource().equals(cancelBtn)) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        new LoginPage();
    }
}
