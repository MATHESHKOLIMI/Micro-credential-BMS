package com.bank.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.config.BanksProperties;
import com.bank.handlers.ResponseHandlers;
import com.bank.model.Account;
import com.bank.model.Bank;
import com.bank.model.Payment;
import com.bank.model.ServiceResponse;
import com.bank.model.Transaction;
import com.bank.service.TransactionService;

import cam.bank.ITransactionFeign;

@RestController
public class TransactionApi implements ITransactionFeign {

	@Autowired
	BanksProperties banksProperties;
	
	@Autowired
	TransactionService transactionService;
	
	@RequestMapping(value="/active-banks", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse<List<String>>> getBanks() {
		return new ResponseHandlers<List<String>>().defaultResponse(banksProperties.getActiveBanks());
		
	}

	@RequestMapping(value="/active-banks-details", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse<List<Bank>>> getBanksDetails() {
		return new ResponseHandlers<List<Bank>>().defaultResponse(banksProperties.getBanks());
	}
	
	@Override
	public ResponseEntity<ServiceResponse<Transaction>> makeTransaction(Account account, String mutualFund) {
		Payment payment = transactionService.checkPayment(account);
		return new ResponseHandlers<Transaction>().defaultResponse(Transaction.builder().mutualFund(mutualFund).payment(payment).build(), "Purchase successful.");
	}
}
