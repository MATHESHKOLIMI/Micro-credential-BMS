package com.bank.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

@Configuration
public class FeignConfig {
	@Bean
	public Contract feignContract() {
		return new feign.Contract.Default();
	}
}
