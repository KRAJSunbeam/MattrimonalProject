package com.app.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.app.custexception.ResourceNotFoundException;
import com.app.dao.SuccessStoryDao;
import com.app.entities.SuccessStory;
import com.app.payload.SuccessStoryApiResponse;

@Service
@Transactional
public class SuccessStoryImageServiceImpl implements SuccessStoryImageService{

	@Autowired
	private SuccessStoryDao storyDao;
	
	@Value("${upload.location}")
	private String folderLocation;
	
	@PostConstruct
	public void init() {
		System.out.println("in int " +folderLocation);
		File folder = new File(folderLocation);
		if(folder.exists())
			System.out.println("folder already exists!");
		else {
			folder.mkdir();
			System.out.println("created a new folder");
		}
	}
	
	
	@Override
	public SuccessStoryApiResponse uploadImage(Long sId, MultipartFile file) throws IOException {

		SuccessStory  story= storyDao.findById(sId).orElseThrow(() -> new ResourceNotFoundException("Invalid story id !!!!!"));
		
		String path = folderLocation.concat(file.getOriginalFilename());
		System.out.println("path " + path);
		
		FileUtils.writeByteArrayToFile(new File(path), file.getBytes());
		
		story.setImageData(path);
		
		return new SuccessStoryApiResponse("File uploaded n stored in server side folder");
	}// update

	@Override
	public byte[] downloadImage(Long sId) throws IOException {
		// get emp from DB
		SuccessStory  story= storyDao.
				findById(sId).orElseThrow(() -> new ResourceNotFoundException("Invalid profile id !!!!!"));
		
		// => emp exists !
		// chk if image path exists
		if (story.getImageData() != null) {
			// img exists , read file contents in to byte[]
			return FileUtils.readFileToByteArray(new File(story.getImageData()));
		}
		throw new ResourceNotFoundException("Image not yet assigned!!!!");
	}

}
