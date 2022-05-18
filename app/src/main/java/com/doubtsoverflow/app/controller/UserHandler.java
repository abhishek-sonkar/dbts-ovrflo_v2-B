package com.doubtsoverflow.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doubtsoverflow.app.model.User;
import com.doubtsoverflow.app.service.UserService;


@RestController
@RequestMapping("/addUser")
public class UserHandler {
	
	@Autowired	
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
	}
}
