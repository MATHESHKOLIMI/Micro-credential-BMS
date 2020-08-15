package com.bank.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Account;
import com.bank.repository.AccountRepository;
import com.bank.repository.CustomerRepository;
import com.bank.service.AccountServiceInterface;

@Service
public class AccountServiceImplementation implements AccountServiceInterface{

	@Autowired
	AccountRepository repository;
	
	@Autowired
	CustomerRepository customer;
	
	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return repository.save(account);
	}

	@Override
	public List<Account> getAccounts(String customerId) {
		// TODO Auto-generated method stub
		return customer.findById(customerId).get().getAccounts();
	}

	@Override
	public Account getAccountDetails(String accountNo) {
		// TODO Auto-generated method stub
		return repository.findById(accountNo).get();
	}

}
