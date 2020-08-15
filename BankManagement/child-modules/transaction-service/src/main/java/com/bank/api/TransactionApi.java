package com.bank.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.config.BanksProperties;
import com.bank.config.BanksProperties.Bank;
import com.bank.handlers.ResponseHandlers;
import com.bank.model.ServiceResponse;
import com.bank.service.TransactionService;

@RestController
public class TransactionApi {

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
	
	/*@RequestMapping(value="/transaction", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse<Payment>> makeTransaction(@RequestBody Payment payment) {
		Payment checkPayment = transactionService.checkPayment(payment);
		return new ResponseHandlers<Payment>().defaultResponse(checkPayment);
	}*/
}
