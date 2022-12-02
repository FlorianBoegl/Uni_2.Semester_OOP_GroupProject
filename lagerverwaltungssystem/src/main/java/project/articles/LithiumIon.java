package project.articles;

import java.util.Scanner;

/**
 * LithiumIon is a type of HazardBase for which special security procedures exist
 * newly created objects are added to the list articleList in the Class Article.
 * @author Ruf, Lukas
 */
public class LithiumIon extends HazardBase {
    /**
     * Constructor of LithiumIon class
     * hazard is set to explosive
     * id prefix is LI
     * @param name the name of the object
     */
    public LithiumIon(String name){
        this.setId("LI:" + rn.nextInt());
        this.setHazard("explosive");
        this.setName(name);
        this.availableToEndUser = true;
    }

    /**
     * Asks the user for inputs for a new LithiumIon object
     * @return a new Leisure object
     */
    public static LithiumIon create(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();

        return new LithiumIon(name);
    }
}
