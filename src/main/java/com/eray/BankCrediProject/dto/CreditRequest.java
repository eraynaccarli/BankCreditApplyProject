package com.eray.BankCrediProject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditRequest {

	private long userId;
	
	private long tc;
	
	private String phoneNumber;
	
	private String name;
	
	private String surname;
	
	private double salary;
	
	private long creditScore;
	
	
}
