package com.eray.BankCrediProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eray.BankCrediProject.model.CreditResult;

@Repository
public interface CreditResultRepository extends JpaRepository<CreditResult, Long> {

}
