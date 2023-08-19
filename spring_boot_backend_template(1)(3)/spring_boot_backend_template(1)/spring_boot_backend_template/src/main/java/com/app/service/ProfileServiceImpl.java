package com.app.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custexception.ResourceNotFoundException;
import com.app.dao.ProfileDao;
import com.app.dao.UserDao;
import com.app.entities.Profile;
import com.app.entities.User;
import com.app.payload.AuthRequest;
import com.app.payload.AuthResponce;
import com.app.payload.ProfileAuthRequest;
import com.app.payload.ProfileAuthResponse;
@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {
	@Autowired
	private ProfileDao proDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProfileAuthResponse addProfileDetails(ProfileAuthRequest profile) {
		Profile pro =proDao.save(modelMapper.map(profile,Profile.class));
		Optional<User> user = userDao.findById(profile.getUser_id());
		pro.setUser_id(user.orElseGet(null));
		return modelMapper.map(profile,ProfileAuthResponse.class);
	}

	@Override
	public String deleteProfileDetails(Long profileId) {
		Profile pro = proDao.findById(profileId).orElseThrow(() -> new ResourceNotFoundException("Invalid pro ID !!!!!"));
		proDao.deleteById(profileId);
		return "project details deleted successfully!";
	}

	@Override
	public List<Profile> getProfile() {
		
		return proDao.findAll();
	}
	
    public User getUserById(Long userId) {
        return userDao.findById(userId).orElse(null);
    }

	@Override
	public String updateProfileDetails(Profile updatedProfile) {
		   Profile existingProfile = proDao.findById(updatedProfile.getProfile_id())
		            .orElseThrow(() -> new ResourceNotFoundException("Invalid profile ID"));

		     

		        // Update associated user data
		        User existingUser = existingProfile.getUser_id();
		        User updatedUser = updatedProfile.getUser_id();

		      

		        proDao.save(existingProfile);
		return "profile details update successfully!";
		
   }
}
