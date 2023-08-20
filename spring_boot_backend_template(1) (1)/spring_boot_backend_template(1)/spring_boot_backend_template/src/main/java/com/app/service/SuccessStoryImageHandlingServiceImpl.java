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
import com.app.entities.Success_Story;
import com.app.payload.SuccessStoryApiResponse;

@Service
@Transactional
public class SuccessStoryImageHandlingServiceImpl implements SuccessStoryImageHandlingService{

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
	public SuccessStoryApiResponse uploadImage(Long storyId, MultipartFile file) throws IOException {
		Success_Story story = storyDao.findById(storyId).orElseThrow(() -> new ResourceNotFoundException("Invalid emp id !!"));
		//emp:persistent
			//save uploaded file contents in server side folder.
				//create the path to store the file
				String path=folderLocation.concat(file.getOriginalFilename());
		System.out.println("path"+path);
		//fileUtils class : to read byte[] from multipart server side folder
		//Api:public void 
		FileUtils.writeByteArrayToFile(new File(path),file.getBytes());
		//file save successfully
		//set image path in db
		story.setImageData(path);
				return new SuccessStoryApiResponse("File uploaded n stored in server side folder");
	}

}
