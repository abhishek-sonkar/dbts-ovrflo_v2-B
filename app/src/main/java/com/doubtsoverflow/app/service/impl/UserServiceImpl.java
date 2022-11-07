package com.doubtsoverflow.app.service.impl;

import java.util.Optional;

import com.doubtsoverflow.app.filter.JwtAuthFilter;
import com.doubtsoverflow.app.model.LogResponse;
import com.doubtsoverflow.app.utility.JwtUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.doubtsoverflow.app.model.User;
import com.doubtsoverflow.app.repository.UserRepository;
import com.doubtsoverflow.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{   //no need to add @transaction annotation, will get from jpa
	
	private UserRepository userRepository;  //no need to add auto-wire here as it has only 1 constructor so it will get auto. autowired

	@Autowired
	private JwtUtility jwtUtility;

	@Autowired
	private AuthenticationManager authenticationManager;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Autowired
	private JwtUserService jwtUserService;

	Logger logger = LoggerFactory.getLogger(JwtAuthFilter.class);

	@Override
	public ResponseEntity<String> signUser(User user) {
		Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
		if(existingUser.isEmpty()) {
			String hashedPwd = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10));
			user.setPassword(hashedPwd);
			userRepository.save(user);
			logger.info("SignedUp Successfully");
			return new ResponseEntity<>("{\"message\": \"SignedUp Successfully\"}", HttpStatus.CREATED);
		} else {
			logger.error("User already exists");
			return new ResponseEntity<>("{\"message\": \"User already exists\"}", HttpStatus.CONFLICT);
		}
	}

	@Override
	public ResponseEntity<Object> logUser(User user) {
		Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
		if(existingUser.isEmpty()) {
			logger.error("User does not exists");
			return new ResponseEntity<>(
					new LogResponse(false, null, null, "User does not exists"), HttpStatus.NOT_FOUND);
		} else {
			String hashedPwd = existingUser.get().getPassword();
			if(BCrypt.checkpw(user.getPassword(), hashedPwd)) {
				String userName = existingUser.get().getFirstName() + "_" + existingUser.get().getLastName();
				try {
					String token = authenticate(existingUser.get().getEmail(), existingUser.get().getPassword());
					logger.info("LoggedIn Successfully");
					return new ResponseEntity<>(
							new LogResponse(true, userName, token, "LoggedIn Successfully"), HttpStatus.ACCEPTED);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			} else {
				logger.error("Password Incorrect");
				return new ResponseEntity<>(
						new LogResponse(false, null, null, "Password Incorrect"), HttpStatus.UNAUTHORIZED);
			}
		}
	}

	public String authenticate(String email, String password) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(email, password)
			);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		final UserDetails userDetails =
				jwtUserService.loadUserByUsername(email);
		final String token = jwtUtility.generateToken(userDetails);
		return token;
	}
}