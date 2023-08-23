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
import com.app.dao.ImageDao;
import com.app.entities.Images;

import com.app.payload.ImageApiResponse;


@Service
@Transactional
public class ImageServiceImpl implements ImageService{
	  

	@Autowired
	private ImageDao imgDao;
	
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
	public ImageApiResponse uploadImage(Long imgId, MultipartFile file) throws IOException {

		Images img= imgDao.
				findById(imgId).orElseThrow(() -> new ResourceNotFoundException("Invalid Image id !!!!!"));
		
		String path = folderLocation.concat(file.getOriginalFilename());
		System.out.println("path " + path);
		
		FileUtils.writeByteArrayToFile(new File(path), file.getBytes());
		
		img.setImagePath(path);
		
		return new ImageApiResponse("File uploaded n stored in server side folder");
	}// update

	@Override
	public byte[] downloadImage(Long imgId) throws IOException {
		
		
		Images img= imgDao.
				findById(imgId).orElseThrow(() -> new ResourceNotFoundException("Invalid Image id !!!!!"));
		
	
	if (img.getImagePath() != null) {
		
			return FileUtils.readFileToByteArray(new File(img.getImagePath()));
		}
		throw new ResourceNotFoundException("Image not yet assigned!!!!");
	}
	
    @Override
    public ImageApiResponse deleteImage(Long imgId) {
    	Images img = imgDao.findById(imgId).orElseThrow(() -> new ResourceNotFoundException("Invalid profile id !!!!!"));

        if (img.getImagePath() != null) {
            File imageFile = new File(img.getImagePath());
            if (imageFile.exists()) {
                imageFile.delete();
            }
            img.setImagePath(null);
            imgDao.save(img); // Save the updated profile
            return new ImageApiResponse("File deleted and profile image cleared");
        }
        throw new ResourceNotFoundException("Image not assigned, nothing to delete");
    }

}
