package com.bank.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bank.feign.AccountControllerFallBack;
import com.bank.feign.FeignConfig;
import com.bank.model.Account;
import com.bank.model.ServiceResponse;

@FeignClient(name="accountservice",configuration = FeignConfig.class,fallbackFactory =AccountControllerFallBack.class )
@RestController
public interface IAccountController {

	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse<Account>> addAccount(@RequestBody Account account);
	
	
	@GetMapping(value="/{pan}/count")
	public ResponseEntity<ServiceResponse<Integer>> countAccount(@PathVariable("pan") String pan);
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse<List<Account>>> getAccount(@RequestHeader("pan") String pan);
	
	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse<Account>> updateAccount(@RequestBody Account account);
}



/*
@FeignClient(name = "hello", fallbackFactory = HystrixClientFallbackFactory.class)
protected interface HystrixClient {
	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	Hello iFailSometimes();
}
@Component
static class HystrixClientFallbackFactory implements FallbackFactory<HystrixClient> {
	@Override
	public HystrixClient create(Throwable cause) {
		return new HystrixClient() {
			@Override
			public Hello iFailSometimes() {
				return new Hello("fallback; reason was: " + cause.getMessage());
			}
		};
	}
}
*/
















 	 	