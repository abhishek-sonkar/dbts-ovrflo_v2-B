package com.doubtsoverflow.app.service;

import org.springframework.http.ResponseEntity;

import com.doubtsoverflow.app.model.User;

public interface UserService {
	ResponseEntity<String> saveUser(User user);
	
	ResponseEntity<Object> getUser(User user);
}
