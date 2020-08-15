package com.bank.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bank.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{
	Optional<Customer> findFirstByCustomerPAN(String pan);
}
