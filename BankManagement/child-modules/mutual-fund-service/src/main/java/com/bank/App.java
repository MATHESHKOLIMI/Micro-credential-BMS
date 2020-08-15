package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages= {"com.bank"})
public class App 
{
	public static void main( String[] args )
	{
		SpringApplication.run(App.class, args);
	}
}
