package com.doubtsoverflow.app.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import com.doubtsoverflow.app.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserService implements UserDetailsService{

	private UserRepository userRepository;
	public JwtUserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<com.doubtsoverflow.app.model.User> existingUser = userRepository.findByEmail(email);
		if(existingUser.isPresent()) {
			return new User(existingUser.get().getEmail(), existingUser.get().getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found");
		}
	}
}
