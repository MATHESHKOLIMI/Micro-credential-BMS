package com.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"com.bank.feign"})
public class LoginApplication {

	public static final Logger logger=LoggerFactory.getLogger(LoginApplication.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(LoginApplication.class, args);
	}

}
