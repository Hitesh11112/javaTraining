package com.coforge.Day_15Hibernate_MenuDrivern;

import java.util.List;
import java.util.Scanner;

import com.coforge.dao.EmployeeDao;
import com.coforge.entities.Employee;


public class App {
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
		boolean running = true;

		while (running) {
			System.out.println("\n===== Employee Management =====");
			System.out.println("1. Add Employee");
			System.out.println("2. View All Employees");
			System.out.println("3. Get Employee By Id");
			System.out.println("4. Update Employee");
			System.out.println("5. Delete Employee");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
				case 1:
					System.out.print("Enter name: ");
					String name = sc.nextLine();
					System.out.print("Enter salary: ");
					double salary = Double.parseDouble(sc.nextLine());

					Employee newEmp = new Employee();
					newEmp.setEname(name);
					newEmp.setSalary(salary);

					int newId = EmployeeDao.addEmployee(newEmp);
					System.out.println("Employee added with id: " + newId);
					break;

				case 2:
					List<Employee> empList = EmployeeDao.getAllEmployees();
					if (empList.isEmpty()) {
						System.out.println("No employees found.");
					} else {
						for (Employee emp : empList) {
							System.out.println(emp);
						}
					}
					break;

				case 3:
					System.out.print("Enter employee id: ");
					int searchId = Integer.parseInt(sc.nextLine());
					Employee emp = EmployeeDao.getEmployeeById(searchId);
					System.out.println(emp != null ? emp : "No employee found with id " + searchId);
					break;

				case 4:
					System.out.print("Enter employee id to update: ");
					int updateId = Integer.parseInt(sc.nextLine());
					System.out.print("Enter new name: ");
					String newName = sc.nextLine();
					System.out.print("Enter new salary: ");
					double newSalary = Double.parseDouble(sc.nextLine());

					Employee updateEmp = new Employee();
					updateEmp.setEid(updateId);
					updateEmp.setEname(newName);
					updateEmp.setSalary(newSalary);

					boolean updated = EmployeeDao.updateEmployee(updateEmp);
					System.out.println(updated ? "Employee updated successfully." : "No employee found with id " + updateId);
					break;

				case 5:
					System.out.print("Enter employee id to delete: ");
					int deleteId = Integer.parseInt(sc.nextLine());
					boolean deleted = EmployeeDao.deleteEmployee(deleteId);
					System.out.println(deleted ? "Employee deleted successfully." : "No employee found with id " + deleteId);
					break;

				case 6:
					running = false;
					System.out.println("Exiting.");
					break;

				default:
					System.out.println("Invalid choice, try again.");
			}
		}

		sc.close();
    }
}
