package project;

import project.articles.*;
import project.employees.*;
import project.vehicles.*;

/**
 * Class to simulate behavior of our project
 * @author Ruf, Lukas
 */
public class StartUp {
    public void simulate() {
        Sport s = new Sport("football", 0);
        Leisure l = new Leisure("yoga mat", 1);
        LithiumIon li = new LithiumIon("Lion");
        Chemicals c = new Chemicals();
        c.setName("Aluminium hydroxide");
        Article.getarticleList().add(s);
        Article.getarticleList().add(l);
        Article.getarticleList().add(li);
        Article.getarticleList().add(c);

        Janitor j = new Janitor("Harold");
        Manager m = new Manager("Bill Lumbergh");
        Security sec = new Security("Hugh Dane");
        Worker w = new Worker("Lenin");

        Drone d = new Drone("anid", "DJI", "white", false);
        Forklift f = new Forklift("anotherid", "Hoist", "yellow", true);
        PassengerCar pc = new PassengerCar("yetanotherid", "Lada", "grey", true);
        Truck t = new Truck(String.valueOf(69), "Tesla", "white", false);

        Article.printArticles();
        Employee.printEmployees();
        Vehicle.printVehicles();

        System.out.println("End of Demo. For more functionality, please consider using our enterprise-grade TUI in Warehouse.");
    }
}
