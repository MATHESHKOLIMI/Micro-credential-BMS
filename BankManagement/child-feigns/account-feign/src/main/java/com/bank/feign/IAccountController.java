package com.bank.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bank.model.Account;
import com.bank.model.ServiceResponse;

@FeignClient(name="account", configuration = FeignConfig.class)
public interface IAccountController {

	@PostMapping("/detail")
	public ResponseEntity<ServiceResponse<Account>> addAccount(@RequestBody Account account);
}
