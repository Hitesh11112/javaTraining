package com.coforge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cofoge.entities.Customer;
import com.coforge.service.CustomerService;

@Controller
@ResponseBody
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@RequestMapping("/customers")
	public List<Customer> getAllCustomer() {
		return service.getAllCustomers();
	}
	
	@RequestMapping(value="/customers",method=RequestMethod.POST)
	public int addCustomer(@RequestBody Customer customer) {
		return service.addCustomer(customer);
	}
	
	@RequestMapping("/customers/{cid}")
	public Customer getCustomerById(@PathVariable("cid") long cid) {
		return service.getCustomerById(cid);
	}
	
	@RequestMapping(value="/customers/{cid}",method=RequestMethod.PUT)
	public int updateCustomer(@PathVariable("cid") long cid, @RequestBody Customer customer) {
		return service.updateCustomer(cid,customer);
	}
	
	@RequestMapping(value="/customers/{cid}",method=RequestMethod.DELETE)
	public int deleteCustomer(@PathVariable("cid") long cid) {
		return service.deleteCustomer(cid);
	}
}
