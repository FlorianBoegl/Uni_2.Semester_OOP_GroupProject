package project.vehicles;
import java.util.Scanner;

/**
 * Forklift is a type of Vehicle that can be used by workers inside the Warehouse,
 * newly created Forklifts are added to the list vehicleList in the Class Vehicle.
 * @author Bögl Florian
 */
public class Forklift extends Vehicle {

    // numberForklifts is the total number of all Forklift objects
    private static int numberForklifts;
    public static void setNumberForklifts(int numberForklifts) {
        Forklift.numberForklifts = numberForklifts;
    }
    public static int getNumberForklifts() {
        return numberForklifts;
    }
    public static void decrementNumberForklifts() {
        Forklift.numberForklifts--;
    }

    /**
     * Constructor for Forklift object with the input of the three parameters
     * @param vehicleID Attribute for constructor, an ID to identify the Forklift
     * @param brand Attribute for constructor, the brand of the Forklift
     * @param color Attribute for constructor, the color of the Forklift
     * @param available Attribute for constructor, describes if the Forklift
     *                  is in use or available for a worker
     */
    public Forklift(String vehicleID, String brand, String color, boolean available) {
        super();
        super.vehicleID = vehicleID;
        super.brand = brand;
        super.color = color;
        super.available = available;
        Forklift.numberForklifts++;
        Vehicle.numberVehicles++;
    }


    /**
     * Asks the user for inputs for a new Forklift and gives the inputs to
     * function createNewForklift(String vehicleID, String brand, String color),
     * that actually creates the new PassengerCar
     * @return a new Forklift object
     */
    public static Forklift createNewForklift() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Which vehicle ID does the forklift have? ");
        String vehicleID = scanner.nextLine();

        System.out.print("Which brand does the forklift have? ");
        String brand = scanner.nextLine();

        System.out.print("Which color does the forklift have? ");
        String color = scanner.nextLine();

        return createNewForklift(vehicleID, brand, color);
    }


    /**
     * Creates a new Forklift with the input of the three parameters
     * @param vehicleID String for Forklift constructor to construct a new Forklift object
     * @param brand String for Forklift constructor to construct a new Forklift object
     * @param color String for Forklift constructor to construct a new Forklift object
     * @return a new Forklift object, default the new Forklift is available
     */
    public static Forklift createNewForklift(String vehicleID, String brand, String color) {
        return new Forklift(vehicleID, brand, color, true);
    }
}