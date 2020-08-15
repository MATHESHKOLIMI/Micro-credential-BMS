package com.bank.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bank.MutualFund;
import com.bank.MutualFundMeta;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SearchMutualFundService implements ISearchMutualFundService {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper objectMapper; 
	
	private HttpEntity<String> entity;
	
	@Value("${mutual.fund.search.url}")
	private String SEARCH_URL;
	
	@Value("${mutual.fund.detail.url}")
	private String FETCH_DTLS_URL;
	
	@PostConstruct
	void setUp() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		entity = new HttpEntity<String>("parameters", headers);
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));        
		messageConverters.add(converter); 
		restTemplate.setMessageConverters(messageConverters); 
	}
	
	@Override
	public List<MutualFundMeta> searchMutualFund(String query) {
		List<MutualFundMeta> mutualFunds = Collections.emptyList();
		ResponseEntity<List<MutualFundMeta>> exchange = restTemplate.exchange(SEARCH_URL+query, HttpMethod.GET, entity, new ParameterizedTypeReference<List<MutualFundMeta>>() { });
		if(exchange.getStatusCode().is2xxSuccessful()) {
			mutualFunds = exchange.getBody();
		}
		return mutualFunds;
	}

	@Override
	public MutualFund fetchMutaulFundDtls(String fund) {
		MutualFund mutualFund = MutualFund.builder().build();
		ResponseEntity<MutualFund> exchange = restTemplate.exchange(FETCH_DTLS_URL.replaceAll("<FUND_ID>", fund), HttpMethod.GET, entity, MutualFund.class);
		if(exchange.getStatusCode().is2xxSuccessful()) {
			mutualFund = exchange.getBody();
		}
		return mutualFund;
	}
	
}
