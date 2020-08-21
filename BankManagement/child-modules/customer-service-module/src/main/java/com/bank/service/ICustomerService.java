package com.bank.service;

import org.springframework.stereotype.Service;

import com.bank.model.Account;
import com.bank.model.Customer;

@Service
public interface ICustomerService {
	void createCustomer(Customer cust);
	void addAccount(Account account);
	Customer getCustomer(String pan);
	
	void purchaseMutualFund(String pan, String accountId,  String mutualFundId);
}
