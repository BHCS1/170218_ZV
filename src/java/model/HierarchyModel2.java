// Pomeisl Ferenc
// Nagy Gábor

package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import javax.swing.JTree;
import javax.swing.text.Position;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import static model.Model.connect;
import static model.Model.connection;

public class HierarchyModel2 extends Model {
  
  private static DefaultMutableTreeNode defNode= null;
  private static JTree tree = new JTree();
  private static HashSet<String> hs=new HashSet<>();
  
  public static DefaultMutableTreeNode getModel() throws SQLException, ClassNotFoundException {
    defNode=new DefaultMutableTreeNode("Hierarchy");
    
    connect();
    String sql="SELECT "
            + "DISTINCT LAST_NAME AS DOLGOZO, LEVEL, "
            + "SYS_CONNECT_BY_PATH(LAST_NAME,'/') AS UTVONAL "
            + "FROM EMPLOYEES WHERE LEVEL <=4 START WITH LAST_NAME = 'King' "
            + "CONNECT BY NOCYCLE PRIOR EMPLOYEE_ID = MANAGER_ID "
            + "AND LEVEL <= 5 ORDER BY LAST_NAME, LEVEL";
    ResultSet rs=connection.createStatement().executeQuery(sql);
            
    while (rs.next()) {
      String[] parts = rs.getString("UTVONAL").split("/");
      
      DefaultMutableTreeNode actNode = defNode;
      DefaultMutableTreeNode n = null;
      for (int i=1; i < rs.getInt("LEVEL")+1; i++) {
        System.out.println(parts[i]);
        if ((n = levelNodeExists(actNode, parts[i])) != null) {
          actNode = n;
        } else {
          createNode(actNode, parts[i]);
        }
      }
    }
    
    disconnect();
    return defNode;
  }

  private static DefaultMutableTreeNode levelNodeExists(DefaultMutableTreeNode actNode, String part) {
    boolean exists = false;
    
    int i = 0; 
    while(!exists && i < actNode.getChildCount()) {
      if (((DefaultMutableTreeNode)actNode.getChildAt(i)).getUserObject().toString() == part){
        exists = true;
      }
      i++;
    }
    
    if (exists) {
      return (DefaultMutableTreeNode)actNode.getChildAt(i-1);
    } else {
      return null;
    }
  }
  
  private static void createNode(DefaultMutableTreeNode actNode, String part) {
    actNode.add(new DefaultMutableTreeNode(part));
  }
  
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    HierarchyModel2.getModel();
  }
          
}
