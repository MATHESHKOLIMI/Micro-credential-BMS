package com.bank.api;

import org.springframework.http.ResponseEntity;

import com.bank.feign.IAccountController;
import com.bank.model.Account;
import com.bank.model.ServiceResponse;

public class AccountController implements IAccountController{

	@Override
	public ResponseEntity<ServiceResponse<Account>> addAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

}
