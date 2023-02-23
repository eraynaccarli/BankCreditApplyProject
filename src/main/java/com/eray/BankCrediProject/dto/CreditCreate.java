package com.eray.BankCrediProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCreate {
	
	private String creditResult;

	private long creditLimit;
	
	private long tc;
	
	private String phoneNumber;
	
}
