// Pomeisl Ferenc
package hierarchy;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(this, "Querying data failed!", "Error", JOptionPane.INFORMATION_MESSAGE);
    } catch (ClassNotFoundException ex) {
      System.out.println(ex.getMessage());
    }

    tree.setModel(treeModel);
    this.add(new JScrollPane(tree));
  }
  
  public static void main(String[] args) {
    new Hierarchia().setVisible(true);
  }
}
