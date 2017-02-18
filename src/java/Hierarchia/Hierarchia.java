// Pomeisl Ferenc
package Hierarchia;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

public class Hierarchia extends JFrame {

  private JTree tree=new JTree();
  
  public Hierarchia() throws HeadlessException {
    this.setTitle("Employee hierarchy");
    this.setSize(400, 300);
    this.setLocationRelativeTo(this);
    
    this.add(new JScrollPane(tree));
  }
  
  public static void main(String[] args) {
    new Hierarchia().setVisible(true);
  }
}