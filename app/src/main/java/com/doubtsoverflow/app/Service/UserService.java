package com.doubtsoverflow.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doubtsoverflow.app.Dao.UserDaoImpl;
import com.doubtsoverflow.app.Dao.UsersDao;
import com.doubtsoverflow.app.Model.User;


@Service
public class UserService {
	
	@Autowired
	private UsersDao usersDao;
	
	public List<User> addUser(User user) {
		return usersDao.addUser(user);
	}
	
	
}
