// Pomeisl Ferenc
package Hierarchia;

import java.awt.HeadlessException;
import java.awt.event.HierarchyBoundsAdapter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import model.HierarchyModel;

public class Hierarchia extends JFrame {

  private JTree tree=new JTree();
  
  public Hierarchia() throws HeadlessException {
    this.setTitle("Employee hierarchy");
    this.setSize(400, 300);
    this.setLocationRelativeTo(this);
    
    DefaultTreeModel treeModel=null;
    try {
      treeModel=new DefaultTreeModel(HierarchyModel.getModel());
    } catch (SQLException|ClassNotFoundException ex) {
      System.out.println("Hiba");
    }
    tree.setModel(treeModel);
    this.add(new JScrollPane(tree));
  }
  
  public static void main(String[] args) {
    new Hierarchia().setVisible(true);
  }
}
