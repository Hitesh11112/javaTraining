package com.coforge.day_06July;

import java.util.*;

public class LinkedHashSetMain {

    public static void main(String[] args) {
        LinkedHashSet<Employee> st1 = new java.util.LinkedHashSet<>();

        st1.add(new Employee("Hitesh", 101, "Meerut", "IT", 50000));
        st1.add(new Employee("Rahul", 102, "Delhi", "HR", 45000));
        st1.add(new Employee("Priya", 104, "Mumbai", "IT", 60000));
        st1.add(new Employee("Amit", 103, "Noida", "Finance", 55000));
        st1.add(new Employee("Neha", 105, "Pune", "Testing", 48000));

        st1.add(new Employee("Vikas", 106, "Jaipur", "Support", 42000));
        st1.add(new Employee("Anjali", 107, "Lucknow", "HR", 47000));
        st1.add(new Employee("Rohit", 108, "Chandigarh", "Development", 65000));
        st1.add(new Employee("Sneha", 109, "Bangalore", "Testing", 58000));
        st1.add(new Employee("Karan", 110, "Hyderabad", "Development", 70000));

        st1.add(new Employee("Pooja", 111, "Agra", "Finance", 52000));
        st1.add(new Employee("Arjun", 112, "Kanpur", "IT", 62000));
        st1.add(new Employee("Meera", 113, "Indore", "HR", 46000));
        st1.add(new Employee("Sanjay", 114, "Bhopal", "Support", 43000));
        st1.add(new Employee("Ritika", 115, "Gurgaon", "Testing", 51000));

        st1.add(new Employee("Deepak", 116, "Faridabad", "Development", 68000));
        st1.add(new Employee("Nisha", 117, "Patna", "Finance", 54000));
        st1.add(new Employee("Mohit", 118, "Dehradun", "IT", 59000));
        st1.add(new Employee("Kavita", 119, "Varanasi", "HR", 49000));
        st1.add(new Employee("Abhishek", 120, "Ahmedabad", "Developmnt", 72000));
        

        System.out.println("Employees in LinkedHashSet:");
        for (Employee emp : st1) {
            System.out.println(emp);
        }
        System.out.println("---------------------------");
        
        //Collections.sort(st1);
        //Collections.sort() only works with a List or TreeSet, and LinkedHashSet is a Set, not a List.
        
        List<Employee> empList = new ArrayList<>(st1);

        Collections.sort(empList);

        System.out.println("Sorted List in List:");
        for (Employee emp : empList) {
            System.out.println(emp);
        }
        
        
        //complete all operation of hashset And LinkedHashSet
    }
}


