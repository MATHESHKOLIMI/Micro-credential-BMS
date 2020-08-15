package com.bank.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.bank.feign.IAccountController;
import com.bank.model.Account;
import com.bank.model.ServiceResponse;

@RestController
public class AccountController implements IAccountController{

	@Override
	public ResponseEntity<ServiceResponse<Account>> addAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

}
