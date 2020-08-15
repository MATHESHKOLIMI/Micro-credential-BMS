package com.bank;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MutualFund {

	private MutualFundMeta meta;
	private List<MutualFundData> data;
}
