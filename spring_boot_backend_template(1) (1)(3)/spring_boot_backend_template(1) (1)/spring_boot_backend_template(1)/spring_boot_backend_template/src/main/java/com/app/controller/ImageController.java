package com.app.controller;

import static org.springframework.http.MediaType.IMAGE_GIF_VALUE;
import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.service.ImageService;

@RestController
@RequestMapping("/Image")
public class ImageController {
	
	@Autowired
	private ImageService imgService;
	

	@PostMapping(value = "/{imgId}/image", consumes = "multipart/form-data")
	public ResponseEntity<?> uploadImage(@PathVariable Long imgId, @RequestParam MultipartFile imageFile)
			throws IOException {
		System.out.println("in img upload " + imgId);
		// invoke image service method
		return ResponseEntity.status(HttpStatus.CREATED).body(imgService.uploadImage(imgId, imageFile));
	}

	// http://localhost:8080/employees/{empId}/image , method=GET
	// serve(download) image
	@GetMapping(value = "/{pId}/image", produces = { IMAGE_GIF_VALUE, 
			IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE })
	public ResponseEntity<?> downloadImage(@PathVariable Long imgId) throws IOException {
		System.out.println("in img download " + imgId);
		return ResponseEntity.ok(imgService.downloadImage(imgId));
	}
	
}
