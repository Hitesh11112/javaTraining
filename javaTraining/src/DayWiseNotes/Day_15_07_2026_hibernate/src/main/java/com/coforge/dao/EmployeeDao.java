package com.coforge.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coforge.entities.Employee;


@Repository
public class EmployeeDao {
	
	@Autowired
	SessionFactory sessionFactory;	
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public List<Employee> getAllEmployees() {
		return getSession().createQuery("from Employee",Employee.class).getResultList();
	}
	
	public int addEmployee(Employee employee) {
		return (int) getSession().save(employee);
	}
	
	public Employee getEmployeeById(int id) {
		return getSession().get(Employee.class, id);
	}
	
	public boolean updateEmployee(Employee employee) { 
		Employee exEmp = getSession().get(Employee.class, employee.getEid());
		if(exEmp!= null) {
			exEmp.setEname(employee.getEname());
			exEmp.setSalary(employee.getSalary());
			return true;
		}
		return false;
	}
	
	
	public boolean deleteEmployee(int id) {
		Employee exEmp=getSession().get(Employee.class, id);
		if(exEmp!= null) {
			getSession().remove(exEmp);
			return true;
		}
		return false;
	}
	
	
}
