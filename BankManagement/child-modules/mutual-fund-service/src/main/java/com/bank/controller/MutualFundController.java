package com.bank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.bank.MutualFundMeta;
import com.bank.handlers.ResponseHandlers;
import com.bank.model.ServiceResponse;

@RestController
public class MutualFundController {

	public ResponseEntity<ServiceResponse<List<MutualFundMeta>>> searchMutualFund() {
		List<MutualFundMeta> metas = new ArrayList<>();
		return new ResponseHandlers<List<MutualFundMeta>>().defaultResponse(metas);
	}

}
