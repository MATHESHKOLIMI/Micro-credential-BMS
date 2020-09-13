package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages= {"com.bank.feign"})
public class CustomerApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(CustomerApp.class, args);
    }
}
