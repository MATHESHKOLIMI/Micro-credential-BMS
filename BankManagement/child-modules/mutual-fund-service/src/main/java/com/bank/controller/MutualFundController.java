package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.MutualFundMeta;
import com.bank.handlers.ResponseHandlers;
import com.bank.model.ServiceResponse;
import com.bank.service.ISearchMutualFundService;

@RestController
@RequestMapping(value="mutual-fund")
public class MutualFundController {

	@Autowired
	private ISearchMutualFundService searchMutualFundService;
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse<List<MutualFundMeta>>> searchMutualFund(@RequestParam("query") String query) {
		List<MutualFundMeta> metas = searchMutualFundService.searchMutualFund(query);
		return new ResponseHandlers<List<MutualFundMeta>>().defaultResponse(metas);
	}

}
