package com.doubtsoverflow.app.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.doubtsoverflow.app.Model.User;

@Repository
public class UserDaoImpl implements UsersDao{
	
	List<User> users = new ArrayList<>();
	
	@Override
	public List<User> addUser(User user) {
		users.add(user);
		return users;
	}

}
