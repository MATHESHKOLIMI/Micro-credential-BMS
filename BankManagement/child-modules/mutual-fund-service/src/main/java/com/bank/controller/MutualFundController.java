package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.MutualFund;
import com.bank.MutualFundMeta;
import com.bank.handlers.ResponseHandlers;
import com.bank.model.ServiceResponse;
import com.bank.service.ISearchMutualFundService;

@RestController
@RequestMapping("/mutual-fund")
public class MutualFundController {

	@Autowired
	private ISearchMutualFundService searchMutualFundService;
	
	public ResponseEntity<ServiceResponse<List<MutualFundMeta>>> searchMutualFund(String query) {
		List<MutualFundMeta> metas = searchMutualFundService.searchMutualFund(query);
		return new ResponseHandlers<List<MutualFundMeta>>().defaultResponse(metas);
	}

	public ResponseEntity<ServiceResponse<MutualFund>> fetchMutaulFundDetails(String fund) {
		MutualFund mutualFund = searchMutualFundService.fetchMutaulFundDtls(fund);
		return new ResponseHandlers<MutualFund>().defaultResponse(mutualFund);
	}
	
	
}
