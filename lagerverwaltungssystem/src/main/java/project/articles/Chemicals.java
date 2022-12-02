package project.articles;

import java.util.Arrays;
import java.util.Scanner;

/**
 * This class contains attributes for chemical compounds
 * @author Ruf, Lukas
 */
public class Chemicals extends HazardBase {
    private static String[] blacklist = {"bad", "horrible"};

    /**
     * Constructor of Chemicals class
     * @param hazard Attribute for constructor, an int to set the hazard level
     * @param name Attribute for constructor, a name to identify the object
     */
    public Chemicals(String hazard, String name, boolean availableToEndUser){
        this.setHazard(hazard);
        this.setId("C:" + rn.nextInt());
        this.name = name;
        this.availableToEndUser = availableToEndUser;
    }

    public Chemicals(String hazard, String name){
        this(hazard, name, false);
    }

    /**
     * Default constructor setting the hazard level to corrosive
     */
    public Chemicals() {
        this.setHazard("corrosive");
    }

    /**
     * Asks the user for inputs for a new Chemicals object
     * if Hazard is left empty, the default 'corrosive' is set
     * @return new Chemicals object
     * @throws IllegalNameException if name contains any blacklisted terms
     */
    public static Chemicals create() throws IllegalNameException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hazard (corrosive): ");
        String hazard = scanner.nextLine();
        if (hazard.equals(""))
            hazard = "corrosive";

        System.out.print("Name: ");
        String name = scanner.nextLine();

        if (Arrays.stream(blacklist).anyMatch(name.toLowerCase()::contains)) {
            throw new IllegalNameException();
        }

        System.out.print("Available to End User: ");
        String av = scanner.nextLine();
        boolean availableToEndUser = av.toLowerCase().equals("y");

        return new Chemicals(hazard, name, availableToEndUser);
    }
}
