package com.bank.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.handlers.ResponseHandlers;
import com.bank.model.Customer;
import com.bank.model.ServiceResponse;
import com.bank.repository.CustomerRepository;

@RestController("/login")
public class LoginController {
	@Autowired
	CustomerRepository repository;
	
	@RequestMapping("/{customerId}/{password}")
	public ResponseEntity<ServiceResponse<Customer>> loginFunctionality(@PathVariable String customerId,@PathVariable String password){
		Customer customer=repository.findById(customerId).get();
		if(password.equals(customer.getPassword())) {
			return new ResponseHandlers().defaultResponse("login successful", HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseHandlers().defaultResponse("login unsuccessful", HttpStatus.UNAUTHORIZED);
		}
	}
}
