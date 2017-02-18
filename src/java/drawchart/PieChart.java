package drawchart;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Department;
import model.Employee;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;



public class PieChart {
//    String [] dep = {"Acc","Admin","Ship","Chief"};
//    int [] countEmp = {5,6,7,8};
//    int [] sumSal = {1000,2000,3000,4000};
  
  
  

            
  
    public void drawChart () { 
    DefaultPieDataset piedata = new DefaultPieDataset();
      try {
        int depSum = Department.getAll().size();
        for (int i = 0; i < depSum; i++)
          piedata.setValue(Department.getAll().get(i).getName(), new Integer(1000));
      } catch (ClassNotFoundException ex) {
        Logger.getLogger(PieChart.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException ex) {
        Logger.getLogger(PieChart.class.getName()).log(Level.SEVERE, null, ex);
      }

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
