package com.eray.BankCrediProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eray.BankCrediProject.model.CreditResult;
import com.eray.BankCrediProject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT creditresults.credit_result, creditresults.credit_limit, users.tc, users.name,users.surname FROM creditresults inner join users on users.id = creditresults.user_id where tc = ?1",nativeQuery = true)
	List<Object[]> findCreditResultByTc(long tc);
	
	User findByTc(long tc);

}
