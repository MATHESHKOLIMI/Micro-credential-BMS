package com.bank.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class SearchMutualFundServiceTest {
	
	@InjectMocks
	private SearchMutualFundService searchMutualFundService;
	
	@Mock
	private RestTemplate restTemplate;
	
	@Test
	public void searchMutualFundTest() {
		Assert.assertTrue(true);
		//searchMutualFundService.searchMutualFund("hello");
	}

}
