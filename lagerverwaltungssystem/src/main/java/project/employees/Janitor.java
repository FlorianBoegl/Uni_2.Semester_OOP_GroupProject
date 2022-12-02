package project.employees;

/*
Janitor is the class to construct Janitor instances
@author: studnieka3658
 */
public class Janitor extends Employee{

    /*
    Standardkonstruktor der Klasse Janitor
     */
    public Janitor(String name) {
        super(name);
        type = "Janitor";
        id = nextId()*37;
    }

}
