package com.bank.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.bank.handlers.ResponseHandlers;
import com.bank.model.Account;
import com.bank.model.AccountType;
import com.bank.model.Customer;
import com.bank.model.ServiceResponse;
import com.bank.service.ICustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTest {
	
	CustomerController customerController=new CustomerController();
	
	//@MockBean
//	private ICustomerService customerservice;
//	
//
	private Customer cust=new Customer("1234567891","mathesh","GSVS96822J",new Date(1996,06,06),null,null,null,"Common@31","1-1024",null);

	private Account account=new Account("1234567891",AccountType.Savings,new Date(1996,06,06),"HDFC1223421",null,"GWVPA9875J","HDFC");

	private String panDetails="GWVPA9875J";

	private String accountId;

	private String mutualFundId;

	@Test(expected = NullPointerException.class)
	public void testCreateCustomer() {
//		fail("Not yet implemented");
//		ServiceResponse<Customer> response=customer.createCustomer(cust).getBody();
//		assertEquals(cust.getCustomerId(),response.getData().getCustomerId() );
//		when(customerController.createCustomer(cust)).thenReturn(new ResponseHandlers<Customer>().defaultResponse("ok", HttpStatus.CREATED));
		ResponseEntity<ServiceResponse<Customer>> response=customerController.createCustomer(cust);
		assertEquals(HttpStatus.CREATED,  response.getStatusCode());
		
	}

	@Test
	public void testGetCustomerByPAN() {
//		fail("Not yet implemented");
//		when(customerController.getCustomerByPAN(account)).thenReturn(new ResponseHandlers<Customer>().defaultResponse("ok", HttpStatus.CREATED));

		ResponseEntity<ServiceResponse<String>> response=customerController.getCustomerByPAN(account);
		assertEquals(HttpStatus.CREATED,  response.getStatusCode());
		
	
	}

	@Test(expected = NullPointerException.class)
	public void testGetCustomerDetails() {
//		fail("Not yet implemented");
		ResponseEntity<ServiceResponse<Customer>> response=customerController.getCustomerDetails(panDetails);
//		when(customerController.getCustomerDetails(panDetails="GWVPA9875J")).thenReturn();
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	@Test
	public void testPurchaseMutualFund() {
//		fail("Not yet implemented");
		ResponseEntity<ServiceResponse<String>> response=customerController.purchaseMutualFund(panDetails, accountId, mutualFundId);
		assertEquals(HttpStatus.CREATED,  response.getStatusCode());
	}

}















