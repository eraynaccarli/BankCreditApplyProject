package com.eray.BankCrediProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eray.BankCrediProject.model.CreditResult;
import com.eray.BankCrediProject.model.User;
import com.eray.BankCrediProject.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user){
		log.debug("addUser method start. User register succsessfly.");
		return ResponseEntity.ok(userService.addUser(user));
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable long userId, @RequestBody User user) {
		log.debug("updateUser method start. User updated.");
		return ResponseEntity.ok(userService.updateUser(userId,user));
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<Optional<User>> getOneUser(@PathVariable long userId){
		log.debug("getOneUser method start. User found.");
		return ResponseEntity.ok(userService.getOneUser(userId));
	}
	
	@GetMapping
	public ResponseEntity<List<User>> listUsers(){
		log.debug("listUsers method start. Users listed.");
		return ResponseEntity.ok(userService.listUser());
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable long userId){
		log.debug("deleteUser method start. User deleted.");
		userService.deleteUser(userId);
	}
	
	@GetMapping("/tc/{tc}")
	public List<Object[]> findCreditResultByTc(@PathVariable long tc) {
		log.debug("findCreditResultByTc method start. Credit Result found.");
		return userService.findCreditResultByTc(tc);
	}
}
