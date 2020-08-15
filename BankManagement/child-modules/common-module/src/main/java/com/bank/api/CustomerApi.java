package com.bank.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.exception.BankException;
import com.bank.model.Customer;
import com.bank.model.Transaction;
import com.bank.service.CustomerServiceInterface;
import com.bank.service.TransactionServiceInterface;

@RestController
public class CustomerApi {
	
	@Autowired
	CustomerServiceInterface register;
	
	@Autowired
	TransactionServiceInterface transaction;
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable String id){
		Customer customer=register.findCustomerById(id);
		if(customer!=null) {
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}
		else {
			throw new BankException(HttpStatus.NOT_FOUND, "no Customer is found");
		}
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> creeateCustomer(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(register.createCustomer(customer), HttpStatus.OK);
	}
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable String id,@RequestBody Customer customer){
		Customer cus=register.updateCustomer(id, customer);
		if(cus==null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		else
		return new ResponseEntity<Customer>(cus,HttpStatus.OK);
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable String id){
		Customer cus=register.findCustomerById(id);
		if(cus!=null) {
			register.deleteCustomer(id);
			return new ResponseEntity<Customer>(HttpStatus.OK);
		}
		else {
		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
	}
	
}










