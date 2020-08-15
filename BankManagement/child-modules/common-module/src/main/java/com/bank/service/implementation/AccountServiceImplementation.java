package com.bank.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.exception.BankException;
import com.bank.model.Account;
import com.bank.model.Customer;
import com.bank.repository.AccountRepository;
import com.bank.repository.CustomerRepository;
import com.bank.service.AccountServiceInterface;

@Service
public class AccountServiceImplementation implements AccountServiceInterface{

	@Autowired
	AccountRepository repository;
	
	
	@Autowired
	CustomerRepository customer;
	
	@Override
	public Account createAccount(String id,Account account) {
		// TODO Auto-generated method stub
		Optional<Account> duplicateAccount=repository.findById(account.getAccountNo());
		if(duplicateAccount.isPresent()) {
			throw new BankException("Bank Account already present");
		}
		else if(customer.findById(id).get().getAccounts().size()>=4){
			throw new BankException("Maximum accounts reached");	
		}
		else {			
			Customer updateCustomer=customer.findById(id).get();
			List<Account> listAccounts=updateCustomer.getAccounts();
			listAccounts.add(account);
			updateCustomer.setAccounts(listAccounts);
			customer.save(updateCustomer);
			return repository.save(account);
		}
	}

	@Override
	public List<Account> getAccounts(String customerId) {
		// TODO Auto-generated method stub
		List<Account> Accounts=customer.findById(customerId).get().getAccounts();
		Accounts.forEach((p)->{p.setTransaction(null);});
		return Accounts;
	}

	@Override
	public Account getAccountDetails(String accountNo) {
		// TODO Auto-generated method stub
		Account dummyAccount=repository.findById(accountNo).get();
		if(dummyAccount!=null) {
		dummyAccount.setTransaction(null);
		return dummyAccount;
		}
		else {
			throw new BankException("account number is not valid or not found");
		}
	}

}











