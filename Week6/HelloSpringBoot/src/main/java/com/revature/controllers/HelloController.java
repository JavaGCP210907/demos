package com.revature.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/hello") //any HTTP GET requests ending in /hello will go to this method to get resolved 
	public ResponseEntity<String> hello(){
		return ResponseEntity.status(200).body("Hello Spring Boot! That was easy :)");
	}
	
	
	
}
