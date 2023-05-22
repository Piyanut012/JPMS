
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class PieChart_GUI extends JInternalFrame
{

    public PieChart_GUI() {
        DefaultPieDataset dataset1 = new DefaultPieDataset();
        dataset1.setValue("Current Money : "+MainGUI.getInfo().getCurrent_money() , MainGUI.getInfo().getCurrent_money());
        dataset1.setValue("Loan : "+MainGUI.getInfo().getLoan(), MainGUI.getInfo().getLoan());
        dataset1.setValue("Profit : "+MainGUI.getInfo().getProfit(), MainGUI.getInfo().getProfit());
        
        JFreeChart chart1 = ChartFactory.createPieChart("Finance", dataset1, true, true, false);
        PiePlot plot1 = (PiePlot) chart1.getPlot();
        plot1.setLabelFont(new Font("Century Gothic", Font.PLAIN, 10));
        plot1.setNoDataMessage("NO DATA");
        plot1.setCircular(false);
        plot1.setLabelGap(0.02);
        plot1.setLabelBackgroundPaint(new Color(220, 220, 220));
        
        DefaultPieDataset dataset2 = new DefaultPieDataset();
        dataset2.setValue("Pawn Goods : "+MainGUI.getInfo().getPawn_goods(), MainGUI.getInfo().getPawn_goods());
        dataset2.setValue("Pawn Droppings : "+MainGUI.getInfo().getPawn_droppings(), MainGUI.getInfo().getPawn_droppings());
        dataset2.setValue("Sales : "+MainGUI.getInfo().getSold(), MainGUI.getInfo().getSold());
        
        JFreeChart chart2 = ChartFactory.createPieChart("Goods", dataset2, true, true, false);
        PiePlot plot2 = (PiePlot) chart2.getPlot();
        plot2.setLabelFont(new Font("Century Gothic", Font.PLAIN, 10));
        plot2.setNoDataMessage("NO DATA");
        plot2.setCircular(true);
        plot2.setLabelGap(0.02);
        plot2.setLabelBackgroundPaint(new Color(220, 220, 220));
         
        ChartPanel chartPanel1 = new ChartPanel(chart1);
        chartPanel1.setPreferredSize(new Dimension(400, 300));
        
        ChartPanel chartPanel2 = new ChartPanel(chart2);
        chartPanel2.setPreferredSize(new Dimension(400, 300));
        
        getContentPane().add(chartPanel1);
        getContentPane().add(chartPanel2);
        setLayout(new GridLayout(1, 2));
        setVisible(true);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        this.setFrameIcon(null);
        this.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        this.setVisible(true);
        this.setPreferredSize(new Dimension(1050, 500));
    }
}
