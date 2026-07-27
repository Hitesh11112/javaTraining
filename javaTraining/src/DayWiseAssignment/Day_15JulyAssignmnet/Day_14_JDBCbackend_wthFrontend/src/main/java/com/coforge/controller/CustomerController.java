package com.coforge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coforge.entities.Customer;
import com.coforge.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService service;

	@RequestMapping("/customers-ui")
	public String getAllCustomers(Model model) {
		model.addAttribute("customerList", service.getAllCustomers());
		return "customer-list";
	}

	@RequestMapping("/customers-ui/add")
	public String addCustomerForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "add-customer";
	}

	@RequestMapping(value = "/customers-ui/create", method = RequestMethod.POST)
	public String createCustomer(@ModelAttribute Customer customer) {
		service.addCustomer(customer);
		return "redirect:/customers-ui";
	}

	@RequestMapping("/customers-ui/update/{cid}")
	public String updateCustomerForm(@PathVariable("cid") long cid, Model model) {
		model.addAttribute("customer", service.getCustomerById(cid));
		return "update-customer";
	}

	@RequestMapping(value = "/customers-ui/modify", method = RequestMethod.POST)
	public String updateCustomer(@ModelAttribute Customer customer) {
		service.updateCustomer(customer.getcId(), customer);
		return "redirect:/customers-ui";
	}

	@RequestMapping("/customers-ui/delete/{cid}")
	public String deleteCustomer(@PathVariable("cid") long cid) {
		service.deleteCustomer(cid);
		return "redirect:/customers-ui";
	}
}
