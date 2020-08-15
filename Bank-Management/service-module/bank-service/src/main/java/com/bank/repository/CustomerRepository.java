package com.bank.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bank.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	public Customer findByCustomerPAN(String customerPAN);
}