package project;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.articles.Article;
import project.employees.Employee;
import project.vehicles.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Test for simulation
 * @author Ruf, Lukas
 */
class StartUpTest {

    // Preserving the standard stream
    static final PrintStream systemOutputStream = System.out;

    // custom i/o streams
    static ByteArrayOutputStream testOutputStream;

    // BeforeEach because I want to reset the output stream every time
    @BeforeEach
    void setUp() {
        testOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutputStream));
    }

    @AfterAll
    static void tearDown() {
        System.setOut(systemOutputStream);
        Article.getarticleList().clear();
        Employee.getEmployeeList().clear();

        // this should finally fix the pipeline problems of VehicleTest
        Vehicle.getVehicleList().clear();
        Vehicle.setNumberVehicles(0);
        Truck.setNumberTrucks(0);
        Drone.setNumberDrones(0);
        Forklift.setNumberForklifts(0);
        PassengerCar.setNumberPassengerCars(0);
    }

    String getOut() {
        return testOutputStream.toString();
    }

    @Test
    void testStartUp() {
        StartUp startUp = new StartUp();
        startUp.simulate();

        Assertions.assertTrue(getOut().contains("End of Demo. For more functionality, please consider using our enterprise-grade TUI in Warehouse."));
    }
}
