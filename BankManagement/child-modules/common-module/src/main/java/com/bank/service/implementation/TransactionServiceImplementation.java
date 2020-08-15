package com.bank.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Account;
import com.bank.model.Customer;
import com.bank.model.Transaction;
import com.bank.repository.AccountRepository;
import com.bank.repository.CustomerRepository;
import com.bank.repository.TransactionRepository;
import com.bank.service.TransactionServiceInterface;

@Service
public class TransactionServiceImplementation implements TransactionServiceInterface {

	@Autowired
	TransactionRepository repository;
	@Autowired
	CustomerRepository customer;
	
	@Autowired
	AccountRepository account;
	
	
	@Override
	public Transaction createTransaction(String customerId, String accountNo,Transaction transaction) {
		// TODO Auto-generated method stub
		Customer dummyCustomer=customer.findById(customerId).get();
		Account dummyAccount=account.findById(accountNo).get();
		List<Transaction> listTransaction=dummyAccount.getTransaction();
		listTransaction.add(transaction);
		dummyAccount.setTransaction(listTransaction);
		account.save(dummyAccount);
		dummyCustomer.getAccounts().forEach((p)->{if (p.getAccountNo()==accountNo) {
			List<Transaction> customerTransaction=p.getTransaction();
			customerTransaction.add(transaction);
			p.setTransaction(customerTransaction);
		}});
		customer.save(dummyCustomer);
		
		return repository.save(transaction);
	}

	@Override
	public List<Transaction> getAllTransactions() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Transaction getTransactionById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public List<Transaction> getAllTransactionByAccountNumber(String accountNo) {
		// TODO Auto-generated method stub
		return repository.findByAccountNo(accountNo);
	}

}