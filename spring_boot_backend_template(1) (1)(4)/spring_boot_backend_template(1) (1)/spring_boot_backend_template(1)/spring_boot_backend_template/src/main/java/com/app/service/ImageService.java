package com.app.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.app.payload.ImageApiResponse;


public interface ImageService {
	ImageApiResponse uploadImage(Long imgId,MultipartFile file) throws IOException;
	byte[] downloadImage(Long imgId) throws IOException;
	ImageApiResponse deleteImage(Long imgId);
}
