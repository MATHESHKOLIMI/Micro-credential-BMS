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

@RestController
public class AccountApi {
	
	@Autowired
	AccountControllerInterface accountController;
	
	@GetMapping("/account/{id}")
	public List<Account> getAccountOfCustomer(@PathVariable String id) {
		return accountController.getAccountOfCustomer(id);
	}
	
	@PostMapping("/account")
	public Account createAccount(@RequestBody Account account) {
		return accountController.createAccount(account);
	}
	
	@GetMapping("/account")
	public Account getAccountInfo(@PathParam(value = "accountNo") String accountNo) {
		return accountController.getAccountDetails(accountNo);
	}
}
