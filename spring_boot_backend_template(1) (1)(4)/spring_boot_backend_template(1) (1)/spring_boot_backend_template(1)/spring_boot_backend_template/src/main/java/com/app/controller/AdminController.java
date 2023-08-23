package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Profile;
import com.app.entities.User;
import com.app.service.ProfileService;
import com.app.service.ProfileServiceImpl;
import com.app.service.UserService;
import com.app.service.UserServiceImpl;

@RestController
@RequestMapping("/Admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

	   @Autowired
	    private UserService userService;
	   
	   @Autowired
	    private UserServiceImpl userServiceImpl;
	    @Autowired
	    private ProfileService profileService;
	    
	    @Autowired
	    private ProfileServiceImpl profileServiceImpl;

	    @GetMapping("/user")
	    public List<User> getProfilesPendingApproval() {
	        return userService.getProfilesPendingApproval();
	    }

	    
	    
	    @GetMapping("/photos")
	    public List<Profile> getPhotosPendingApproval() {
	        return profileService.getPhotosPendingApproval();
	    }

	  

	

	    @PostMapping("/profiles/reject/{profileId}")
	    public void rejectUserProfile(@PathVariable User user, @RequestParam String reason) {
	    	profileServiceImpl.rejectUserProfile(user, reason);
	    }

	  

	    @PostMapping("/photos/reject/{profileId}")
	    public void rejectUserPhoto(@PathVariable Long profileId, @RequestParam String reason) {
	    	profileServiceImpl.rejectUserPhoto(profileId, reason);
	    }
	    
	    @PostMapping("/users/block/{userId}")
	    public void blockUser(@PathVariable Long id) {
	        userServiceImpl.blockUser(id);
	    }

	    @PostMapping("/users/unblock/{userId}")
	    public void unblockUser(@PathVariable Long id) {
	        userServiceImpl.unblockUser(id);
	    }
	}

	