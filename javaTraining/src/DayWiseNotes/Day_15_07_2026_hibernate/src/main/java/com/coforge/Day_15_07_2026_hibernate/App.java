package com.coforge.Day_15_07_2026_hibernate;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coforge.config.AppConfig;
import com.coforge.entities.Employee;
import com.coforge.service.EmployeeService;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	EmployeeService service = context.getBean(EmployeeService.class);
    	
    	Employee e = new Employee();
    	e.setEname("Charan");
    	e.setSalary(400000);
    	service.addEmployee(e);
    	
    	List<Employee> empList = service.getAllEmployee();
    	for(Employee emp : empList) {
    		System.out.println(emp);
    	}
    	
//    	int id = 1;
//    	Employee emp= service.getEmployeeById(id);
//    	System.out.println(emp);
    	
//    	Employee emp= new Employee(126,"SharathChandera",800000);
//    	if(service.updateEmployee(emp)) {
//    		System.out.println("Employee details update successfully");
//    	} else {
//    		System.out.println("No employee");
//    	}
    	
    	int id = 126;
    	if(service.deleteEmployee(id)) {
    		System.out.println("Employee deleted successfully");
    	} else {
    		System.out.println("No employee found");
    	}
    	
    	System.out.println("--------------------------------");
    	
    	
    	
    	
    }
}
