package project.articles;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * This class includes all basic attributes needed for other article types
 * and includes a frontend for user input
 * @author Ruf, Lukas
 */
public class Article {
    /**
     * Random number generator for id generation
     */
    public Random rn = new Random();

    // Number of Articles in articleList. Can be accessed with getNumArticles()/
    private static int numArticles;
    // List of Articles. Can be accessed with getarticleList()
    private static final List<Article> articleList = new ArrayList<>();

    /**
     * Type of the item
     */
    protected int type;
    /**
     * Name of the item
     */
    protected String name;
    /**
     * Id of the item (prefixed based on kind)
     */
    protected String id;
    /**
     * If item should be sold to private individuals
     */
    protected boolean availableToEndUser;

    /**
     * Returns the type of an object
     * @return int
     */
    public int getType() {
        return type;
    }

    /**
     * Sets the type of an object
     * @param type type of the object
     */
    public void setType(int type) { this.type = type; }

    /**
     * Returns the name of an object
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of an object
     * @param name name of the object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the id of an object
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of an object
     * @param id if of the object
     */
    public void setId(String id) { this.id = id; }

    /**
     * Returns number of articles in articleList
     * @return int
     */
    public static int getNumArticles() {
        return numArticles;
    }

    /**
     * Returns the articleList
     * @return ArrayList
     */
    public static List<Article> getarticleList() {
        return articleList;
    }

    /**
     * Returns availability
     */
    public boolean getAvailability() {
        return availableToEndUser;
    }


    /**
     * Returns a string of the article
     * @return String
     */
    @Override
    public String toString() {
        return String.join(" ", Integer.toString(this.getType()), this.getName(), this.getId(), Boolean.toString(this.getAvailability()));
    }

    /**
     * Method called by Warehouse for user interaction
     * Possible operations include:
     * - create: creates a new object based on user choice and adds it articleList
     * - list: prints all objects in articleList
     */
    public static void chooseArticleOperation(){
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Choose operation:\n(1) %-15s (2) %-15s\n", "create", "list");
        while(!(scanner.hasNextInt())) {
            System.out.println("Input has to be an integer");
            scanner.nextLine();
        }
        int a = scanner.nextInt();
        switch (a) {
            case 1 -> {
                try {
                    createArticleOperation();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
            case 2 -> printArticles();
            default -> System.out.println("Given Integer not in range");
        }
    }

    /**
     * Method for user to specify which kind of article should be created.
     * For the creation of each kind, refer to the create method of each class.
     * @throws NoSuchMethodException if an option is not implemented
     */
    public static void createArticleOperation() throws NoSuchMethodException {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Choose kind of article:\n(1) %-15s (3) %-15s\n(2) %-15s (4) %-15s\n(5) %-15s (6) %-15s\n", "Chemicals", "Leisure", "Lithium-Ion", "Sport", "Other", "Exit");

        while(!(scanner.hasNextInt())) {
            System.out.println("Input has to be an integer");
            scanner.nextLine();
        }
        int a = scanner.nextInt();

        switch (a) {
            case 1 -> {
                try {
                    articleList.add(Chemicals.create());
                    numArticles++;
                    System.out.println("Chemical added to list.");
                } catch (IllegalNameException e) {
                    e.printStackTrace();
                }
            }
            case 2 -> {
                articleList.add(LithiumIon.create());
                numArticles++;
                System.out.println("Lithium-Ion added to list");
            }
            case 3 -> {
                articleList.add(Leisure.create());
                numArticles++;
                System.out.println("Leisure added to list");
            }
            case 4 -> {
                articleList.add(Sport.create());
                numArticles++;
                System.out.println("Sport added to list");
            }
            case 5 -> {
                // not a great idea, but we need different Exceptions
                throw new NoSuchMethodException("There is nothing else to create");
            }
            case 6 -> {}
            default -> {
                System.out.println("Given Integer not in range");
                //createArticleOperation();
            }
        }
        System.out.println();
    }

    /**
     * Method to print articleList in a human-readable format
     * @throws IllegalStateException if articleList is empty
     */
    public static void printArticles() {
        // this is not best practice, but I can't think of a better place to throw an exception right now
        if (articleList.size() == 0) {
            throw new IllegalStateException();
        }

        for (Article article : articleList) {
            System.out.printf("Idx. %-5s ", articleList.indexOf(article));
            System.out.printf("Class: %-15s ", article.getClass().getSimpleName());
            System.out.printf("Type: %-15s ",article.getType());
            System.out.printf("Id: %-15s " , article.getId());
            System.out.printf("Name: %-15s", article.getName());
            if (article instanceof HazardBase)
                System.out.print("\nNote: possibly hazardous");
            System.out.print("\n");
        }
    }
}
