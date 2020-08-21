package com.bank.service.impl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;

import com.bank.feign.IAccountController;
import com.bank.model.Customer;
import com.bank.repository.CustomerRepository;

import cam.bank.feign.ITransactionFeign;

public class CustomerServiceTest {
	
	@Autowired
	CustomerService service;
	
	@MockBean
	CustomerRepository repository;
	
	@MockBean
	IAccountController account;
	
//	@MockBean
//	IMutualFundController mutualFund;
	
	@MockBean
	ITransactionFeign transaction;

	private static Customer cust;
	
	@BeforeClass
	public static void setup() {
		cust=cust.builder().customerId("8443133101").customerName("Mathesh").customerMail("").customerPAN("").dateOfBirth(new Date(1998,06,06)).address("").build();
	}


	@Test//(expected = NullPointerException.class)
	public void testCreateCustomer() {
//		fail("Not yet implemented");
////	fail("Not yet implemented");
//	doAnswer((i)->{assertTrue("8443133101".equals(i.getArgument(0))); return null;}).when(cust).setCustomerId(any("h"));
	Customer customer=repository.save(cust);
	assertEquals("8443133101", customer.getCustomerId());
	}

	@Test
	public void testAddAccount() {
//		fail("Not yet implemented");
	}

	@Test
	public void testGetCustomer() {
//		fail("Not yet implemented");
	}

}

//package com.bank.service.impl;
//
//import static org.hamcrest.CoreMatchers.any;
//import static org.hamcrest.CoreMatchers.anything;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.doAnswer;
//import static org.mockito.Mockito.when;
//
//import java.util.Date;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.bank.feign.IAccountController;
//import com.bank.feign.IMutualFundController;
//import com.bank.model.Customer;
//import com.bank.repository.CustomerRepository;
//import com.bank.service.ICustomerService;
//import com.fasterxml.jackson.databind.Module.SetupContext;
//
//import cam.bank.feign.ITransactionFeign;
//
//class CustomerServiceTest {
//
//	@Autowired
//	CustomerService service;
//	
//	@MockBean
//	CustomerRepository repository;
//	
//	@MockBean
//	IAccountController account;
//	
//	@MockBean
//	IMutualFundController mutualFund;
//	
//	@MockBean
//	ITransactionFeign transaction;
//
//	private Customer cust;
//	
//	@Before
//	public void setUp() {
//		cust=cust.builder().customerId("8443133101").customerName("Mathesh").customerMail("").customerPAN("").dateOfBirth(new Date(1998,06,06)).address("").build();
//	}
//
//	@Test
//	void testCreateCustomer() {
////		fail("Not yet implemented");
////		doAnswer((i)->{assertTrue("8443133101".equals(i.getArgument(0))); return null;}).when(cust).setCustomerId(any("h"));
//		Customer customer=repository.save(cust);
//		assertEquals("8443133101", customer.getCustomerId());
//	}
//
//
//	@Test
//	void testAddAccount() {
////		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCustomer() {
////		fail("Not yet implemented");
//	}
//
//
//}
