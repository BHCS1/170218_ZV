// Pomeisl Ferenc
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class HierarchyModel extends Model {
  
  private static DefaultMutableTreeNode defNode=null;
  private static HashSet<String> hs=new HashSet<>();
  
  public static DefaultMutableTreeNode getModel() throws SQLException, ClassNotFoundException {
    defNode=new DefaultMutableTreeNode("Hierarchy");
    
    connect();
    String sql="SELECT DISTINCT LAST_NAME AS DOLGOZO, LEVEL, SYS_CONNECT_BY_PATH(LAST_NAME,'/') AS UTVONAL FROM EMPLOYEES WHERE LEVEL <=4 START WITH LAST_NAME = 'King' CONNECT BY NOCYCLE PRIOR EMPLOYEE_ID = MANAGER_ID AND LEVEL <= 5 ORDER BY LAST_NAME, LEVEL";
    
    
    ResultSet rs=connection.createStatement().executeQuery(sql);
            
    while (rs.next()) {
      //recursive(rs.getString("UTVONAL"));
      hs.add(rs.getString("UTVONAL"));
    }
    
    for (String path : hs) {
      create(defNode, path);
    }
    
    disconnect();
    return defNode;
  }
  
  private static void create(DefaultMutableTreeNode node, String path) {
    
    DefaultMutableTreeNode n = null;
    String pString = "";
    
    int p = path.indexOf('/');
    
    if(p == -1) {
      pString=path;
      path="";
    }
    else {
      pString=path.substring(0,p);
      path=path.substring(p+1, path.length()-(p+1));
    }
    
    node=null;
    
    int size=defNode.getChildCount();
    
    for (int i=0; i < size; i++) {
      String item=(String)defNode.getUserObject();
      System.out.println(item);
      
      if(item.equals(pString)) {
        node=new DefaultMutableTreeNode(item);
        defNode.add(node);
      }
      
    if(node==null) {
      node=new DefaultMutableTreeNode(pString);
      defNode.add(node);
    }
    
    if(path.equals("")) {
      create((DefaultMutableTreeNode) node.getChildAfter(node), path);
    }
    
    }
  }
  
//  private static void recursive(String path) {
//    String[] elements=path.split("/");
//    ArrayList<String> newPath=new ArrayList<>();
//    System.out.println(path);
//    if(elements.length> 1) {
//      
//      System.out.print(elements[1]+"-");
//      
////      if(!hs.contains(elements[1])) {
////        hs.add(elements[1]);
////      }
//      
//      //defNode.add(new DefaultMutableTreeNode(elements[1]));
//
//      for (int i = 2; i < elements.length; i++) {
//        newPath.add(elements[i]);
//        //System.out.print(elements[i]);
//      }
//      //System.out.println(String.join("\\", newPath));
//      recursive(String.join("\"", newPath));
//      
//    }
//    
//    if(elements.length==1) {
//      System.out.println("");
//    }
//    
//  }
  
//    private void recursive(DefaultMutableTreeNode node, TreePath útvonal, int szint) {
//    Enumeration e=((DefaultMutableTreeNode)útvonal.getLastPathComponent()).children();
//    
//    while(e.hasMoreElements()) {
//      DefaultMutableTreeNode aktElem=(DefaultMutableTreeNode)e.nextElement();
//      for (int i = 1; i <= szint; i++) {
//        System.out.print(" ");
//      }
//      System.out.println(aktElem.getUserObject());
//      faCsomópontKinyit(fa, útvonal.pathByAddingChild(aktElem), szint+2);
//    }
//    
//    fa.expandPath(útvonal);
//  }
  
  public static void main(String[] args) throws SQLException, ClassNotFoundException {
    HierarchyModel.getModel();
  }
          
}
