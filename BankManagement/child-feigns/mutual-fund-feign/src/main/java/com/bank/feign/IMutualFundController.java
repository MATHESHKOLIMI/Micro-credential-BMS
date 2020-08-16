package com.bank.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.MutualFund;
import com.bank.MutualFundMeta;
import com.bank.model.ServiceResponse;

@FeignClient
public interface IMutualFundController {
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse<List<MutualFundMeta>>> searchMutualFund(@RequestParam("query") String query);

	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE, value="/details")
	public ResponseEntity<ServiceResponse<MutualFund>> fetchMutaulFundDetails(@RequestParam("fund") String fund);

}
