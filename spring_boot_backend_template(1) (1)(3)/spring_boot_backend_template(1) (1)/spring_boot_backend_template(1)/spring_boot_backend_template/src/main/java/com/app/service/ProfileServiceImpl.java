package com.app.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custexception.ResourceNotFoundException;
import com.app.dao.NotificationDao;
import com.app.dao.ProfileDao;
import com.app.dao.UserDao;
import com.app.entities.Notification;
import com.app.entities.Profile;
import com.app.entities.User;
import com.app.payload.UserAuthRequest;
import com.app.payload.UserAuthResponce;
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
	    private NotificationDao notificationDao;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String addProfileDetails(ProfileAuthRequest profile) {
		Profile pro =proDao.save(modelMapper.map(profile,Profile.class));
		Optional<User> user = userDao.findById(profile.getUser_id());
		pro.setUser(user.orElseGet(null));
		return"Profile Created Successfully";
	}

	@Override
	public String deleteProfileDetails(Long profileId) {
		Profile pro = proDao.findById(profileId).orElseThrow(() -> new ResourceNotFoundException("Invalid pro ID !!!!!"));
		proDao.deleteById(profileId);
		return "profile details deleted successfully!";
	}

	@Override
	public List<Profile> getProfile() {
		
		return proDao.findAll();
	}
	
    public User getUserById(Long userId) {
        return userDao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Invalid pro ID !!!!!"));
    }

	@Override
	public String updateProfileDetails(Profile updatedProfile) {
		   Profile existingProfile = proDao.findById(updatedProfile.getProfile_id())
		            .orElseThrow(() -> new ResourceNotFoundException("Invalid profile ID"));

		     

		        // Update associated user data
		        User existingUser = existingProfile.getUser();
		        User updatedUser = updatedProfile.getUser();

		        modelMapper.map(updatedUser, existingUser) ; 
		        modelMapper.map(updatedProfile, existingProfile) ; 
		        
		        //proDao.save(existingProfile);
		return "profile details update successfully!";
		
   }
	
	@Override
    public List<Profile> getPhotosPendingApproval() {
        return proDao.findByIsApproved(false);
    }

	@Override
	  public void approveUserPhoto(Long profileId, String reason) {
		Profile pro = proDao.findById(profileId).orElseThrow(() -> new ResourceNotFoundException("Invalid pro ID !!!!!"));
	        pro.setApproved(true);
	        pro.setApprovalReason(reason);
	        proDao.save(pro);

	        // Notify user (you can implement the notification mechanism)
	        Notification notification = new Notification();
	        notification.setMessage("Your profile has been rejected with reason: " + reason);
//	        notification.setProfileImage(pro);
	        notificationDao.save(notification);
	    }
	@Override
	    public void rejectUserPhoto(Long profileId, String reason) {
		Profile pro = proDao.findById(profileId).orElseThrow(() -> new ResourceNotFoundException("Invalid pro ID !!!!!"));
	      pro.setApproved(false);
	        pro.setApprovalReason(reason);
	       proDao.save(pro);

	        // Notify user (you can implement the notification mechanism)
	       Notification notification = new Notification();
	        notification.setMessage("Your profile has been rejected with reason: " + reason);
	     
	        
	        //notification.setUserProfile(pro);
	        notificationDao.save(notification);
	    }
	
	public void approveUserProfile(User user, String reason) {
		Profile pro = proDao.findById(user.getUser_Id()).orElseThrow(() -> new ResourceNotFoundException("Invalid pro ID !!!!!"));

        pro.setApproved(true);
        pro.setApprovalReason(reason);
        proDao.save(pro);

        // Notify user (you can implement the notification mechanism)
        Notification notification = new Notification();
        notification.setMessage("Your profile has been approved with reason: " + reason);
        notification.setUser(user);
        notificationDao.save(notification);
    }
	
    public void rejectUserProfile(User user, String reason) {
		Profile pro = proDao.findById(user.getUser_Id()).orElseThrow(() -> new ResourceNotFoundException("Invalid pro ID !!!!!"));
        pro.setApproved(false);
        pro.setApprovalReason(reason);
        proDao.save(pro);

        // Notify user (you can implement the notification mechanism)
        Notification notification = new Notification();
        notification.setMessage("Your profile has been rejected with reason: " + reason);
        notification.setUser(user);
        notificationDao.save(notification);
    }
}
