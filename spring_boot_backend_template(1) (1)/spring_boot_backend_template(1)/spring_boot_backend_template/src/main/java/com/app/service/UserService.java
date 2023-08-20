package com.app.service;

import java.util.List;

import com.app.entities.Profile;
import com.app.entities.User;
import com.app.payload.AuthRequest;
import com.app.payload.AuthResponce;

public interface UserService {

	List<User>getUsers();
	String addUserDetails(AuthRequest user);
	String deleteUserDetails(Long id);
	String updateUserDetails(User user);
}
