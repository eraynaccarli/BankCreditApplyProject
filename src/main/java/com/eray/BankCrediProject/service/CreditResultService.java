package com.eray.BankCrediProject.service;

import com.eray.BankCrediProject.dto.CreditCreate;
import com.eray.BankCrediProject.dto.CreditRequest;
import com.eray.BankCrediProject.dto.CreditResultDto;
import com.eray.BankCrediProject.model.CreditResult;

public interface CreditResultService {


	CreditResult creditResultSave(CreditRequest creditResult);
}
