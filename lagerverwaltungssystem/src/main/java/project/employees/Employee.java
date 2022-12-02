package project.employees;

import project.articles.HazardBase;
import project.articles.IllegalNameException;

import java.util.*;

/*
Employee is the Abstract class to manage all Employees
@author: studnieka3658
 */
public abstract class Employee {
    private static int numemployees;

    private static Random random = new Random();
    private static int idcount = random.nextInt(883,999);
    private static List<Employee> employees = new ArrayList<>();

    protected String name;
    protected String address;
    protected int id;
    protected String type;
    protected float salary;

    public static Scanner scanner = new Scanner(System.in);

    /*
    Default constructor
     */
    public Employee(String name){
        this.name = name;
        this.addEmployee();
    }

    /*
    return the global amount of Employees
     */
    public static int getNumEmployees() {
        return numemployees;
    }

    /*
    returns the whole ArrayList of Employees
     */
    public static List<Employee> getEmployeeList() {
        return employees;
    }


    /*
    adds the current Employee to the List
     */
    public void addEmployee() {
        employees.add(this);
        numemployees++;
        employees.sort(Comparator.comparing(Employee::getId));
    }

    static int nextId(){
        return idcount++;
    }

    /*
    removes the current Employee from the List
     */
    public void removeEmployee() {
        employees.remove(this);
        numemployees--;
    }

    /*
    returns Name of the Employee
     */
    public String getName() {
        return name;
    }

    /*
    sets the Name for the Employee
     */
    protected void setName(String name) {
        this.name = name;
    }

    /*
    returns the Address of the Employee
     */
    public String getAddress() {
        return address;
    }

    /*
    sets the Address for the Employee
     */
    protected void setAddress(String address) {
        this.address = address;
    }

    /*
    returns Salary as float value
     */
    public float getSalary() {
        return salary;
    }

    /*
    set the salary for the Employee
    protected to access from any other object
     */
    protected void setSalary(float salary) {
        this.salary = salary;
    }

    /*
    returns Type of the Employee
    eg Security,Janitor,...
     */
    public String getType() {
        return type;
    }

    /*
    returns the ID of the Employee
     */
    public int getId(){
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Employee)) return false;
        return Objects.equals(((Employee)obj).getType(), this.getType());
    }

    /*
        Overrides global to String Method
        */
    @Override
    public String toString() {
        return name + " (" + type + ") ID: " + Integer.toHexString(id).toUpperCase() + ", Address: " + address + ", Salary: " + salary;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    /*
        User interface to control Employee via the Console
         */
    public static void chooseEmployeeOperation() {
        int a;
        do {
            System.out.println("Choose operation:\n(1) create \n(2) print\n(3) edit\n(4) exit");
            while (!(scanner.hasNextInt())) {
                System.out.println("Input has to be an integer!");
                scanner.nextLine();
            }
            a = scanner.nextInt();
            switch (a) {
                case 1 -> {
                    createEmployee();
                }
                case 2 -> {
                    printEmployees();
                }
                case 3 -> {
                    editEmployee();
                }
                case 4 -> {
                    System.out.println("Exited Employee successfully\n");
                }
                default -> {
                    System.out.println("Given Integer not in range!");
                }
            }
        }while(a!=4);
    }

    /*
   Lets the user crate a new Employee with a given Name which is added to the List
    */
    public static void createEmployee() {
        scanner.nextLine();
        System.out.println("Choose operation:\n(1) Worker \n(2) Security \n(3) Janitor \n(4) Manager");
        while (!(scanner.hasNextInt())) {
            System.out.println("Input has to be an integer");
            scanner.nextLine();
        }
        int a = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Name of the Employee: ");
        String name1 = scanner.nextLine();
        switch (a) {
            case 1 -> {
                try {
                    new Worker(name1);
                    System.out.println("New Worker with Name \"" + name1 + "\" added as Employee");
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
            case 2 -> {
                new Security(name1);
                System.out.println("New Security Guard with Name \"" + name1 + "\" added as Employee");
            }
            case 3 -> {
                new Janitor(name1);
                System.out.println("New Janitor with Name \"" + name1 + "\" added as Employee");
            }
            case 4 -> {
                new Manager(name1);
                System.out.println("New Manager with Name \"" + name1 + "\" added as Employee");
            }
            default -> {
                System.out.println("Given Integer not in range");
            }
        }
    }

    /*
    prints the List to the console
     */
    public static void printEmployees() {
        if (employees.size() == 0) {
            throw new IllegalStateException();
        }
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    /*
    Empties the Employee ArrayList
     */
    public static void emptyEmployees(){
        employees.clear();
        numemployees = 0;
    }

    /*
    Used to edit a specific Employee
     */
    public static void editEmployee(String name, String address, float salary) {
        Employee edit = null;
        for (Employee e : employees) {
            if (e.getName().equals(name)) edit = e;
        }
        if (edit == null) return;
        if (address != null) {
            edit.setAddress(address);
        }
        if (salary != -1) {
            edit.setSalary(salary);
        }
    }

    /*
    Used to edit a specific Employee via Console
     */
    public static void editEmployee() {
        scanner.nextLine();
        System.out.println("Input Name to Edit: ");
        String name = scanner.nextLine();

        System.out.print("Input new Address for " + name + ": ");
        String address = scanner.nextLine();
        if (address.equals("-")) address = null;

        System.out.println("Input new Salary for " + name + " - -1 to keep: ");
        while (!(scanner.hasNextFloat())) {
            System.out.println("Input has to be an floating point!");
            scanner.nextLine();
        }
        float salary = scanner.nextFloat();

        editEmployee(name,address,salary);
    }


}
