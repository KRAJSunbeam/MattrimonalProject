package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.User;

public interface UserDao extends JpaRepository<User, Long> {
	//@Query("select u from User u left outer join fetch u where u.email=?1 and u.password=?2")
	//Optional<User> validateUser(String email,String pass);
	Optional<User> findByEmailAndPassword(String email, String password);
	 List<User> findByIsApproved(boolean isApproved);
	User findByEmail(String currentUsername);
}
