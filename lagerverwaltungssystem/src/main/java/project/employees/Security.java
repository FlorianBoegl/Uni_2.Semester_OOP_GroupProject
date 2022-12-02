package project.employees;

/*
Security is the class to construct Security instances
@author: studnieka3658
 */
public class Security extends Employee{

    /*
    Standardkonstruktor der Klasse Security
     */
    public Security(String name) {
        super(name);
        type = "Security";
        id = nextId()*29;
    }
}
