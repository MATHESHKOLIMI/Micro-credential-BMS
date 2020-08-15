package com.bank.service;

import java.util.List;

import com.bank.model.Account;

public interface AccountServiceInterface {

	Account createAccount(Account account);

	List<Account> getAccounts(String customerId);

	Account getAccountDetails(String accountNo);

}
