package drawchart;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Department;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class PieChart {

    public void drawChart () { 
      DefaultPieDataset piedata = new DefaultPieDataset();
      ArrayList<Department> depList = Department.getAll();
      for (int i = 0; i < depList.size(); i++) {
        try {
          if (depList.get(i).getEmpCount()>0)
            piedata.setValue(depList.get(i).getName()+" $"+ depList.get(i).getSumSalary(), new Integer(depList.get(i).getEmpCount()));
        } catch (SQLException ex) {
          Logger.getLogger(PieChart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
          Logger.getLogger(PieChart.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      }
    
      JFreeChart chart = ChartFactory.createPieChart("Employees statistics", piedata, true, true, true);
      PiePlot p= (PiePlot)chart.getPlot();
      ChartFrame frame=new ChartFrame("Statistic", chart);
      frame.setVisible(true);
      frame.setSize(1200,600);
    
  }
  
  public static void main(String[] args) {

    new PieChart().drawChart();
   
  }
}
