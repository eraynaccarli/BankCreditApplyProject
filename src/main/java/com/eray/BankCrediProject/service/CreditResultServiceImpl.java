package com.eray.BankCrediProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eray.BankCrediProject.dto.CreditRequest;
import com.eray.BankCrediProject.model.CreditResult;
import com.eray.BankCrediProject.model.User;
import com.eray.BankCrediProject.repository.CreditResultRepository;
import com.eray.BankCrediProject.repository.UserRepository;

@Service
public class CreditResultServiceImpl implements CreditResultService {


	private final CreditResultRepository creditRepository;

	private final UserRepository userRepository;
	
	private final int creditLimitMultipilier = 4;

	public CreditResultServiceImpl(CreditResultRepository creditRepository,UserRepository userRepository) {
		this.creditRepository = creditRepository;
		this.userRepository = userRepository;
	}

	@Override
	public CreditResult creditResultSave(CreditRequest userInfo) {
		User user = userRepository.findById(userInfo.getUserId()).orElse(null);
		
		long userId = user.getId();
		long creditScore = user.getCreditScore();
		long tc = user.getTc();
		String phoneNumber = user.getPhoneNumber();
		double salary = user.getSalary();
		
		if(creditScore < 500) {
			CreditResult creditResult = new CreditResult();
			creditResult.setUser(user);
			creditResult.setCreditLimit(0);
			creditResult.setCreditResult("RED");
			return creditRepository.save(creditResult);
		}
		else if(creditScore > 500 && 1000 > creditScore && salary < 5000) {
			CreditResult creditResult = new CreditResult();
			creditResult.setCreditLimit(10000);
			creditResult.setCreditResult("ONAY");
			creditResult.setUser(user);
			return creditRepository.save(creditResult);
		}
		
		else if(creditScore > 500 && 1000 > creditScore && salary > 5000 && salary < 10000) {
			CreditResult creditResult = new CreditResult();
			creditResult.setCreditLimit(20000);
			creditResult.setCreditResult("ONAY");
			creditResult.setUser(user);
			return creditRepository.save(creditResult);
		}
		
		else if(creditScore > 500 && 1000 > creditScore && salary > 10000) {
			CreditResult creditResult = new CreditResult();
			long limit = (long) ((salary * creditLimitMultipilier) / 2);
			creditResult.setCreditLimit(limit);
			creditResult.setCreditResult("ONAY");
			creditResult.setUser(user);
			return creditRepository.save(creditResult);
		}
		
		else if(creditScore >= 1000) {
			CreditResult creditResult = new CreditResult();
			long limit = (long) ((salary * creditLimitMultipilier));
			creditResult.setCreditLimit(limit);
			creditResult.setCreditResult("ONAY");
			creditResult.setUser(user);
			return creditRepository.save(creditResult);
		}
		CreditResult creditResult = new CreditResult();
		creditResult.setCreditLimit(0);
		creditResult.setCreditResult("null");
		creditResult.setUser(user);
		return creditRepository.save(creditResult);
	}
		
		
	
	

}
