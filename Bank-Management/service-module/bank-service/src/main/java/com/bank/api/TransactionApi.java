package com.bank.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Transaction;
import com.bank.service.TransactionServiceInterface;

@RestController
public class TransactionApi {
	
	@Autowired
	TransactionServiceInterface transaction;

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
	
	@GetMapping("/transaction/{accountId}")
	public ResponseEntity<Transaction> getTransactionById(@PathVariable String accountId){
		return new ResponseEntity<Transaction>(transaction.getTransactionById(accountId),HttpStatus.OK);
	}
}
