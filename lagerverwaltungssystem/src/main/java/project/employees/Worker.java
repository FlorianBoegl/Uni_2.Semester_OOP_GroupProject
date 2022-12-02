package project.employees;

/*
Worker is the class to construct Worker instances
@author: studnieka3658
 */
public class Worker extends Employee{

    /*
    Standardkonstruktor der Klasse Worker
     */
    public Worker(String name) {
        super(name);
        type = "Worker";
        id = nextId()*31;
    }
}
