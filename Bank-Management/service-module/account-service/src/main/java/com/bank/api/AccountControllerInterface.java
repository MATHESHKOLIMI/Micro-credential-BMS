package com.bank.api;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bank.model.Account;

@FeignClient(name = "bankservice", url = "localhost:9000")
public interface AccountControllerInterface {
	
	@GetMapping("/account/{id}")
	public List<Account> getAccountOfCustomer(@PathVariable String id);
	
	@PostMapping("/account")
	public Account createAccount(@RequestBody Account account);
	
	@GetMapping("/account")
	public Account getAccountDetails(@PathParam(value = "accountNo") String accountNo);
}
