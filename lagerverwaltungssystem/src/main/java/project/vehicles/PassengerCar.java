package project.vehicles;
import java.util.Scanner;

/**
 * PassengerCar is a type of Vehicle that can be used by workers inside and outside the Warehouse,
 * newly created PassengerCars are added to the list vehicleList in the Class Vehicle.
 * @author Bögl Florian
 */
public class PassengerCar extends Vehicle {

    // numberPassengerCars is the total number of PassengerCar objects
    private static int numberPassengerCars;
    public static void setNumberPassengerCars(int numberPassengerCars) {
        PassengerCar.numberPassengerCars = numberPassengerCars;
    }
    public static int getNumberPassengerCars() {
        return numberPassengerCars;
    }
    public static void decrementNumberPassengerCars() {
        PassengerCar.numberPassengerCars--;
    }


    /**
     * Constructor for PassengerCar object
     * @param vehicleID Attribute for constructor, an ID to identify the PassengerCar
     * @param brand Attribute for constructor, the brand of the PassengerCar
     * @param color Attribute for constructor, the color of the PassengerCar
     * @param available Attribute for constructor, describes if the PassengerCar
     *                  is in use or available for a worker
     */
    public PassengerCar(String vehicleID, String brand, String color, boolean available) {
        super();
        super.vehicleID = vehicleID;
        super.brand = brand;
        super.color = color;
        super.available = available;
        PassengerCar.numberPassengerCars++;
        Vehicle.numberVehicles++;
    }


    /**
     * Asks the user for inputs for a new PassengerCar and gives the inputs to
     * function that actually creates the new PassengerCar
     * @return a new PassengerCar object
     */
    public static PassengerCar createNewPassengerCar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Which vehicle ID does the passenger car have? ");
        String vehicleID = scanner.nextLine();

        System.out.print("Which brand does the passenger car have? ");
        String brand = scanner.nextLine();

        System.out.print("Which color does the passenger car have? ");
        String color = scanner.nextLine();

        return createNewPassengerCar(vehicleID, brand, color);
    }


    /**
     * Creates a new PassengerCar with the input of the three parameters
     * @param vehicleID String for PassengerCar constructor to construct a new PassengerCar object
     * @param brand String for PassengerCar constructor to construct a new PassengerCar object
     * @param color String or PassengerCar constructor to construct a new PassengerCar object
     * @return a new PassengerCar object, default the new PassengerCar is available
     */
    public static PassengerCar createNewPassengerCar(String vehicleID, String brand, String color) {
        return new PassengerCar(vehicleID, brand, color, true);
    }
}