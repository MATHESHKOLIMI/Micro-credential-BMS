package com.bank.api;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Account;
import com.bank.service.AccountServiceInterface;

@RestController
public class AccountApi {

	@Autowired
	AccountServiceInterface accountservice;
	
	@PostMapping("/account")
	public Account createAccount(@RequestBody Account account) {
		return accountservice.createAccount(account);
	}
	
	@GetMapping("/account/{customerId}")
	public List<Account> getAccountsOfTheCustomer(@PathVariable String customerId) {
		return accountservice.getAccounts(customerId);
	}
	
	@GetMapping("/account")
	public Account getAccountDetails(@PathParam(value = "accountNo") String accountNo) {
		return accountservice.getAccountDetails(accountNo);
	}
}












