package com.bank.service.impl;

import java.util.Objects;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.exception.BankException;
import com.bank.feign.IAccountController;
import com.bank.feign.IMutualFundController;
import com.bank.model.Account;
import com.bank.model.Customer;
import com.bank.model.Transaction;
import com.bank.repository.CustomerRepository;
import com.bank.service.ICustomerService;

import cam.bank.feign.ITransactionFeign;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private IAccountController accountFeign;

	@Autowired
	private IMutualFundController mutualFundFeign;
	
	@Autowired
	private ITransactionFeign transactionFeign;

	@Override
	public void createCustomer(Customer cust) {

		if(!isDuplicateCustomer(cust.getCustomerPAN())) { 
			customerRepository.save(cust);
		}
	}

	public boolean isDuplicateCustomer(String pan) {
		return customerRepository.findFirstByCustomerPAN(pan)
				.map(cust-> !Objects.isNull(cust))
				.orElseThrow(()-> new BankException("Customer already there."));

	}

	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getCustomer(String pan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void purchaseMutualFund(String pan, String accountId, String mutualFundId) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void addAccount(Account account) {
//		if(accountFeign.countAccount(account.getOwnerId()).getBody().getData()<4) {
//			accountFeign.addAccount(account);
//		}
//
//	}
//
//	@Override
//	public Customer getCustomer(String pan) {
//		Customer customer = customerRepository.findByCustomerPAN(pan)
//				.filter(Objects::nonNull)
//				.orElseThrow(()-> new BankException("Customer not found."));
//		customer.setAccounts(accountFeign.getAccount(pan).getBody().getData());
//		return customer;
//	}
//
//	@Override
//	public void purchaseMutualFund(String pan, String accountId,  String mutualFundId) {
//		Account transactionAccount = Optional.ofNullable(accountFeign.getAccount(pan).getBody().getData())
//				.filter(Objects::nonNull)
//				.filter(CollectionUtils::isNotEmpty)
//				.orElseThrow(()-> new BankException("Account no not found."))
//				.stream()
//				.filter(account-> pan.equalsIgnoreCase(account.getOwnerId()))
//				.findFirst().get();
//
//		Integer mutualFundToInvest = Optional.ofNullable(mutualFundFeign.fetchMutaulFundDetails(mutualFundId).getBody().getData())
//				.filter(Objects::nonNull)
//				.orElseThrow(()-> new BankException("No Mutual fund to invest.")).getMeta().getSchemeCode();
//
//		Transaction successfulTransaction = Optional.ofNullable(transactionFeign.makeTransaction(transactionAccount, mutualFundToInvest.toString()).getBody().getData())
//					.filter(Objects::nonNull)
//					.orElseThrow(()-> new BankException("Transaction was not successful."));
//		
//		transactionAccount.getTransaction().add(successfulTransaction);
//		
//		accountFeign.updateAccount(transactionAccount);
//	}



}
