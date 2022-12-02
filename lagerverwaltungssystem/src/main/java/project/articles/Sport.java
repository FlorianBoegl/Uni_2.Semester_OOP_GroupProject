package project.articles;

import java.util.Scanner;

/**
 * Sport is a type of Article which includes various devices for non-programming related activities
 * newly created objects are added to the list articleList in the Class Article.
 * @author Ruf, Lukas
 */
public class Sport extends Article {
    /**
     * Constructor of Sport class
     * @param name the name of the object
     * @param type the type of the object
     */
    public Sport(String name, int type){
        this.setId("S:" + rn.nextInt());
        this.setName(name);
        this.setType(type);
        this.availableToEndUser = true;
    }

    /**
     * Custom setType for Sport
     * @param type type of the object
     * @throws IllegalArgumentException if type is < 0
     */
    @Override
    public void setType(int type) {
        if (type < 0)
            throw new IllegalArgumentException();
        super.setType(type);
    }

    /**
     * Asks the user for inputs for a new Sport object
     * @return a new Sport object
     */
    public static Sport create() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Type: ");
        while(!(scanner.hasNextInt())) {
            if (!(scanner.hasNextInt())) System.out.println("Input has to be an integer");
            scanner.nextLine();
        }
        int type = scanner.nextInt();

        return new Sport(name, type);
    }
}
