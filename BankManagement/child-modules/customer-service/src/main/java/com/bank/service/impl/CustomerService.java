package com.bank.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bank.exception.BankException;
import com.bank.model.Customer;
import com.bank.repository.CustomerRepository;
import com.bank.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void createCustomer(Customer cust) {
		throw new BankException( HttpStatus.BAD_REQUEST, "Customer already there.");
		/*
		 * if(!isDuplicateCustomer(cust.getCustomerPAN())) { throw new BankException(
		 * "Customer already there."); //customerRepository.save(cust); }
		 */
	}

	public boolean isDuplicateCustomer(String pan) {
		return customerRepository.findFirstByCustomerPAN(pan)
				.map(cust-> !Objects.isNull(cust))
				.orElseThrow(()-> new BankException("Customer already there."));
				
	}
}
