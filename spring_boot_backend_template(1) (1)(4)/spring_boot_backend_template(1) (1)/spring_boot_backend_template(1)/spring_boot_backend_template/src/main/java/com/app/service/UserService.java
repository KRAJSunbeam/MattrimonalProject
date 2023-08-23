package com.app.service;

import java.util.List;

import com.app.entities.Profile;
import com.app.entities.User;
import com.app.payload.LoginDto;
import com.app.payload.UserAuthRequest;
import com.app.payload.UserAuthResponce;

public interface UserService {

	List<User>getUsers();
	String addUserDetails(UserAuthRequest user);
	String deleteUserDetails(Long id);
	String updateUserDetails(User user);
	String loginUser(LoginDto ld);
	public List<User> getProfilesPendingApproval();
	
	
}
