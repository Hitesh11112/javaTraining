package com.coforge.dao;

import java.util.List;

import org.hibernate.Session;

import com.coforge.entities.Employee;
import com.coforge.util.HibernateUtil;

public class EmployeeDao {

	public static List<Employee> getAllEmployees() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Employee> list = session.createQuery("from Employee", Employee.class).getResultList();
		session.close();
		return list;
	}

	public static int addEmployee(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		int id = (int) session.save(employee);
		session.getTransaction().commit();
		session.close();
		return id;
	}

	public static Employee getEmployeeById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee emp = session.get(Employee.class, id);
		session.close();
		return emp;
	}

	public static boolean updateEmployee(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Employee exEmp = session.get(Employee.class, employee.getEid());
		boolean updated = false;
		if (exEmp != null) {
			exEmp.setEname(employee.getEname());
			exEmp.setSalary(employee.getSalary());
			updated = true;
		}
		session.getTransaction().commit();
		session.close();
		return updated;
	}

	public static boolean deleteEmployee(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Employee exEmp = session.get(Employee.class, id);
		boolean deleted = false;
		if (exEmp != null) {
			session.remove(exEmp);
			deleted = true;
		}
		session.getTransaction().commit();
		session.close();
		return deleted;
	}
	
}