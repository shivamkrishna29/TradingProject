package com.trading.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trading.app.model.User;
import com.trading.app.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/signup")
	public ResponseEntity<User> register(@RequestBody User user){
	
		User savedUser = new User();
		savedUser.setFullName(user.getFullName());
		savedUser.setEmail(user.getEmail());
		savedUser.setPassword(user.getPassword());
	    User newUser= userRepository.save(savedUser);
	    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
}
