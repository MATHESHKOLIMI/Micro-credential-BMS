//package com.bank.api;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bank.handlers.ResponseHandlers;
//import com.bank.model.Account;
//import com.bank.model.Customer;
//import com.bank.model.ServiceResponse;
//import com.bank.service.ICustomerService;
//
//@RestController
//@RequestMapping("/customer")
//public class CustomerAPI {
//	@Autowired
//	private ICustomerService customerService;
//	
//	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<ServiceResponse<Customer>> createCustomer(@RequestBody Customer customer){
//		customerService.createCustomer(customer);
//		return new ResponseHandlers<String>().defaultResponse("Customer created successfully. Use PAN for login.", HttpStatus.CREATED);
//	}
//	
//	@PostMapping("/account")
//	public ResponseEntity<ServiceResponse<String>> getCustomerByPAN(@RequestBody Account account){
//		return new ResponseHandlers<String>().defaultResponse("Account Added Successfully.", HttpStatus.CREATED);
//	}
//	
//	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<ServiceResponse<Customer>> getCustomerDetails(@RequestHeader("pan") String pan){
//		return new ResponseHandlers<Customer>().defaultResponse(customerService.getCustomer(pan),"Custer created successfully. Use PAN for login.", HttpStatus.CREATED);
//	}
//	
//	@PostMapping(value = "/purchase")
//	public ResponseEntity<ServiceResponse<String>> purchaseMutualFund(@RequestHeader("pan") String pan, @RequestHeader("accountId") String accountId, @RequestHeader("mutualFundId") String mutualFundId){
//		
//		return new ResponseHandlers<String>().defaultResponse("Account Added Successfully.", HttpStatus.CREATED);
//	}
//}
//
//
//
//
//
//
//
//
//
//
//
//
