package com.app.service;

import java.util.List;

import com.app.dao.ProfileDao;

import com.app.entities.Profile;
import com.app.entities.User;
import com.app.payload.UserAuthRequest;
import com.app.payload.UserAuthResponce;
import com.app.payload.ProfileAuthRequest;
import com.app.payload.ProfileAuthResponse;

public interface ProfileService {
	
	List<Profile>getProfile();
	 User getUserById(Long userId);
    String addProfileDetails(ProfileAuthRequest profile);
	String deleteProfileDetails(Long profileId);
	String updateProfileDetails(Profile r);
	 public List<Profile> getPhotosPendingApproval();
	 public void approveUserPhoto(Long photoId, String reason);
	 public void rejectUserPhoto(Long photoId, String reason) ;
}
