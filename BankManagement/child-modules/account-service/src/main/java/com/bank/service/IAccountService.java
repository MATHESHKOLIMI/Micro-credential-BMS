package com.bank.service;

import java.util.List;

import com.bank.model.Account;

public interface IAccountService {
	Account addAccount(Account account);
	
	Integer countAccount(String pan);
	
	List<Account> getAccounts(String pan);
	
	Account updateAccount(Account account);
}
