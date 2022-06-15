package com.doubtsoverflow.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doubtsoverflow.app.model.User;
import com.doubtsoverflow.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserHandler {
	
	@Autowired	
	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		return userService.signUser(user);
	}
	
	@GetMapping("/login")
	public ResponseEntity<Object> getUser(@RequestBody User user) {
		return userService.logUser(user);
	}
}
