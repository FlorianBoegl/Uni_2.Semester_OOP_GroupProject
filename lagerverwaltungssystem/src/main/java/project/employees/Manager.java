package project.employees;

/*
Manager is the class to construct Manager instances
@author: studnieka3658
 */
public class Manager extends Employee{

    /*
    Standardkonstruktor der Klasse Manager
     */
    public Manager(String name) {
        super(name);
        type = "Manager";
        id = nextId()*23;
    }
}
