package com.doubtsoverflow.app.service;

import org.springframework.http.ResponseEntity;

import com.doubtsoverflow.app.model.User;

public interface UserService {
	ResponseEntity<String> signUser(User user);
	
	ResponseEntity<Object> logUser(User user);
}
