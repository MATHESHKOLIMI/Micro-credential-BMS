package com.bank.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.handlers.ResponseHandlers;
import com.bank.model.Account;
import com.bank.model.Customer;
import com.bank.model.ServiceResponse;
import com.bank.service.ICustomerService;

@RestController
@RequestMapping(value = "/account")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse<Customer>> createCustomer(@RequestBody Customer customer){
		customerService.createCustomer(customer);
		return new ResponseHandlers<String>().defaultResponse("Customer created successfully. Use PAN for login.", HttpStatus.CREATED);
	}
	
	@PostMapping("/account")
	public ResponseEntity<ServiceResponse<String>> getCustomerByPAN(@RequestBody Account account){
		return new ResponseHandlers<String>().defaultResponse("Account Added Successfully.", HttpStatus.CREATED);
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse<Customer>> getCustomerDetails(@RequestHeader("pan") String pan){
		return new ResponseHandlers<Customer>().defaultResponse(customerService.getCustomer(pan),"Custer created successfully. Use PAN for login.", HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/purchase")
	public ResponseEntity<ServiceResponse<String>> purchaseMutualFund(@RequestHeader("pan") String pan, @RequestHeader("accountId") String accountId, @RequestHeader("mutualFundId") String mutualFundId){
		
		return new ResponseHandlers<String>().defaultResponse("Account Added Successfully.", HttpStatus.CREATED);
	}
	
	
/*
	@Autowired
	RegistrationServiceInterface register;
	
	@Autowired
	TransactionServiceInterface transaction;
	
	@GetMapping("/detail/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable String id){
		Customer customer=register.findCustomerById(id);
		
		if(customer==null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		else
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@GetMapping("/details/{PAN}")
	public ResponseEntity<Customer> getCustomerByPAN(@PathVariable String PAN){
		return new ResponseEntity<Customer>(register.findCustomerByPAN(PAN), HttpStatus.OK);
	}
	
	@PostMapping("/detail")
	public ResponseEntity<Customer> creeateCustomer(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(register.createCustomer(customer), HttpStatus.OK);
	}
	
	@PutMapping("/detail/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable String id,@RequestBody Customer customer){
		Customer cus=register.updateCustomer(id, customer);
		if(cus==null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		else
		return new ResponseEntity<Customer>(cus,HttpStatus.OK);
	}
	
	@PostMapping("/transaction")
	public ResponseEntity<Transaction> makeTransaction(@RequestBody Transaction trans){
		Transaction transaction1=transaction.createTransaction(trans);
		return new ResponseEntity<Transaction>(transaction1, HttpStatus.OK);
	}
	
	
	@GetMapping("/transaction/{accountNo}")
	public List<Transaction> getTransactinById(@PathVariable String accountNo){
		List<Transaction> tran=transaction.getAllTransactionByAccountNumber(accountNo);
		return tran;
	}
	
	@GetMapping("/transactions/{accountId}")
	public ResponseEntity<Transaction> getTransactionById(@PathVariable String accountId){
		return new ResponseEntity<Transaction>(transaction.getTransactionById(accountId),HttpStatus.OK);
	} */
}
