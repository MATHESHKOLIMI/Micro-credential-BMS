package com.bank.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.bank.MutualFundMeta;
import com.bank.model.ServiceResponse;

@RunWith(MockitoJUnitRunner.class)
public class MutualFundControllerTest {
	
	private MutualFundController mutualFundController;
	
	@Test
	public void searchMutualFundTest() {
		ResponseEntity<ServiceResponse<List<MutualFundMeta>>> searchMutualFund = mutualFundController.searchMutualFund(null);
	}

}
