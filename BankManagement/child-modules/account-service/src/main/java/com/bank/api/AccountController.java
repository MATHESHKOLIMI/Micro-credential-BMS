package com.bank.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.feign.IAccountController;
import com.bank.handlers.ResponseHandlers;
import com.bank.model.Account;
import com.bank.model.ServiceResponse;
import com.bank.service.IAccountService;

@RestController
@RequestMapping(value="/account")
public class AccountController implements IAccountController{

	@Autowired
	IAccountService service;
	
	@Override
	public ResponseEntity<ServiceResponse<Account>> addAccount(Account account) {
		
		return new ResponseHandlers<Account>().defaultResponse(service.addAccount(account), "Account added successfully.", HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ServiceResponse<Integer>> countAccount(String pan) {
		return new ResponseHandlers<Integer>().defaultResponse(service.countAccount(pan));
	}

	@Override
	public ResponseEntity<ServiceResponse<List<Account>>> getAccount(String pan) {
		return new ResponseHandlers<List<Account>>().defaultResponse(service.getAccounts(pan));
	}

	@Override
	public ResponseEntity<ServiceResponse<Account>> updateAccount(Account account) {
		return new ResponseHandlers<Account>().defaultResponse(service.updateAccount(account), "Account updated successfully.");
	}
	
}
