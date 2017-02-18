// Nagy Gábor

package model;

import java.sql.Date;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest {
  
  public EmployeeTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of getAll method, of class Employee.
   */
  @Test
  public void testGetAll() throws Exception {
    System.out.println("getAll");
    ArrayList<Employee> expResult = null;
    ArrayList<Employee> result = Employee.getAll();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of get method, of class Employee.
   */
  @Test
  public void testGet() throws Exception {
    System.out.println("get");
    int empId = 0;
    Employee expResult = null;
    Employee result = Employee.get(empId);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of update method, of class Employee.
   */
  @Test
  public void testUpdate() throws Exception {
    System.out.println("update");
    Employee instance = new Employee();
    boolean expResult = false;
    boolean result = instance.update();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of save method, of class Employee.
   */
  @Test
  public void testSave() throws Exception {
    System.out.println("save");
    Employee instance = new Employee();
    int expResult = 0;
    int result = instance.save();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setDepartmentId method, of class Employee.
   */
  @Test
  public void testSetDepartmentId() {
    System.out.println("setDepartmentId");
    int departmentId = 0;
    Employee instance = new Employee();
    instance.setDepartmentId(departmentId);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setSalary method, of class Employee.
   */
  @Test
  public void testSetSalary() {
    System.out.println("setSalary");
    int salary = 0;
    Employee instance = new Employee();
    instance.setSalary(salary);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getID method, of class Employee.
   */
  @Test
  public void testGetID() {
    System.out.println("getID");
    Employee instance = new Employee();
    int expResult = 0;
    int result = instance.getID();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getName method, of class Employee.
   */
  @Test
  public void testGetName() {
    System.out.println("getName");
    Employee instance = new Employee();
    String expResult = "";
    String result = instance.getName();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getSalary method, of class Employee.
   */
  @Test
  public void testGetSalary() {
    System.out.println("getSalary");
    Employee instance = new Employee();
    int expResult = 0;
    int result = instance.getSalary();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getDepartmentId method, of class Employee.
   */
  @Test
  public void testGetDepartmentId() {
    System.out.println("getDepartmentId");
    Employee instance = new Employee();
    int expResult = 0;
    int result = instance.getDepartmentId();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getDepartmentName method, of class Employee.
   */
  @Test
  public void testGetDepartmentName() {
    System.out.println("getDepartmentName");
    Employee instance = new Employee();
    String expResult = "";
    String result = instance.getDepartmentName();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getDepartment method, of class Employee.
   */
  @Test
  public void testGetDepartment() {
    System.out.println("getDepartment");
    Employee instance = new Employee();
    Department expResult = null;
    Department result = instance.getDepartment();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getFirstName method, of class Employee.
   */
  @Test
  public void testGetFirstName() {
    System.out.println("getFirstName");
    Employee instance = new Employee();
    String expResult = "";
    String result = instance.getFirstName();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setFirstName method, of class Employee.
   */
  @Test
  public void testSetFirstName() {
    System.out.println("setFirstName");
    String firstName = "";
    Employee instance = new Employee();
    instance.setFirstName(firstName);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getLastName method, of class Employee.
   */
  @Test
  public void testGetLastName() {
    System.out.println("getLastName");
    Employee instance = new Employee();
    String expResult = "";
    String result = instance.getLastName();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setLastName method, of class Employee.
   */
  @Test
  public void testSetLastName() {
    System.out.println("setLastName");
    String lastName = "";
    Employee instance = new Employee();
    instance.setLastName(lastName);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getEmail method, of class Employee.
   */
  @Test
  public void testGetEmail() {
    System.out.println("getEmail");
    Employee instance = new Employee();
    String expResult = "";
    String result = instance.getEmail();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setEmail method, of class Employee.
   */
  @Test
  public void testSetEmail() {
    System.out.println("setEmail");
    String email = "";
    Employee instance = new Employee();
    instance.setEmail(email);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getPhoneNumber method, of class Employee.
   */
  @Test
  public void testGetPhoneNumber() {
    System.out.println("getPhoneNumber");
    Employee instance = new Employee();
    String expResult = "";
    String result = instance.getPhoneNumber();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setPhoneNumber method, of class Employee.
   */
  @Test
  public void testSetPhoneNumber() {
    System.out.println("setPhoneNumber");
    String phoneNumber = "";
    Employee instance = new Employee();
    instance.setPhoneNumber(phoneNumber);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getHireDate method, of class Employee.
   */
  @Test
  public void testGetHireDate() {
    System.out.println("getHireDate");
    Employee instance = new Employee();
    Date expResult = null;
    Date result = instance.getHireDate();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setHireDate method, of class Employee.
   */
  @Test
  public void testSetHireDate() {
    System.out.println("setHireDate");
    Date hireDate = null;
    Employee instance = new Employee();
    instance.setHireDate(hireDate);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getJobId method, of class Employee.
   */
  @Test
  public void testGetJobId() {
    System.out.println("getJobId");
    Employee instance = new Employee();
    String expResult = "";
    String result = instance.getJobId();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setJobId method, of class Employee.
   */
  @Test
  public void testSetJobId() {
    System.out.println("setJobId");
    String jobId = "";
    Employee instance = new Employee();
    instance.setJobId(jobId);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getJob method, of class Employee.
   */
  @Test
  public void testGetJob() {
    System.out.println("getJob");
    Employee instance = new Employee();
    Job expResult = null;
    Job result = instance.getJob();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of getManagerId method, of class Employee.
   */
  @Test
  public void testGetManagerId() {
    System.out.println("getManagerId");
    Employee instance = new Employee();
    int expResult = 0;
    int result = instance.getManagerId();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of setManagerId method, of class Employee.
   */
  @Test
  public void testSetManagerId() {
    System.out.println("setManagerId");
    int managerId = 0;
    Employee instance = new Employee();
    instance.setManagerId(managerId);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of toString method, of class Employee.
   */
  @Test
  public void testToString() {
    System.out.println("toString");
    Employee instance = new Employee();
    String expResult = "";
    String result = instance.toString();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of emailExists method, of class Employee.
   */
  @Test
  public void testEmailExists() throws Exception {
    System.out.println("emailExists");
    String email = "";
    boolean expResult = false;
    boolean result = Employee.emailExists(email);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
  
}
