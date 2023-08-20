package com.app.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.app.payload.SuccessStoryApiResponse;



public interface SuccessStoryImageHandlingService {
	SuccessStoryApiResponse uploadImage(Long storyId,MultipartFile file) throws IOException;
}
