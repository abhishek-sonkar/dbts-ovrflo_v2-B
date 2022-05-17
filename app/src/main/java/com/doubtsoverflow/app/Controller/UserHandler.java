package com.doubtsoverflow.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doubtsoverflow.app.Model.User;
import com.doubtsoverflow.app.Service.UserService;


@RequestMapping("/addUser")
@RestController
public class UserHandler {
	
	@Autowired	
	private UserService userService;
	
	@PostMapping
	public List<User> addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	

}
