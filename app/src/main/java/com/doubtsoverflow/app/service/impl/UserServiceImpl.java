package com.doubtsoverflow.app.service.impl;

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
	public User saveUser(User user) {
		return userRepository.save(user);
	}
}
