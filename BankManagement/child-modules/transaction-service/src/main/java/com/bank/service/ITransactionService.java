package com.bank.service;

import org.springframework.stereotype.Service;

import com.bank.model.Account;
import com.bank.model.Payment;

@Service
public interface ITransactionService {

	Payment checkPayment(Account account);
	
}
