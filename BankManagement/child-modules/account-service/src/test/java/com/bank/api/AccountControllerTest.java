package com.bank.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.bank.model.Account;
import com.bank.model.AccountType;
import com.bank.model.Payment;
import com.bank.model.Payment.Failure;
import com.bank.model.Payment.Success;
import com.bank.model.ServiceResponse;
import com.bank.model.Status;
import com.bank.model.Transaction;
import com.bank.service.IAccountService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountControllerTest {
	
	@Autowired
	AccountController accountController;
	
	@MockBean
	IAccountService service;
	
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
//	Account account;
	@Test
	public void testAddAccount() {

		//		fail("Not yet implemented");
//		when(accountController.addAccount(account)).thenReturn(account);
		when(service.addAccount(account)).thenReturn(account);
//		when(accountController.addAccount(account)).thenReturn(new ResponseEntity<ServiceResponse<Account>>(HttpStatus.CREATED));
		ResponseEntity<ServiceResponse<Account>> response=accountController.addAccount(account);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	@Test
	public void testCountAccount() {
//		fail("Not yet implemented");
		when(service.countAccount(pan)).thenReturn(1);
		assertEquals(new Integer(1), accountController.countAccount(pan).getBody().getData());
	}

	@Test
	public void testGetAccount() {
//		fail("Not yet implemented");
		when(service.getAccounts(pan)).thenReturn(Arrays.asList(account));
		assertEquals(Arrays.asList(account), accountController.getAccount(pan).getBody().getData());
	}

	@Test
	public void testUpdateAccount() {
//		fail("Not yet implemented");
		when(service.updateAccount(account)).thenReturn(account);
		assertEquals(account, accountController.updateAccount(account).getBody().getData());
	}

}











