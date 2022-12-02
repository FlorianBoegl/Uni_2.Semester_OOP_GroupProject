package project.employees;

import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Scanner;

public class EmployeeTest {
    @BeforeEach
    public void testEmpty(){
        Employee.emptyEmployees();
    }

    @Test
    public void testToString(){
        Employee e = new Worker("A");
        String expected = e.getName() + " (" + e.getType() + ") ID: " + Integer.toHexString(e.getId()).toUpperCase() + ", Address: " + e.getAddress() + ", Salary: " + e.getSalary();
        Assertions.assertEquals(expected,e.toString());
    }

    @Test
    public void testScanner(){
        Assertions.assertEquals(Employee.scanner,Employee.getScanner());
    }

    @Test
    public void testEmployeeConstructor(){
        Employee e = new Worker("A");
        Assertions.assertEquals("A",e.getName());
        Assertions.assertEquals(0,e.getSalary());
        Assertions.assertNull(e.getAddress());
        Assertions.assertEquals(1,Employee.getNumEmployees());

    }
    @Test
    public void testsetEmployee(){
        Employee e = new Worker("Hans");
        Assertions.assertEquals("Hans",e.getName());
        e.setAddress("187 Rosenheim");
        Assertions.assertEquals("187 Rosenheim",e.getAddress());
        e.setSalary(4567.2f);
        Assertions.assertEquals(4567.2f,e.getSalary());
    }

    @Test
    public void testSetName(){
        Employee e = new Worker("W");
        Assertions.assertEquals("W",e.getName());
        e.setName("L");
        Assertions.assertEquals("L",e.getName());
        e.setName("F");
        Assertions.assertEquals("F",e.getName());
    }

    @Test
    public void testRemoveEmployee(){
        Employee e = new Worker("W");
        Assertions.assertEquals(1,Employee.getNumEmployees());
        e.removeEmployee();
        Assertions.assertEquals(0,Employee.getNumEmployees());
    }

    @Test
    public void testEditEmployee(){
        new Worker("Hans");
        Employee e = new Security("Peter");
        new Manager("Olaf");
        Assertions.assertEquals(3,Employee.getNumEmployees());
        e.setAddress("1234");
        e.setSalary(74);
        Assertions.assertEquals("1234",e.getAddress());
        Assertions.assertEquals(74,e.getSalary());
        Employee.editEmployee("Peter", "12345", 792);
        Assertions.assertEquals("12345",e.getAddress());
        Assertions.assertEquals(792,e.getSalary());
    }

    @Test
    public void testPrint(){
        Assertions.assertThrows(IllegalStateException.class, () -> { Employee.printEmployees(); });
    }

    @Test
    public void testSortEmployee(){
        new Manager("Hans");
        new Security("Peter");
        new Worker("Olaf");
        new Janitor("Heinz");
        new Worker("Lukas");
        new Manager("Flo");
        new Security("Michi");
        new Manager("Ulf");
        new Janitor("Harald");
        new Worker("Lucas");
        List<Employee> el = Employee.getEmployeeList();
        Assertions.assertTrue(el.get(0).getId() < el.get(el.size() - 1).getId());
        Assertions.assertEquals(10,Employee.getNumEmployees());
    }
}
