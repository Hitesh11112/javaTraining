package com.coforge.day_06July;

import java.util.*;


public class EmployeeMain {
	public static void main(String[] args) {
		LinkedList<Employee> empList = new LinkedList<>();
		
		empList.add(new Employee("Hitesh", 101, "Meerut", "IT", 50000));
		empList.add(new Employee("Rahul", 102, "Delhi", "HR", 45000));
		empList.add(new Employee("Amit", 103, "Noida", "Finance", 55000));
		empList.add(new Employee("Priya", 104, "Mumbai", "IT", 60000));
		empList.add(new Employee("Neha", 105, "Pune", "Testing", 48000));
		
		empList.add(new Employee("Vikas", 106, "Jaipur", "Support", 42000));
		empList.add(new Employee("Anjali", 107, "Lucknow", "HR", 47000));
		empList.add(new Employee("Rohit", 108, "Chandigarh", "Development", 65000));
		empList.add(new Employee("Sneha", 109, "Bangalore", "Testing", 58000));
		empList.add(new Employee("Karan", 110, "Hyderabad", "Development", 70000));

		empList.add(new Employee("Pooja", 111, "Agra", "Finance", 52000));
		empList.add(new Employee("Arjun", 112, "Kanpur", "IT", 62000));
		empList.add(new Employee("Meera", 113, "Indore", "HR", 46000));
		empList.add(new Employee("Sanjay", 114, "Bhopal", "Support", 43000));
		empList.add(new Employee("Ritika", 115, "Gurgaon", "Testing", 51000));
		
		empList.add(new Employee("Deepak", 116, "Faridabad", "Development", 68000));
		empList.add(new Employee("Nisha", 117, "Patna", "Finance", 54000));
		empList.add(new Employee("Mohit", 118, "Dehradun", "IT", 59000));
		empList.add(new Employee("Kavita", 119, "Varanasi", "HR", 49000));
		empList.add(new Employee("Abhishek", 120, "Ahmedabad", "Development", 72000));
		

		System.out.println("---------------");
		System.out.println("Before sorting");
		for(Employee emp : empList) {
			System.out.println(emp);
		}
		
		

//		Collections.sort(empList);
//		for(Employee emp : empList) {
//			System.out.println(emp);
//		}
		
		//sort based on department with an internal sorting -
		//on their names 
		//find highest salary emp under the dept 
		
		//with the help of the COMPARATOR--> internal method then comparing
		//city comparator()
		//then comparing (new dept(comp()
		//then comparing (new salary())
		
		System.out.println("---------------");
		empList.sort(new CityComparator()
				.thenComparing(new DepartmentComp())
				.thenComparing(new SalaryComp()));
		
		System.out.println("After sorting w.r.t Comparator");
		for(Employee emp : empList) {
			System.out.println(emp);
		}		
		
	
		
//		System.out.println("---------------");
//		System.out.println("After sorting");
						
	}
}
