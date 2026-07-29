package com.coforge.Day_15_07_26_SimpleHibernatePrj;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coforge.entities.Employee;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

    	SessionFactory factory = new Configuration()
    			.configure("hibernate.cfg.xml")
    			.buildSessionFactory();
    	Session session = factory.openSession();
    	
    	
    	//addEmployee
//    	Employee e1=new Employee();
//    	e1.setEname("Amit");
//    	e1.setSalary(78000);
    	Transaction transaction=session.beginTransaction();
//    	session.persist(e1);
//    	transaction.commit();
    	

    	//updateEmployee
//    	int id = 5;
//    	Employee emp = session.get(Employee.class, id);
//    	if(emp!= null) {
//    		emp.setEname("Hitesh");
//    		emp.setSalary(8900898);
//    		session.update(emp);
//        	transaction.commit();
//
//    	}else {
//    		System.out.println("No employee with this id to update");
//    	}
    	
    	//deleteEmployee
    	int id = 7;
    	Employee emp = session.get(Employee.class, id);
    	if(emp!= null) {
    		session.remove(emp); 
    	    System.out.println("Employee deleted: " + id);
    	    transaction.commit();
    	}else {
    		System.out.println("No employee with this id to delete");
    	}
    	
    	//getAllEmployee
    	List<Employee> empList = new ArrayList<Employee>();
    	empList=session.createSelectionQuery("from Employee", Employee.class).getResultList();
    	for(Employee e : empList) {
    		System.out.println(e);
    	}
    	
    	//getEmployeeById
//    	int id = 89;
//    	Employee getEmp = session.get(Employee.class, id);
//    	if(getEmp!=null) System.out.println("Selected Emp: " + getEmp);
//    	else System.out.println("No Emp exist with this id " + id);
    	
    	
    	session.close();
    	factory.close();
    }
}
