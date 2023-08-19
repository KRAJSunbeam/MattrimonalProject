package com.app.service;

import java.util.List;

import com.app.dao.ProfileDao;

import com.app.entities.Profile;
import com.app.entities.User;
import com.app.payload.AuthRequest;
import com.app.payload.AuthResponce;
import com.app.payload.ProfileAuthRequest;
import com.app.payload.ProfileAuthResponse;

public interface ProfileService {
	
	List<Profile>getProfile();
	 User getUserById(Long userId);
	ProfileAuthResponse addProfileDetails(ProfileAuthRequest profile);
	String deleteProfileDetails(Long profileId);
	String updateProfileDetails(Profile r);
}
