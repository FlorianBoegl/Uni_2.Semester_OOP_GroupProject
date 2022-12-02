package project.articles;

import java.util.Scanner;

/**
 * Leisure is a type of Article intended for user consumption
 * newly created objects are added to the list articleList in the Class Article.
 * @author Ruf, Lukas
 */
public class Leisure extends Article {
    /**
     * Constructor of Leisure class
     * @param name the name of the object
     * @param type the type of the object
     */
    public Leisure(String name, int type){
        this.setId("L:" + rn.nextInt());
        this.setName(name);
        this.setType(type);
        this.availableToEndUser = true;
    }

    /**
     * Asks the user for inputs for a new Leisure object
     * @return a new Leisure object
     */
    public static Leisure create(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Type: ");
        while(!(scanner.hasNextInt())) {
            if (!(scanner.hasNextInt())) System.out.println("Input has to be an integer");
            scanner.nextLine();
        }
        int type = scanner.nextInt();

        return new Leisure(name, type);
    }
}
