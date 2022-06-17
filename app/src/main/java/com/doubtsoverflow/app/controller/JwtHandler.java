package com.doubtsoverflow.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doubtsoverflow.app.model.JwtRequest;
import com.doubtsoverflow.app.model.JwtResponse;
import com.doubtsoverflow.app.service.impl.JwtUserService;
import com.doubtsoverflow.app.utility.JwtUtility;

@RestController
public class JwtHandler {
	
	@Autowired
	private JwtUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUserService jwtUserService;
	
	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
		
		try {
			authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(
								jwtRequest.getUsername(),
								jwtRequest.getPassword()
						)
			);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		
		final UserDetails userDetails = 
				jwtUserService.loadUserByUsername(jwtRequest.getUsername());
		
		final String token = 
				jwtUtility.generateToken(userDetails);
		
		return new JwtResponse(token);
		
	}

}
