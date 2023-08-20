package com.app.controller;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import com.app.custexception.ResourceNotFoundException;
import com.app.entities.Profile;
import com.app.entities.Success_Story;
import com.app.entities.User;
import com.app.payload.ApiResponse;
import com.app.payload.ProfileAuthRequest;
import com.app.payload.SuccessStoryAuthRequest;
import com.app.service.SuccessStoryImageHandlingService;
import com.app.service.SuccessStoryService;

@RestController
@RequestMapping("/Stories")
@CrossOrigin(origins = "http://localhost:3000")
public class SuccessStoryController {
	
	
	@Autowired
	private SuccessStoryImageHandlingService imgService;

	@Autowired
	private SuccessStoryService storyService;

	@GetMapping("/{storyId}")
	public Success_Story getUserWithProfile(@PathVariable Long storyId) {
		return storyService.getstoryById(storyId);
	}

	public SuccessStoryController() {
		System.out.println("in ctor of " + getClass());
	}

	@PutMapping("/{storyId}")
	public ResponseEntity<String> updateProfileDetails(@PathVariable Long storyId,
			@RequestBody Success_Story updatedstory) {
		try {
			updatedstory.setStoryId(storyId); // Set the profile ID to ensure correct update

			String result = storyService.updatestoryDetails(updatedstory);
			return ResponseEntity.ok(result);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{storyId}")
	public ApiResponse deleteProfile(@PathVariable Long storyId) {
		return new ApiResponse(storyService.deletestoryDetails(storyId));
	}

	@GetMapping("/image/{id}")
	public byte[] getImg(@PathVariable Long id) throws IOException {
		String x = "/home/sunbeam/Cdac/xyz/" + id + ".png";
		System.out.println(x);
		return FileUtils.readFileToByteArray(new File(x));
	}
	
	@PostMapping("/addstory")
	public String addstoryDetails (@RequestBody SuccessStoryAuthRequest req)
	{
		return storyService.addstoryDetails(req);
	}
	
	
	// method : Post
	// multipart file :request param
	@PostMapping(value = "/{userId}/image", consumes = "multipart/form-data")
	public ResponseEntity<?> uploadEmpImage(@PathVariable Long storyId, @RequestParam MultipartFile imageFile)
			throws IOException {
		System.out.println("in img upload" + storyId);
		return ResponseEntity.status(HttpStatus.CREATED).body(imgService.uploadImage(storyId, imageFile));
	}
}
