package DayWiseAssignment.Day_3July;

import java.util.Arrays;
import java.util.Scanner;

class Employees implements Comparable<Employees> {
    private int id;
    private String name;
    private double salary;
    private String address;

    // Parameterized Constructor
    Employees(int id, String name, double salary, String address) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    // Getters
    public int getId() { return id; }

    public String getName() { return name; }

    public double getSalary() {
        return salary;
    }

    public String getAddress() {
        return address;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // toString Method
    @Override
    public String toString() {
        return "Employee ID : " + id +
               "\nName        : " + name +
               "\nSalary      : " + salary +
               "\nAddress     : " + address +
               "\n----------------------------";
    }
    
    @Override
    public int compareTo(Employees e) {
        return Double.compare(this.salary, e.salary);
    }
}

public class EmployeeClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Array of Employees objects
        Employees[] emp = new Employees[10];

        System.out.println("Enter details of 10 employees:");

        for (int i = 0; i < emp.length; i++) {

            System.out.println("\nEmployee " + (i + 1));

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter Address: ");
            String address = sc.nextLine();

            emp[i] = new Employees(id, name, salary, address);
        }

        Arrays.sort(emp);

        System.out.println("\n******** Employee Details (Sorted by Salary) ********");

        for (Employees e : emp) {
            System.out.println(e);
        }

        sc.close();
    }
}