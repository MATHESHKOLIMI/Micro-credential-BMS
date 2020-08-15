package com.bank.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bank.model.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
	public List<Transaction> findByAccountNo(String accountNumber);
}