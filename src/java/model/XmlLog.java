// Nagy Gábor
// Berényi Lajos

package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlLog {
  
  private static Document d=null;
  private static final String TIMESTAMP = "timestamp";
  private static final String[] ATTRIBUTESNAMES = 
    {TIMESTAMP, "user", "type", "from", "to", "sql", "empId", "empName"};
  private static final File XMLFILE = new File(XmlLog.class.getResource("log.xml").toString());
		
  private static void loadXml() {
    // csak akkor be beolvasni ha még nincs
    //if (d==null) {
      try {
        d = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(XMLFILE);
      }
      catch (ParserConfigurationException | SAXException | IOException ex) {
        System.out.println("Error: " + ex.getMessage());
        try {
          d = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
          Element root = d.createElement("root");
          d.appendChild(root);
        } catch (ParserConfigurationException e) {
          e.printStackTrace();
        }
      }
    //}
  }
  
  public static void log(String[] data) {
    loadXml();
    Element root = d.getDocumentElement();
    Element log = d.createElement("log");
    root.appendChild(log);
    log.setAttribute(TIMESTAMP, getTimeStamp());
    for (int i = 1; i < data.length; i++) {
      if (!data[i].isEmpty()) {
        log.setAttribute(ATTRIBUTESNAMES[i], data[i]);
      }
    }
    DOMSource source = new DOMSource(root);
      StreamResult xml = new StreamResult(XMLFILE);
      Transformer transformer;
    try {
      transformer = TransformerFactory.newInstance().newTransformer();
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
      transformer.transform(source, xml);
    }
    catch (TransformerException ex) {
      ex.printStackTrace();
    }
      
  }
  
  public static ArrayList<String[]> getXmlContent() {
    ArrayList<String[]> list = new ArrayList<>();
    loadXml();
    Element root = d.getDocumentElement();
    NodeList nodeLogs = root.getElementsByTagName("log");
    for (int i = 0; i < nodeLogs.getLength(); i++) {
      Element log = (Element) nodeLogs.item(i);
      String[] logDatas = getEmptyStringArray();
      for (int j = 0; j < logDatas.length; j++) {
        if (log.hasAttribute(ATTRIBUTESNAMES[j]))
          logDatas[j] = log.getAttribute(ATTRIBUTESNAMES[j]);
      }
      list.add(logDatas);
    }
    return list;
  }
  
  
  private static String getTimeStamp() {
    return "" + Calendar.getInstance().getTimeInMillis();
  }
  
  private static String[] getEmptyStringArray() {
    String[] str = new String[ATTRIBUTESNAMES.length];
    for (int i = 0; i < str.length; i++) {
      str[i] = "";
    }
    return str;
  }
  
  public static void logLogin(String username) {
    String[] datas = getEmptyStringArray();
    datas[1] = username;
    datas[2] = "login";
    log(datas);
  }
  
  public static void logLogout(String username) {
    String[] datas = getEmptyStringArray();
    datas[1] = username;
    datas[2] = "logout";
    log(datas);
  }
  
  public static void logSalaryChange(String username, int empId, String empName, int from, int to) {
    String[] datas = getEmptyStringArray();
    datas[1] = username;
    datas[2] = "salaryChange";
    datas[3] = "" + from;
    datas[4] = "" + to;
    datas[6] = "" + empId;
    datas[7] = empName;
    log(datas);
  }
  
  public static void logCreateSalary(String username, int empId, String empName) {
    String[] datas = getEmptyStringArray();
    datas[1] = username;
    datas[2] = "createEmployee";
    datas[6] = "" + empId;
    datas[7] = empName;
    log(datas);
  }
  
  public static void logSQL(String username, String SQL) {
    String[] datas = getEmptyStringArray();
    int employeeCount = Employee.getEmployeeCount();
    datas[1] = username;
    datas[2] = "SQL";
    datas[4] = "" + employeeCount;
    datas[3] = "" + (employeeCount - 1);
    datas[5] = SQL;
    log(datas);
  }
  
}
