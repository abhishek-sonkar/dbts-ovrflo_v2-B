package com.doubtsoverflow.app.service.impl;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.doubtsoverflow.app.model.User;
import com.doubtsoverflow.app.repository.UserRepository;
import com.doubtsoverflow.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{   //no need to add @transaction annotation, will get from jpa
	
	private UserRepository userRepository;  //no need to add auto-wire here as it has only 1 constructor so it will get auto. autowired
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public ResponseEntity<String> signUser(User user) {
		Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
		if(existingUser.isEmpty()) {
			String hashedPwd = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));
			user.setPassword(hashedPwd);
			userRepository.save(user);
			return new ResponseEntity<>("{\"success\": \"SignedUp Successfully\"}", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("{\"err\": \"User already exists\"}", HttpStatus.CONFLICT);
		}
	}

	@Override
	public ResponseEntity<Object> logUser(User user) {
		Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
		if(existingUser.isEmpty()) {
			return new ResponseEntity<>("{\"err\": \"User does not exists\"}", HttpStatus.NOT_FOUND);
		} else {
			String hashedPwd = existingUser.get().getPassword();
			if(BCrypt.checkpw(user.getPassword(), hashedPwd)) {
				return new ResponseEntity<>(existingUser.get(), HttpStatus.FOUND);
			} else {
				return new ResponseEntity<>("{\"err\": \"Password Incorrect\"}", HttpStatus.UNAUTHORIZED);
			}
			
		}
	}
}