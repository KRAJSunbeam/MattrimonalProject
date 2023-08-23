package com.app.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.app.payload.ProfileApiResponse;

public interface ProfileImageService {
	ProfileApiResponse uploadImage(Long pId,MultipartFile file) throws IOException;
	byte[] downloadImage(Long pId) throws IOException;
	 ProfileApiResponse updateImage(Long pId, MultipartFile file) throws IOException ;
	 ProfileApiResponse deleteImage(Long pId);
}
