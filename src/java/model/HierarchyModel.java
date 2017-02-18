// Pomeisl Ferenc
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.tree.DefaultMutableTreeNode;

public class HierarchyModel extends Model {
  
  public static DefaultMutableTreeNode getModel() throws SQLException, ClassNotFoundException {
    DefaultMutableTreeNode defNode=new DefaultMutableTreeNode();
    
    connect();
    
    String sql="SELECT DISTINCT LAST_NAME AS DOLGOZO, LEVEL, SYS_CONNECT_BY_PATH(LAST_NAME,'/') AS UTVONAL FROM EMPLOYEES WHERE LEVEL <=4 START WITH LAST_NAME = 'King' CONNECT BY NOCYCLE PRIOR EMPLOYEE_ID = MANAGER_ID AND LEVEL <= 5 ORDER BY LAST_NAME, LEVEL";
    
    
    ResultSet rs=connection.createStatement().executeQuery(sql);
            
    while (rs.next()) {
      System.out.println(rs.getString("dolgozo"));
    }
    
    
    disconnect();
    
    return defNode;
  }
  
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    HierarchyModel.getModel();
  }
          
}
