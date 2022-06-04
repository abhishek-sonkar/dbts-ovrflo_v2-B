package com.doubtsoverflow.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.doubtsoverflow.app.model.User;


//no need to add @Repository, it will get automatically from JpaRepo.

public interface UserRepository extends JpaRepository<User, Integer> {
	
}
