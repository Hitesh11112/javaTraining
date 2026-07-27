package com.coforge.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.coforge.entities.Customer;

@Repository
public class CustomerDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Customer> getAllCustoers() {
		String query = "select * from customer";
		return jdbcTemplate.query(query,new BeanPropertyRowMapper(Customer.class));
	}
	
	public int addCustomer(Customer customer) {
		String query="insert into customer values (?,?,?)";
		return jdbcTemplate.update(query,customer.getcId(),customer.getcName(),customer.getCity());
	}
	
	public Customer getCustomerById(long cid) {
		String query = "select * from customer where cId=?";
		List<Customer> customers = jdbcTemplate.query(
				query,
				new BeanPropertyRowMapper(Customer.class),
				cid); 
		
		if(customers.isEmpty()) {
			return null;
		}else {
			return customers.get(0);
		}
	}
		
	public int updateCustomer(long cid, Customer customer) {
		String query = "update customer set cName=?, city=? where cId=?";
		return jdbcTemplate.update(query,customer.getcName(),customer.getCity(),cid);
	}
	
	public int deleteCustomer(long cid) {
		String query = "delete from customer where cId=?";
		return jdbcTemplate.update(query,cid);
	}
}
