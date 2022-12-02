package project.vehicles;
import java.util.Scanner;

/**
 * Drone is a type of Vehicle that can be used by workers inside and outside the Warehouse
 * to transport goods,
 * newly created Drones are added to the list vehicleList in the Class Vehicle.
 * @author Bögl Florian
 */
public class Drone extends Vehicle{

    // numberDrones is the total number of Drone objects
    private static int numberDrones;
    public static void setNumberDrones(int numberDrones) {
        Drone.numberDrones = numberDrones;
    }
    public static int getNumberDrones() {
        return numberDrones;
    }
    public static void decrementNumberDrones() {
        Drone.numberDrones--;
    }

    /**
     * Constructor for a Drone object
     * @param vehicleID Attribute for constructor, an ID to identify the Drone
     * @param brand Attribute for constructor, the brand of the Drone
     * @param color Attribute for constructor, the color of the Drone
     * @param available Attribute for constructor, describes if the Drone
     *                  is in use or available for a worker
     */
    public Drone(String vehicleID, String brand, String color, boolean available) {
        super();
        super.vehicleID = vehicleID;
        super.brand = brand;
        super.color = color;
        super.available = available;
        Drone.numberDrones++;
        Vehicle.numberVehicles++;
    }


    /**
     * Asks the user for inputs for a new Drone and gives the inputs to
     * function createNewDrone(String vehicleID, String brand, String color),
     * that actually creates the new PassengerCar
     * @return a new Drone object
     */
    public static Drone createNewDrone() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Which vehicle ID does the drone have? ");
        String vehicleID = scanner.nextLine();

        System.out.print("Which brand does the drone have? ");
        String brand = scanner.nextLine();

        System.out.print("Which color does the drone have? ");
        String color = scanner.nextLine();

        return createNewDrone(vehicleID, brand, color);
    }


    /**
     * Creates a new Drone with the input of the three parameters
     * @param vehicleID String for Drone constructor to construct a new Drone object
     * @param brand String for Drone constructor to construct a new Drone object
     * @param color String for Drone constructor to construct a new Drone object
     * @return a new Drone object, default the new Drone is available
     */
    public static Drone createNewDrone(String vehicleID, String brand, String color) {
        return new Drone(vehicleID, brand, color, true);
    }
}