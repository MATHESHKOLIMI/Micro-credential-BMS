package com.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan;

import com.bank.api.CustomerController;
import com.bank.service.ICustomerService;

//import com.bank.api.CustomerController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@EnableSwagger2
@ComponentScan("com.bank.feign")
@SpringBootApplication
public class CustomerServiceApplication {

	public static final Logger LOGGER=LoggerFactory.getLogger(CustomerServiceApplication.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

}
