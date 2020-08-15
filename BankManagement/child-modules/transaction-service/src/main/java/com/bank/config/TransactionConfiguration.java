package com.bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages= {
								"com.bus",
								"com.bus.transaction.api",
								"com.bus.transaction.configuration",
								"com.bus.transaction.service"
		})
public class TransactionConfiguration {
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
