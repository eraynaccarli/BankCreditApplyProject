package com.eray.BankCrediProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eray.BankCrediProject.model.CreditResult;
import com.eray.BankCrediProject.model.User;
import com.eray.BankCrediProject.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {


	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> listUser() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(long userId, User user) {
		User userUpdate = userRepository.findById(userId).get();
		userUpdate.setId(user.getId());
		userUpdate.setName(user.getName());
		userUpdate.setSurname(user.getSurname());
		userUpdate.setTc(user.getTc());
		userUpdate.setBirthDate(user.getBirthDate());
		userUpdate.setPhoneNumber(user.getPhoneNumber());
		userUpdate.setCreditScore(user.getCreditScore());
		
		return userRepository.save(userUpdate);
	}

	@Override
	public Optional<User> getOneUser(long userId) {
		return userRepository.findById(userId);
	}

	@Override
	public void deleteUser(long userId) {
		userRepository.deleteById(userId);;
		
	}

	@Override
	public	List<Object[]> findCreditResultByTc(long tc) {
		return userRepository.findCreditResultByTc(tc);
	}

}
