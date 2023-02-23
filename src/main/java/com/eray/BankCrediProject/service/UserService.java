package com.eray.BankCrediProject.service;

import java.util.List;
import java.util.Optional;

import com.eray.BankCrediProject.model.CreditResult;
import com.eray.BankCrediProject.model.User;

public interface UserService {
	User addUser(User user);
	List<User> listUser();
	User updateUser(long userId, User user);
	Optional<User> getOneUser(long userId);
	void deleteUser(long userId);
	List<Object[]> findCreditResultByTc(long tc);
}
