package com.trading.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trading.app.config.JwtProvider;
import com.trading.app.model.User;
import com.trading.app.repository.UserRepository;
import com.trading.app.response.AuthResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> register(@RequestBody User user) throws Exception{

		User isEmailExist = userRepository.findByEmail(user.getEmail());
		if(isEmailExist != null) {
			throw new Exception("Email is already exist");
		}
		
		User savedUser = new User();
		savedUser.setFullName(user.getFullName());
		savedUser.setEmail(user.getEmail());
		savedUser.setPassword(user.getPassword());
	    User newUser= userRepository.save(savedUser);
	    
		Authentication auth = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());		
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		String jwt = JwtProvider.generateToken(auth);
		
		AuthResponse res = new AuthResponse();
		res.setJwt(jwt);
		res.setStatus(true);
		res.setMessage("Register Sucess");
	    return new ResponseEntity<>(res, HttpStatus.CREATED);
	}
}
