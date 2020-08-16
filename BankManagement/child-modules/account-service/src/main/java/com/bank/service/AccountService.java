package com.bank.service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Account;
import com.bank.repository.IAccountRepository;

@Service
public class AccountService implements IAccountService {

	@Autowired
	IAccountRepository repository;
	
	@Override
	public Account addAccount(Account accont) {
		return repository.save(accont);
	}

	@Override
	public Integer countAccount(String pan) {
		return repository.findByOwnerId(pan).filter(Objects::nonNull).orElse(Collections.emptyList()).size();
	}

	@Override
	public List<Account> getAccounts(String pan) {
		return repository.findByOwnerId(pan).filter(Objects::nonNull).orElse(Collections.emptyList());
	}

	@Override
	public Account updateAccount(Account account) {
		return repository.save(account);
	}

}
