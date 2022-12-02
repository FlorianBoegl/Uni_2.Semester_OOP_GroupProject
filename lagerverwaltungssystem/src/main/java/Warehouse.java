import project.articles.Article;
import project.employees.Employee;
import project.vehicles.Vehicle;
import java.util.Scanner;

/**
 * Main Class from which a user can choose which Class to interact with
 * @author Ruf, Lukas
 * @author Bögl, Florian
 * @author Niederau, Kai Bjarne
 */
public class Warehouse {

    /**
     * Contains main loop, user can choose the partition the user wants to edit of the warehouse
     * (1 to edit Employees, 2 to edit Articles, 3 to edit Vehicles)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String options = "(1) Employees,  (2) Articles,  (3) Vehicles,   (4) Exit : ";
        String wrong_input;
        int mainLoop;

        do  {
            System.out.print("Which part of warehouse logistics do you want to access?\n" + options);

            while(!(scanner.hasNextInt())) {
                wrong_input = scanner.nextLine();
                System.out.print("\n\"" + wrong_input + "\" is not an integer. Try again.\n" + options);
            }

            mainLoop = scanner.nextInt();
            switch (mainLoop) {
                case 1 -> Employee.chooseEmployeeOperation();
                case 2 -> Article.chooseArticleOperation();
                case 3 -> Vehicle.chooseVehicleOperation();
                case 42 -> System.out.println("It is the answer.");
                // Lukas du bist ein nerd
                case 69 -> System.out.println("Error 429: Too many requests");
                default -> {}
            }
        } while (mainLoop != 4);
    }
}