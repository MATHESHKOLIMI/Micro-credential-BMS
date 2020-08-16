package com.bank.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

	@Id
	@NotNull
	@Pattern(regexp = "[1-9][0-9] {9}")
	private String accountNo;
	private AccountType account;
	@NotNull
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date dateOfOpening;
	@NotNull
	@Pattern(regexp = "[A-Z] {4}[0-9] {7}")
	private String branchIFSC;
	
	private List<Transaction> transaction;
	
	@NotNull
	private String ownerId;
	
	private String bankName;
}