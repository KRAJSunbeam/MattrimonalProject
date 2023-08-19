package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.custexception.ResourceNotFoundException;
import com.app.entities.Profile;
import com.app.entities.User;
import com.app.payload.ApiResponse;
import com.app.payload.AuthRequest;
import com.app.payload.ProfileAuthRequest;
import com.app.service.ProfileService;


@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "http://localhost:3000")
public class ProfileController {
	@Autowired
	private ProfileService proService;
	
	@GetMapping
	public List<Profile> listAllProfile(){
		return proService.getProfile();
	}
	
	  @GetMapping("/{userId}")
	    public User getUserWithProfile(@PathVariable Long userId) {
	        return proService.getUserById(userId);
	    }
	
	public ProfileController() {
	System.out.println("in ctor of "+getClass());
	}
	
	@PostMapping
	public ResponseEntity<?> addNewProfile(@RequestBody @Valid ProfileAuthRequest payloadDTO ){
		return ResponseEntity.status(HttpStatus.CREATED).body(proService.addProfileDetails(payloadDTO));
	}
	
	   @PutMapping("/{profileId}")
	    public ResponseEntity<String> updateProfileDetails(@PathVariable Long profileId, @RequestBody Profile updatedProfile) {
	        try {
	            updatedProfile.setProfile_id(profileId); // Set the profile ID to ensure correct update

	            String result = proService.updateProfileDetails(updatedProfile);
	            return ResponseEntity.ok(result);
	        } catch (ResourceNotFoundException e) {
	            return ResponseEntity.notFound().build();
	        }
	    }
	
	@DeleteMapping("/{profileId}")
	public ApiResponse deleteProfile(@PathVariable Long profileId) {
		return new ApiResponse(proService.deleteProfileDetails(profileId));
	}
	
}
