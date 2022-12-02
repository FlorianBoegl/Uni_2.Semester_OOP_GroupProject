/*package project.employees;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class EmployeeInputTest {

    static final InputStream systemInputStream = System.in;
    static final PrintStream systemOutputStream = System.out;

    static ByteArrayInputStream testInputStream;
    static ByteArrayOutputStream testOutputStream;

    @BeforeEach
    void setUp() {
        testOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutputStream));
        Employee.emptyEmployees();
        new Worker("Karl");
    }

    @AfterAll
    static void tearDown() {
        System.setIn(systemInputStream);
        System.setOut(systemOutputStream);
    }

    void addInput(String s) {
        testInputStream = new ByteArrayInputStream(s.getBytes());
        System.setIn(testInputStream);
    }

    String getOut() {
        return testOutputStream.toString();
    }

    @Test
    public void testChooseEmployeeOperationExit(){
        addInput(String.join("\n", "4"));
        Employee.chooseEmployeeOperation();

        Assertions.assertTrue(getOut().contains("Exited Employee successfully"));

    }

    @Test
    public void testChooseEmployeeOperationOutOfRange(){
        addInput(String.join("\n", "7","4"));
        Employee.chooseEmployeeOperation();

        Assertions.assertTrue(getOut().contains("Given Integer not in range!"));
        Assertions.assertTrue(getOut().contains("Exited Employee successfully"));

    }

    @Test
    public void testChooseEmployeeOperationInvalid(){
        addInput(String.join("\n", "Hallo","4"));
        Employee.chooseEmployeeOperation();

        Assertions.assertTrue(getOut().contains("Input has to be an integer!"));
        Assertions.assertTrue(getOut().contains("Exited Employee successfully"));
    }

    @Test
    public void testChooseEmployeeOperationCreateWorker(){
        addInput(String.join("\n", "1","Hallo","1","Hans","4"));
        Employee.chooseEmployeeOperation();

        Assertions.assertTrue(getOut().contains("Choose operation:\n(1) Worker \n(2) Security \n(3) Janitor \n(4) Manager"));
        Assertions.assertTrue(getOut().contains("Input has to be an integer"));
        Assertions.assertTrue(getOut().contains("New Worker with Name \"Hans\"added as Employee"));
        Assertions.assertTrue(getOut().contains("Exited Employee successfully"));
    }
}
*/