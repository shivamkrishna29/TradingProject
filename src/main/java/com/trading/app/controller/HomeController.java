package com.trading.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping
	public String Home() {
		return "Welcome to the trading platform guys!!!";
	}
	
	@GetMapping("/api/")
	public String homeSecure() {
		return "Welcome to the secure trading platform guys!!!";
	}
}
