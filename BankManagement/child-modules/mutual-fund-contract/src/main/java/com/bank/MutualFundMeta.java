package com.bank;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MutualFundMeta {
	private String fundHouse;
	private String schemeType;
	private String schemeCategory;
	private Integer schemeCode;
	private String schemeName;
}

/*
 * "fund_house": "Aditya Birla Sun Life Mutual Fund", "scheme_type":
 * "Close Ended Schemes", "scheme_category": "Income", "scheme_code": 106983,
 * "scheme_name":
 */