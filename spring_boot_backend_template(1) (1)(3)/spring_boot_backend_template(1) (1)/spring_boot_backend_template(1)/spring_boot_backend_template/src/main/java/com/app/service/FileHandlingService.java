package com.app.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.app.payload.ProfileApiResponse;

public interface FileHandlingService {
	ProfileApiResponse uploadFile(Long pId,MultipartFile file) throws IOException;
	byte[] downloadFile(Long pId) throws IOException;
	ProfileApiResponse deleteFile(Long pId);
}
