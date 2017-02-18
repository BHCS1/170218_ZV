//Kovács Zoltán
//Nagy Gábor
//Bakos Balázs
package drawchart;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Department;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class PieChart {

    public void drawChart () throws SQLException, ClassNotFoundException{ 
      DefaultPieDataset piedata = new DefaultPieDataset();
      ArrayList<Department> depList = Department.getAll();
      for (int i = 0; i < depList.size(); i++) {
          if (depList.get(i).getEmpCount()>0)
            piedata.setValue("Department name: "+depList.get(i).getName()+"\n Summary of salary: $"+ depList.get(i).getSumSalary()+"\n Count of employees: "+depList.get(i).getEmpCount(), new Integer(depList.get(i).getEmpCount()));
      }
      JFreeChart chart = ChartFactory.createPieChart("Count of employees in departments", piedata, false, true, true);
      PiePlot p= (PiePlot)chart.getPlot();
      ChartFrame frame=new ChartFrame("Statistic", chart);
      frame.setVisible(true);
      frame.setSize(1200,700);
  }
    
  public static void main(String[] args) {
      try {
        new PieChart().drawChart();
      } catch (SQLException ex) {
        Logger.getLogger(PieChart.class.getName()).log(Level.SEVERE, null, ex);
      } catch (ClassNotFoundException ex) {
        Logger.getLogger(PieChart.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
}
