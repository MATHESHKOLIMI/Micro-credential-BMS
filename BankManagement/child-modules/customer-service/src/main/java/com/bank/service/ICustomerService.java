package com.bank.service;

import com.bank.model.Account;
import com.bank.model.Customer;

public interface ICustomerService {
	void createCustomer(Customer cust);
	void addAccount(Account account);
	Customer getCustomer(String pan);
	
	void purchaseMutualFund(String pan, String accountId,  String mutualFundId);
}
