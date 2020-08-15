package com.bank.service;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class SearchMutualFundServiceTest {
	
	@InjectMocks
	private SearchMutualFundService searchMutualFundService;
	
	@Mock
	private RestTemplate restTemplate;
	
	public void searchMutualFundTest() {
		searchMutualFundService.searchMutualFund("hello");
	}

}
