package com.bank.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bank.model.Account;
import com.bank.model.AccountType;
import com.bank.model.Payment;
import com.bank.model.Status;
import com.bank.model.Transaction;
import com.bank.model.Payment.Failure;
import com.bank.model.Payment.Success;
import com.bank.repository.IAccountRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {
	
	@MockBean
	IAccountRepository repository;
	
	@Autowired
	AccountService accountservice;

	AccountType accountType;
	Date date=new Date(2020,8,11);
	Status status;

	private Success success=new Success(101231, "succeed");

	private Failure failure;

	private String bankName="Hdfc";

	private Payment payment=new Payment(success, failure, bankName);
	Transaction trans=new Transaction("55555555555","1234567891","1234567777",status.Credit,10.8,"to ",date,payment,"mutual");
	Account account=new Account("1234567891",accountType.Savings,null,"HDFC1133211",Arrays.asList(trans),"9876543210","Hdfc");

	private String pan="9876543210";
	
	@Test
	public void testAddAccount() {
//		fail("Not yet implemented");
		when(repository.save(account)).thenReturn(account);
		assertEquals(account, accountservice.addAccount(account));
	}

	@Test
	public void testCountAccount() {
//		fail("Not yet implemented");
//		when(repository.findByOwnerId(pan).get().size()).thenReturn(new Integer(1));
//		assertEquals(new Integer(1), accountservice.countAccount(pan));
	}

	@Test
	public void testGetAccounts() {
//		fail("Not yet implemented");
//		when(repository.findByOwnerId(pan).get()).thenReturn(Arrays.asList(account));
//		assertEquals(Arrays.asList(account), accountservice.getAccounts(pan));
	}

	@Test
	public void testUpdateAccount() {
//		fail("Not yet implemented");
		when(repository.save(account)).thenReturn(account);
		assertEquals(account, accountservice.addAccount(account));
	}

}













