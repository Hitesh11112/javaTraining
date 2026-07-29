package com.coforge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cofoge.entities.Customer;
import com.coforge.dao.CustomerDao;

@Service
public class CustomerService {
	
	@Autowired
	CustomerDao dao;
	
	public List<Customer> getAllCustomers() {
		return dao.getAllCustoers();
	}
	
	public int addCustomer(Customer customer) {
		return dao.addCustomer(customer);
	}
	
	public Customer getCustomerById(long cid) {
		return dao.getCustomerById(cid);
	}
	
	public int updateCustomer(long cid, Customer customer) {
		return dao.updateCustomer(cid, customer);
	}
	
	public int deleteCustomer(long cid) {
		return dao.deleteCustomer(cid);
	}
	
}
