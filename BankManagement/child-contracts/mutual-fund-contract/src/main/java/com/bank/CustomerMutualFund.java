package com.bank;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerMutualFund {
	private String ownerId;
	private List<MutualFund> mutualFunds;
}
