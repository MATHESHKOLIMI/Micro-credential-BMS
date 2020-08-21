package com.bank.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.bank.MutualFundMeta;
import com.bank.model.ServiceResponse;
import com.bank.service.ISearchMutualFundService;

public class MutualFundControllerTest {
	
	@Autowired
	MutualFundController controller;
	
	@MockBean
	ISearchMutualFundService service;

	private String query="LIC MF Index Fund-Sensex Advantage-Dividend";

	MutualFundMeta meta;
	
	@Before
	 public void setup() {
		meta=meta.builder().fundHouse("Lic").schemeName("Insurance").schemeCode(231342).schemeCategory("Insurence").schemeType("open").build();
	}

	@Test
	public void testSearchMutualFund() throws NullPointerException {
//		fail("Not yet implemented");
		when(service.searchMutualFund(query)).thenReturn(Arrays.asList(meta));
		ResponseEntity<ServiceResponse<List<MutualFundMeta>>> response=controller.searchMutualFund(query);
		assertEquals(1, controller.searchMutualFund(query).getBody().getData().size());
	
	}

	@Test
	public void testFetchMutaulFundDetails() {
//		fail("Not yet implemented");
	}

}
