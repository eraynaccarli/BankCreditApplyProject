package com.eray.BankCrediProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditResultDto {

	private long userId;
	
	private String creditResult;

	private long creditLimit;
	
	
}
