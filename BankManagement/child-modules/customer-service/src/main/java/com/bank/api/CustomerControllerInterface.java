package com.bank.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bank.model.Customer;

@FeignClient(name = "commonmodule", url = "localhost:9000")
public interface CustomerControllerInterface {
	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody Customer customer);
	
	@GetMapping("/customer/{customerId}")
	public Customer getCustomerById(@PathVariable String customerId);
	
	@PutMapping("/customer/{customerId}")
	public Customer updateCustomerById(@PathVariable String customerId,@RequestBody Customer customer);
}