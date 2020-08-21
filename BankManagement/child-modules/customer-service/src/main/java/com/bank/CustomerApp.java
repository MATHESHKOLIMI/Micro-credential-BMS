package com.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2@ComponentScan({"com.bank.feign"})
@Import(FeignClientsConfiguration.class)
public class CustomerApp 
{
	public static final Logger logger=LoggerFactory.getLogger(CustomerApp.class);
    public static void main( String[] args )
    {
        SpringApplication.run(CustomerApp.class, args);
    }
    
    @Bean
	public Docket api() { 
		return new Docket(DocumentationType.SWAGGER_2)  
				.select() 
				.apis(RequestHandlerSelectors.basePackage("com.bank"))
////			//	.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))              
				.paths(PathSelectors.any())                          
				.build();           
//		
//		    return new Docket(DocumentationType.SWAGGER_2)//<3>
//		            .select()//<4>
//		            .apis(RequestHandlerSelectors.any())//<5>
//		            .paths(Predicates.not(PathSelectors.regex("/error.*")))//<6>, regex must be in double quotes.
//		            .build();
//		
	}
    
}


















