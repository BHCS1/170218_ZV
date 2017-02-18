package java.drawchart;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;



public class PieChart {
    String [] dep = {"Acc","Admin","Ship","Chief"};
    int [] countEmp = {5,6,7,8};
    int [] sumSal = {1000,2000,3000,4000};

            
  
    public void drawChart () {
    DefaultPieDataset piedata = new DefaultPieDataset();
    for (int i = 0; i < dep.length; i++) 
    piedata.setValue(dep[i], new Integer(countEmp[i]));

    JFreeChart chart = ChartFactory.createPieChart("Employees statistics", piedata, true, true, true);
    PiePlot p= (PiePlot)chart.getPlot();
    ChartFrame frame=new ChartFrame("Statistic", chart);
    frame.setVisible(true);
    frame.setSize(600,500);
    
  }
  
  public static void main(String[] args) {
    
    new PieChart().drawChart();
   
  }
}
