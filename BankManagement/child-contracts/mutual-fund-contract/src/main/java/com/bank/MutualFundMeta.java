package com.bank;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(Include.NON_NULL)
public class MutualFundMeta {
	@JsonProperty(value= "fund_house")	
	private String fundHouse;
	
	@JsonProperty(value= "scheme_type")	
	private String schemeType;
	
	@JsonProperty(value="scheme_category")
	private String schemeCategory;
	
	@JsonProperty(value= "schemeCode")
	@JsonAlias({"scheme_code", "schemeCode"})
	private Integer schemeCode;
	
	@JsonProperty(value= "schemeName")
	@JsonAlias({"scheme_name", "schemeName"})
	private String schemeName;
}

