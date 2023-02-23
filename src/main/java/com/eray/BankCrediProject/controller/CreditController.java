package com.eray.BankCrediProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eray.BankCrediProject.dto.CreditCreate;
import com.eray.BankCrediProject.dto.CreditRequest;
import com.eray.BankCrediProject.dto.CreditResultDto;
import com.eray.BankCrediProject.model.CreditResult;
import com.eray.BankCrediProject.model.User;
import com.eray.BankCrediProject.repository.UserRepository;
import com.eray.BankCrediProject.service.CreditResultService;
import com.eray.BankCrediProject.service.UserService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("creditApply")
public class CreditController {
	
	@Autowired(required = false)
	private UserRepository userRepository;
	
	@Autowired(required = false)
	private CreditResultService creditResultService;
	
	
	@PostMapping
	public CreditResult creditApply(@RequestBody CreditRequest userInfo) {
		log.debug("CreditApply method is start. Credit apply recived.");
		return creditResultService.creditResultSave(userInfo);
	}
}
