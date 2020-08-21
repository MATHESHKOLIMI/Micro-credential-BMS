package com.bank;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.bank.api.CustomerController;
import com.bank.feign.FeignConfig;
import com.bank.feign.IAccountController;
import com.bank.feign.IMutualFundController;
import com.bank.model.Account;
import com.bank.model.ServiceResponse;
import com.bank.model.Transaction;
import com.bank.service.ICustomerService;
import com.google.common.base.Predicates;

import cam.bank.feign.ITransactionFeign;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

//import com.bank.api.CustomerController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@EnableSwagger2
@SpringBootApplication
@Import(FeignConfig.class)
@EnableAutoConfiguration
public class CustomerServiceApplication {

	public static final Logger LOGGER=LoggerFactory.getLogger(CustomerServiceApplication.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	
	@Bean
	public IAccountController account() {
		return new IAccountController() {
			
			@Override
			public ResponseEntity<ServiceResponse<Account>> updateAccount(Account account) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ResponseEntity<ServiceResponse<List<Account>>> getAccount(String pan) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ResponseEntity<ServiceResponse<Integer>> countAccount(String pan) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ResponseEntity<ServiceResponse<Account>> addAccount(Account account) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
	
	@Bean
	public IMutualFundController mutualfund() {
		return new  IMutualFundController() {
			
			@Override
			public ResponseEntity<ServiceResponse<List<MutualFundMeta>>> searchMutualFund(String query) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ResponseEntity<ServiceResponse<MutualFund>> fetchMutaulFundDetails(String fund) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
	
	@Bean
	public ITransactionFeign transactionfeign() {
		return new ITransactionFeign() {
			
			@Override
			public ResponseEntity<ServiceResponse<Transaction>> makeTransaction(Account account, String mutualFund) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
	
}
