package project.vehicles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Vehicle is the class that manages all vehicles in the Warehouse
 * (Vehicle, Truck, Forklift, PassengerCar and Drone objects)
 * @author Bögl Florian
 */
public abstract class Vehicle {

    // vehicleID is a Vehicle Attribute, identity of a specific Vehicle
    protected String vehicleID;
    public String getVehicleID() {
        return vehicleID;
    }


    // brand is a Vehicle Attribute, the brand of the producer of the Vehicle
    protected String brand;
    public String getBrand() {
        return brand;
    }


    // color is a Vehicle Attribute, the color of the Vehicle
    protected String color;
    public String getColor() {
        return color;
    }


    // available is a Vehicle Attribute, describes if a Vehicle is available to use(true) or not(false)
    protected boolean available;
    public boolean isAvailable() {
        return available;
    }


    // numberVehicles is the total number of all Vehicle objects (Trucks + Forklifts + PassengerCars + Drones )
    protected static int numberVehicles;
    public static int getNumberVehicles() {
        return numberVehicles;
    }
    public static void setNumberVehicles(int numberVehicles) {
        Vehicle.numberVehicles = numberVehicles;
    }


    // vehicleList is a list in which all new created Vehicle objects are added
    // ( all new Truck, Forklift, Drone and PassengerCar objects)
    private static final List<Vehicle> vehicleList = new ArrayList<>();
    public static List<Vehicle> getVehicleList() {
        return vehicleList;
    }


    /**
     * chooseVehicleOperation() is a function that lets a user
     * choose between all functions in the Vehicle class that a
     * user can interact with.
     * It is the first function a user will interact with if he
     * chooses to go to the Vehicle section in the main function
     * of the Warehouse.
     */
    public static void chooseVehicleOperation() {
        System.out.println();
        int b = 0;

        Scanner scanner = new Scanner(System.in);

        while (b != 5) {

            System.out.print("Optional operations: (1)create a new vehicle   (2)print list of vehicles   (3)print number of vehicles   (4)delete vehicle   (5)Exit: ");

            while (!(scanner.hasNextInt())) {
                if (!(scanner.hasNextInt())) System.out.print("Something went wrong try again! " +
                        "(1)create a new vehicle   (2)print list of vehicles   (3)print number of vehicles   (4)delete vehicle   (5)Exit: ");
                scanner.nextLine();
            }

            b = Integer.parseInt(scanner.nextLine());

            switch (b) {
                case 1 -> {
                    try {
                        createNewVehicle();
                    } catch (WrongInputException e) {
                        System.out.println("Wrong Input!");
                        e.printStackTrace();
                    }
                }
                case 2 -> printVehicles();
                case 3 -> printNumberVehicles();
                case 4 -> deleteVehicle();
                case 5 -> {}
            }
        }
    }


    /**
     * lets a user choose between a new Truck, Forklift, PassengerCar or Drone object
     * and creates a new object of the chosen Vehicle type that is added to the vehicleList
     */
    public static void createNewVehicle() throws WrongInputException {
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Which Vehicle do you want to add? (1)truck   (2)forklift   (3)passenger car   (4)drone   (5)Exit: ");

        while(!(scanner.hasNextInt())) {
            if (!(scanner.hasNextInt())) System.out.print("\nSomething went wrong try again! " +
                    "(1)truck   (2)forklift   (3)passenger car   (4)drone   (5)Exit: ");
            scanner.nextLine();
        }

        int b = Integer.parseInt(scanner.nextLine());

        switch (b) {
                case 1 -> {
                    vehicleList.add(Truck.createNewTruck());
                    System.out.println("New Truck added to vehicle list.");
                }
                case 2 -> {
                    vehicleList.add(Forklift.createNewForklift());
                    System.out.println("New Forklift added to vehicle list");
                }
                case 3 -> {
                    vehicleList.add(PassengerCar.createNewPassengerCar());
                    System.out.println("New Passenger Car added to vehicle list");
                }
                case 4 -> {
                    vehicleList.add(Drone.createNewDrone());
                    System.out.println("New Drone added to vehicle list");
                }
                case 5 -> {
                }
                default -> throw new WrongInputException();
            }
            System.out.println();
    }


    /**
     * Prints all Vehicle objects added to vehicleList
     * Place in vehicleList, which Vehicle type, ID, Brand and color
     * (all Truck, Forklift, PassengerCar and Drone objects)
     */
    public static void printVehicles() {
        System.out.println();
        for (Vehicle vehicle : vehicleList) {
            printVehicles(vehicle);
        }
        System.out.println();
    }
    public static void printVehicles(Vehicle vehicle) {
        System.out.print("Nr.");
        System.out.printf("%-3s", vehicleList.indexOf(vehicle));

        System.out.print(" Vehicle type: ");
        System.out.printf("%-15s", vehicle.getClass().getSimpleName());

        System.out.print("Vehicle ID: ");
        System.out.printf("%-12s", vehicle.getVehicleID());

        System.out.print("Brand: ");
        System.out.printf("%-12s", vehicle.getBrand());

        System.out.print("Color: ");
        System.out.printf("%-12s", vehicle.getColor());

        System.out.print("Availability: ");
        System.out.printf("%-10s", vehicle.isAvailable());

        System.out.println();
    }


    /**
     * Prints the total number of Vehicle, Forklift, PassengerCar, Truck and Drone objects
     */
    public static void printNumberVehicles() {

        System.out.printf("Number of total vehicles: %d\n", Vehicle.getNumberVehicles());

        System.out.printf("Number of trucks: %d\n", Truck.getNumberTrucks());

        System.out.printf("Number of passenger cars: %d\n", PassengerCar.getNumberPassengerCars());

        System.out.printf("Number of forklifts: %d\n", Forklift.getNumberForklifts());

        System.out.printf("Number of drones: %d\n\n", Drone.getNumberDrones());
    }


    /**
     * Lets a user choose a list index n to delete a Vehicle
     * that is at position 0 <= n < numberVehicles in the vehicleList
     */
    public static void deleteVehicle() {

        Scanner scanner = new Scanner(System.in);
        int deleteThisVehicle;

        if (numberVehicles > 0) {
            System.out.print("Which vehicle do you want to delete? (Input to Nr. shown in print list of vehicles): ");

            while (!(scanner.hasNextInt())) {
                if (!(scanner.hasNextInt())) System.out.print("Something went wrong try again: ");
                scanner.nextLine();
            }
            deleteThisVehicle = Integer.parseInt(scanner.nextLine());
            try {
                Vehicle.deleteVehicle(vehicleList, deleteThisVehicle);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("No vehicles in List");
        }
    }


    /**
     * Delete a Vehicle in vehicleList at the input int index
     * Checks if index the index is correct.
     * Decrements the numberOfVehicles and the fitting subclass of
     * deleted Vehicle.
     * @param vehicleList to implement test in vehicleTest.java
     * @param index is the list index of vehicleList
     */
    public static void deleteVehicle(List<Vehicle> vehicleList, int index) {
        if ((index >= 0) && (index < (Vehicle.numberVehicles))) {
                String subclassNameAtIndex = vehicleList.get(index).getClass().getSimpleName();

                switch (subclassNameAtIndex) {
                    case "Truck" -> Truck.decrementNumberTrucks();
                    case "PassengerCar" -> PassengerCar.decrementNumberPassengerCars();
                    case "Drone" -> Drone.decrementNumberDrones();
                    case "Forklift" -> Forklift.decrementNumberForklifts();
                }
                numberVehicles--;
                vehicleList.remove(index);
                System.out.printf("Deleted %s at the position %d.\n", subclassNameAtIndex, index);
        }
        else {
            throw new ArrayIndexOutOfBoundsException("Wrong index!");
        }
    }
}