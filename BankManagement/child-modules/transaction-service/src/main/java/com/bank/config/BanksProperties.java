package com.bank.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@Component
@Data
@ConfigurationProperties("active")
public class BanksProperties {
	private List<Bank> banks = new ArrayList<>();
	
	@ToString
	@Data
	public static class Bank {
		private String name;
		private String host;
		private Integer port;
		
		public String getFullUrl() {
			return "http://" + this.getHost() + ":" + this.getPort() + "/" + this.getName().toLowerCase();
		}
	}
	
	public List<String> getActiveBanks(){
		return banks.stream()
					.map(bank -> bank.getName())
					.collect(Collectors.toList());
	}
	
	public Map<String, Bank> getBanksMappings(){
		return banks.stream()
				.map(bank-> bank)
				.collect(Collectors.toMap(Bank::getName, Function.identity()));
	}
}
