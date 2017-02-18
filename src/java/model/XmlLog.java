// Nagy Gábor

package model;

import java.util.ArrayList;
import org.w3c.dom.Document;

public class XmlLog {
  
  private static Document d=null;
		
  private static void loadXml() {
    // csak akkor be beolvasni ha még nincs
    if (d==null) {
      // TODO olvassuk be az xml fájlt
    }
  }
  
  public static void log(String[] data) {
    loadXml();
    
    
  }
  
  public static ArrayList<String[]> getXmlContent() {
    
  }
  
  
}
