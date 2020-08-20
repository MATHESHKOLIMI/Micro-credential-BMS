package com.bank.feign;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bank.feign.IAccountController;
import com.bank.handlers.ResponseHandlers;
import com.bank.model.Account;
import com.bank.model.ServiceResponse;

import feign.hystrix.FallbackFactory;

public class AccountControllerFallBack implements FallbackFactory<IAccountController> {

	@Override
	public IAccountController create(Throwable cause) {
		// TODO Auto-generated method stub
		return new IAccountController() {
			
			@Override
			public ResponseEntity<ServiceResponse<Account>> updateAccount(Account account) {
				// TODO Auto-generated method stub
				return new ResponseHandlers().defaultResponse("it is now handled by hystrix"+cause.getMessage(), HttpStatus.CONTINUE);
			}
			
			@Override
			public ResponseEntity<ServiceResponse<List<Account>>> getAccount(String pan) {
				// TODO Auto-generated method stub
				 return new ResponseHandlers().defaultResponse("it is now handled by hystrix"+cause.getMessage(), HttpStatus.CONTINUE);
			}
			
			@Override
			public ResponseEntity<ServiceResponse<Integer>> countAccount(String pan) {
				// TODO Auto-generated method stub
				 return new ResponseHandlers().defaultResponse("it is now handled by hystrix"+cause.getMessage(), HttpStatus.CONTINUE);
			}
			
			@Override
			public ResponseEntity<ServiceResponse<Account>> addAccount(Account account) {
				// TODO Auto-generated method stub
				return new ResponseHandlers().defaultResponse("it is now handled by hystrix"+cause.getMessage(), HttpStatus.CONTINUE);
			}
		};
	}

}
