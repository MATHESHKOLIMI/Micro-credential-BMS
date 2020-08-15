package com.bank.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
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
