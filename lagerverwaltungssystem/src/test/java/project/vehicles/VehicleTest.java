package project.vehicles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class VehicleTest {
    private static final List<Vehicle> testVehicleList = new ArrayList<>();
    private static final Truck testTruck = new Truck("T","T1","T2",true);
    private static final Drone testDrone = new Drone("D","D1","D2",false);
    private static final Forklift testForklift = new Forklift("F","F1","F2",true);
    private static final PassengerCar testPassengerCar = new PassengerCar("P","P1","P2",false);

    @BeforeAll
    static void setUp(){
        testVehicleList.add(testTruck);
        testVehicleList.add(testDrone);
        testVehicleList.add(testForklift);
        testVehicleList.add(testPassengerCar);
    }

    @Test
    void testGetVehicleID() {
        Assertions.assertEquals("T", testTruck.getVehicleID());
        Assertions.assertEquals("D", testDrone.getVehicleID());
        Assertions.assertEquals("F", testForklift.getVehicleID());
        Assertions.assertEquals("P", testPassengerCar.getVehicleID());
    }

    @Test
    void testGetVehicleBrand() {
        Assertions.assertEquals("T1",testTruck.getBrand());
        Assertions.assertEquals("D1", testDrone.getBrand());
        Assertions.assertEquals("F1", testForklift.getBrand());
        Assertions.assertEquals("P1", testPassengerCar.getBrand());
    }

    @Test
    void testGetVehicleColor() {
        Assertions.assertEquals("T2",testTruck.getColor());
        Assertions.assertEquals("D2", testDrone.getColor());
        Assertions.assertEquals("F2", testForklift.getColor());
        Assertions.assertEquals("P2", testPassengerCar.getColor());
    }

    @Test
    void testGetVehicleIsAvailable() {
        Assertions.assertTrue(testTruck.isAvailable());
        Assertions.assertFalse(testDrone.isAvailable());
        Assertions.assertTrue(testForklift.isAvailable());
        Assertions.assertFalse(testPassengerCar.isAvailable());
    }

    @Test
    void testGetNumberVehicles()  {
        Assertions.assertEquals(4,Vehicle.getNumberVehicles());
    }

    @Test
    void testGetNumberTrucks() {
        Assertions.assertEquals(1,Truck.getNumberTrucks());
    }

    @Test
    void testGetNumberDrones() {
        Assertions.assertEquals(1,Drone.getNumberDrones());
    }

    @Test
    void testGetNumberForklift() {
        Assertions.assertEquals(1,Forklift.getNumberForklifts());
    }

    @Test
    void testGetNumberPassengerCar() {
        Assertions.assertEquals(1,PassengerCar.getNumberPassengerCars());
    }

    @Test
    void testDeleteVehicle() {
        Vehicle.deleteVehicle(testVehicleList, 0);
        Assertions.assertEquals(3, Vehicle.getNumberVehicles());
        Assertions.assertEquals(0,Truck.getNumberTrucks());
        Assertions.assertEquals(testDrone, testVehicleList.get(0));

        Exception exception =  Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, ()->
                Vehicle.deleteVehicle(testVehicleList, -1));
        Assertions.assertEquals("Wrong index!", exception.getMessage());
    }
}