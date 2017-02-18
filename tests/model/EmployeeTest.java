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
   * Test of get method, of class Employee.
   */
  @Test
  public void testGet() throws Exception {
    System.out.println("get");
    int empId = 100;
    Employee expResult = new Employee(100);
    Employee result = Employee.get(empId);
    assertEquals(expResult, result);
  }

  /**
   * Test of get method, of class Employee.
   */
  @Test
  public void testGet2() throws Exception {
    System.out.println("get2");
    int empId = 10;
    Employee expResult = null;
    Employee result = Employee.get(empId);
    assertEquals(expResult, result);
  }
  
  /**
   * Test of get method, of class Employee.
   */
  @Test
  public void testGet3() throws Exception {
    System.out.println("get3");
    int empId = -10;
    Employee expResult = null;
    Employee result = Employee.get(empId);
    assertEquals(expResult, result);
  } 
  
  @Test
  public void testGetAll() throws Exception {
    System.out.println("getall");
    ArrayList<Employee> result = Employee.getAll();

    assertTrue(result.size() > 0);
    
    for(Employee e: result) {
      assertTrue(e.getSalary() > 0);
    }
  }
}
