/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hierarchia;

import java.awt.HeadlessException;
import javax.swing.JFrame;

public class Hierarchia extends JFrame {

  public Hierarchia() throws HeadlessException {
    this.setTitle("Employee hierarchy");
    
  }
  
  public static void main(String[] args) {
    new Hierarchia().setVisible(true);
  }
}
