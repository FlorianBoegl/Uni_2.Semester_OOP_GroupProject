package project.vehicles;
import java.util.Scanner;

/**
 * Truck is a type of Vehicle that can be used by workers of the Warehouse to transport goods to customers,
 * newly created Trucks are added to the list vehicleList in the Class Vehicle.
 * @author Bögl Florian
 */
public class Truck extends Vehicle {

    // numberTrucks is the total number of all Truck objects
    private static int numberTrucks;
    public static void setNumberTrucks(int numberTrucks) {
        Truck.numberTrucks = numberTrucks;
    }
    public static int getNumberTrucks() {
        return numberTrucks;
    }
    public static void decrementNumberTrucks() {
        Truck.numberTrucks--;
    }


    /**
     * Constructor for a Truck object
     * @param vehicleID Attribute for constructor, an ID to identify the Truck
     * @param brand Attribute for constructor, the brand of the Truck
     * @param color Attribute for constructor, the color of the Truck
     * @param available Attribute for constructor, describes if the Truck
     *                  is in use or available for a worker
     */
    public Truck(String vehicleID, String brand, String color, boolean available) {
        super();
        super.vehicleID = vehicleID;
        super.brand = brand;
        super.color = color;
        super.available = available;
        Truck.numberTrucks++;
        Vehicle.numberVehicles++;
    }

    /**
     * Asks the user for inputs for a new Truck object and gives the inputs to
     * function createNewTruck(String vehicleID, String brand, String color),
     * that actually creates the new PassengerCar
     * @return a new Truck object
     */
    public static Truck createNewTruck() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Which vehicle ID does the truck have? ");
        String vehicleID = scanner.nextLine();

        System.out.print("Which brand does the truck have? ");
        String brand = scanner.nextLine();

        System.out.print("Which color does the truck have? ");
        String color = scanner.nextLine();

        return createNewTruck(vehicleID, brand, color);
    }

    /**
     * Creates a new Forklift with the input of the three parameters
     * @param vehicleID String for constructor to construct a new Truck object
     * @param brand String for constructor to construct a new Truck object
     * @param color String for constructor to construct a new Truck object
     * @return a new Truck object, default the new Truck is available
     */
    public static Truck createNewTruck(String vehicleID, String brand, String color) {
        return new Truck(vehicleID, brand, color, true);
    }
}