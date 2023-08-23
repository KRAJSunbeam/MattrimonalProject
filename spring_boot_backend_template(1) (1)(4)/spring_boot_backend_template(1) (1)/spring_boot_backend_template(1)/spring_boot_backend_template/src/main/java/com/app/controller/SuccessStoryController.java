package com.app.controller;

import static org.springframework.http.MediaType.IMAGE_GIF_VALUE;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

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
import com.app.entities.SuccessStory;
import com.app.entities.User;
import com.app.payload.UserApiResponse;
import com.app.payload.ProfileAuthRequest;
import com.app.payload.SuccessStoryAuthRequest;
import com.app.service.SuccessStoryImageService;
import com.app.service.SuccessStoryService;

@RestController
@RequestMapping("/Stories")
@CrossOrigin(origins = "http://localhost:3000")
public class SuccessStoryController {
	
	
	@Autowired
	private SuccessStoryImageService imgService;

	@Autowired
	private SuccessStoryService storyService;

	@GetMapping("/{storyId}")
	public SuccessStoryAuthRequest getUserWithProfile(@PathVariable Long storyId) {
		System.out.println("hi");
		return storyService.getstoryById(storyId);
	}

	public SuccessStoryController() {
		System.out.println("in ctor of " + getClass());
	}

//	@PutMapping("/{storyId}")
//	public ResponseEntity<String> updateProfileDetails(@PathVariable Long storyId,
//		      @RequestBody SuccessStoryAuthRequest updatedStory) {
//	    try {
//	        updatedStory.setStory(storyId); // Assuming there's a setStory method in SuccessStoryAuthRequest
//
//	        String result = storyService.updatestoryDetails(updatedStory);
//	        return ResponseEntity.ok(result);
//	    } catch (ResourceNotFoundException e) {
//	        return ResponseEntity.notFound().build();
//	    }
//	}

	@DeleteMapping("/{storyId}")
	public UserApiResponse deleteProfile(@PathVariable Long storyId) {
		return new UserApiResponse(storyService.deletestoryDetails(storyId));
	}

	
	
	@PostMapping("/addstory")
	public String addstoryDetails (@RequestBody SuccessStoryAuthRequest req)
	{
		return storyService.addstoryDetails(req);
	}
	
	
	@PostMapping(value = "/{sId}/image", consumes = "multipart/form-data")
	public ResponseEntity<?> uploadEmpImage(@PathVariable Long sId, @RequestParam MultipartFile imageFile)
			throws IOException {
		System.out.println("in img upload " + sId);
		// invoke image service method
		return ResponseEntity.status(HttpStatus.CREATED).body(imgService.uploadImage(sId, imageFile));
	}

	// http://localhost:8080/employees/{empId}/image , method=GET
	// serve(download) image
	@GetMapping(value = "/{sId}/image", produces = { IMAGE_GIF_VALUE, 
			IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE })
	public ResponseEntity<?> downloadEmpImage(@PathVariable Long sId) throws IOException {
		System.out.println("in img download " + sId);
		return ResponseEntity.ok(imgService.downloadImage(sId));
	}
	
}
