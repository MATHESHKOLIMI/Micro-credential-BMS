package com.bank.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Customer;

@RestController
public class CustomerApi {
	@Autowired
	CustomerControllerInterface customerController;
	
	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerController.createCustomer(customer);
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomerDetails(@PathVariable String id) {
		return customerController.getCustomerById(id);
	}
	
	@PutMapping("/customer/{id}")
	public Customer updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
		return customerController.updateCustomerById(id, customer);
	}
}