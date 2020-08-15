package com.bank.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bank.MutualFundMeta;
import com.bank.model.ServiceResponse;


public interface ISearchMutualFundService {
	List<MutualFundMeta> searchMutualFund(String query);
}
