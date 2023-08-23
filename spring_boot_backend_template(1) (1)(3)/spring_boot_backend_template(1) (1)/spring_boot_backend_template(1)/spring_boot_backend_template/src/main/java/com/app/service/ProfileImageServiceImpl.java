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
import com.app.dao.ProfileDao;
import com.app.entities.Profile;
import com.app.payload.ProfileApiResponse;

@Service
@Transactional
public class ProfileImageServiceImpl implements ProfileImageService{

	@Autowired
	private ProfileDao profileDao;
	
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
	public ProfileApiResponse uploadImage(Long pId, MultipartFile file) throws IOException {

		Profile  profile= profileDao.findById(pId).orElseThrow(() -> new ResourceNotFoundException("Invalid profile id !!!!!"));
		
		String path = folderLocation.concat(file.getOriginalFilename());
		System.out.println("path " + path);
		
		FileUtils.writeByteArrayToFile(new File(path), file.getBytes());
		
		profile.setProfileImage(path);
		
		return new ProfileApiResponse("File uploaded n stored in server side folder");
	}// update

	@Override
	public byte[] downloadImage(Long pId) throws IOException {
		
		Profile profile= profileDao.
				findById(pId).orElseThrow(() -> new ResourceNotFoundException("Invalid profile id !!!!!"));
		
	
		if (profile.getProfileImage() != null) {
		
			return FileUtils.readFileToByteArray(new File(profile.getProfileImage()));
		}
		throw new ResourceNotFoundException("Image not yet assigned!!!!");
	}
	
	 @Override
	    public ProfileApiResponse updateImage(Long pId, MultipartFile file) throws IOException {
	        Profile profile = profileDao.findById(pId).orElseThrow(() -> new ResourceNotFoundException("Invalid profile id !!!!!"));

	        String path = folderLocation.concat(file.getOriginalFilename());
	        System.out.println("path " + path);

	        FileUtils.writeByteArrayToFile(new File(path), file.getBytes());

	        profile.setProfileImage(path);
	        profileDao.save(profile); // Save the updated profile

	        return new ProfileApiResponse("File updated and stored in the server-side folder");
	    }
	 

	    @Override
	    public ProfileApiResponse deleteImage(Long pId) {
	        Profile profile = profileDao.findById(pId).orElseThrow(() -> new ResourceNotFoundException("Invalid profile id !!!!!"));

	        if (profile.getProfileImage() != null) {
	            File imageFile = new File(profile.getProfileImage());
	            if (imageFile.exists()) {
	                imageFile.delete();
	            }
	            profile.setProfileImage(null);
	            profileDao.save(profile); // Save the updated profile
	            return new ProfileApiResponse("File deleted and profile image cleared");
	        }
	        throw new ResourceNotFoundException("Image not assigned, nothing to delete");
	    }

}
