package com.app.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.app.payload.SuccessStoryApiResponse;



public interface SuccessStoryImageService {
	SuccessStoryApiResponse uploadImage(Long sId,MultipartFile file) throws IOException;
	byte[] downloadImage(Long sId) throws IOException;
}
