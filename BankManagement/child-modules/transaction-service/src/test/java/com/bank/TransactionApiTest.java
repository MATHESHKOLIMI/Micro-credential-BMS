package com.bank;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.bank.api.TransactionApi;
import com.bank.config.BanksProperties.Bank;
import com.bank.model.ServiceResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = { "spring.config.location=classpath:application.yml" })
public class TransactionApiTest {
	
	@Autowired
	TransactionApi transactionApi;
	
	@Test
	public void getBanksTest() {
		ResponseEntity<ServiceResponse<List<String>>> activeBanks = transactionApi.getBanks();
		List<String> banks = activeBanks.getBody().getData();
		assertTrue(banks.size()>0);
		assertTrue(banks.contains("HDFC"));
	}

	
	@Test
	public void getBanksDetailsTest() {
		ResponseEntity<ServiceResponse<List<Bank>>> activeBanks = transactionApi.getBanksDetails();
		List<Bank> banks = activeBanks.getBody().getData();
		assertTrue(banks.size()>0);
		assertTrue(
					banks.stream()
						.map(m->m.getName())
						.collect(Collectors.toList())
						.contains("HDFC")
				);
	}
}
