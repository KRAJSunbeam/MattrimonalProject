package com.app.controller;

import static org.springframework.http.MediaType.IMAGE_GIF_VALUE;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;
import static org.springframework.http.MediaType.APPLICATION_PDF_VALUE;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
import org.springframework.web.multipart.MultipartFile;

import com.app.custexception.ResourceNotFoundException;
import com.app.entities.Profile;
import com.app.entities.User;
import com.app.payload.UserApiResponse;
import com.app.payload.UserAuthRequest;
import com.app.payload.ProfileAuthRequest;
import com.app.service.FileHandlingService;
import com.app.service.ProfileImageService;
import com.app.service.ProfileService;


@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = "http://localhost:3000")
public class ProfileController {
	@Autowired
	private ProfileService proService;
	
	@Autowired
	private ProfileImageService proImgService;
	
	@Autowired
	private FileHandlingService fileService;
	
	
	@GetMapping
	public List<Profile> listAllProfile() {
		return proService.getProfile();
	}

	@GetMapping("/{userId}")
	public User getUserWithProfile(@PathVariable Long userId) {
		return proService.getUserById(userId);
	}
	
    @GetMapping("/profile/{id}")
    public String viewProfile(@PathVariable Long id, Model model) {
        User profile = proService.getUserById(id);

        if (profile == null) {
            // Handle error when the profile doesn't exist
            model.addAttribute("errorMessage", "Profile not found");
            return "error";
        }

        model.addAttribute("Profile", profile);
        return "profile";
    }

	public ProfileController() {
		System.out.println("in ctor of " + getClass());
	}

	@PostMapping
	public ResponseEntity<?> addNewProfile(@RequestBody @Valid ProfileAuthRequest payloadDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(proService.addProfileDetails(payloadDTO));
	}

	@PutMapping("/{profileId}")
	public ResponseEntity<String> updateProfileDetails(@PathVariable Long profileId,
			@RequestBody Profile updatedProfile) {
		try {
			updatedProfile.setProfile_id(profileId); // Set the profile ID to ensure correct update

			String result = proService.updateProfileDetails(updatedProfile);
			return ResponseEntity.ok(result);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{profileId}")
	public UserApiResponse deleteProfile(@PathVariable Long profileId) {
		return new UserApiResponse(proService.deleteProfileDetails(profileId));
	}
	
	@PostMapping(value = "/{pId}/image", consumes = "multipart/form-data")
	public ResponseEntity<?> uploadImage(@PathVariable Long pId, @RequestParam MultipartFile imageFile)
			throws IOException {
		System.out.println("in img upload " + pId);
		// invoke image service method
		return ResponseEntity.status(HttpStatus.CREATED).body(proImgService.uploadImage(pId, imageFile));
	}

	// http://localhost:8080/employees/{empId}/image , method=GET
	// serve(download) image
	@GetMapping(value = "/{pId}/image", produces = { IMAGE_GIF_VALUE, 
			IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE })
	public ResponseEntity<?> downloadImage(@PathVariable Long pId) throws IOException {
		System.out.println("in img download " + pId);
		return ResponseEntity.ok(proImgService.downloadImage(pId));
	}

	@PostMapping(value = "/{pId}/file", consumes = "multipart/form-data")
	public ResponseEntity<?> uploadFile(@PathVariable Long pId, @RequestParam MultipartFile File)
			throws IOException {
		System.out.println("in img upload " + pId);
		// invoke image service method
		return ResponseEntity.status(HttpStatus.CREATED).body(fileService.uploadFile(pId, File));
	}

	// http://localhost:8080/employees/{empId}/image , method=GET
	// serve(download) image
	@GetMapping(value = "/{pId}/file", produces = { 
			APPLICATION_PDF_VALUE})
	public ResponseEntity<?> downloadFile(@PathVariable Long pId) throws IOException {
		System.out.println("in img download " + pId);
		return ResponseEntity.ok(fileService.downloadFile(pId));
	}
}
