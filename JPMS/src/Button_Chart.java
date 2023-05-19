import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class Button_Chart extends JButton implements ActionListener{
    private JFrame parent;
    private PieChart_GUI piechart;
    private MainGUI mgui;
    
    
    public Button_Chart(JFrame fr,MainGUI mgui){
        this.setText("Chart");
        this.setPreferredSize(new Dimension(150, 75));
        this.parent = fr;
        this.mgui = mgui;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            parent.remove(mgui.getCurrentPanel());
            piechart = new PieChart_GUI();
            mgui.setCurrentPanel(piechart);
            parent.add(mgui.getCurrentPanel());
            
    }
}
