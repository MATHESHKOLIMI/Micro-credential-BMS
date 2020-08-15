package com.bank;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MutualFundData {
	private String date;
	private String nav;
}
