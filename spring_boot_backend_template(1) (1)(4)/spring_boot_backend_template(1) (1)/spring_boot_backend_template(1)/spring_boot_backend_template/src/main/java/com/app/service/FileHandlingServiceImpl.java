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
public class FileHandlingServiceImpl implements   FileHandlingService{

	@Autowired
	private ProfileDao profileDao;
	
	@Value("${upload.location1}")
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
	public ProfileApiResponse uploadFile(Long pId, MultipartFile file) throws IOException {

		Profile  profile= profileDao.findById(pId).orElseThrow(() -> new ResourceNotFoundException("Invalid profile id !!!!!"));
		
		String path = folderLocation.concat(file.getOriginalFilename());
		System.out.println("path " + path);
		
		FileUtils.writeByteArrayToFile(new File(path), file.getBytes());
		
		profile.setAdharcard(path);
		
		return new ProfileApiResponse("File uploaded n stored in server side folder");
	}// update

	@Override
	public byte[] downloadFile(Long pId) throws IOException {
		
		Profile profile= profileDao.
				findById(pId).orElseThrow(() -> new ResourceNotFoundException("Invalid profile id !!!!!"));
		
	
		if (profile.getAdharcard() != null) {
		
			return FileUtils.readFileToByteArray(new File(profile.getAdharcard()));
		}
		throw new ResourceNotFoundException("File not yet assigned!!!!");
	}
	
    @Override
    public ProfileApiResponse deleteFile(Long pId) {
        Profile profile = profileDao.findById(pId).orElseThrow(() -> new ResourceNotFoundException("Invalid profile id !!!!!"));

        if (profile.getAdharcard() != null) {
            File file = new File(profile.getAdharcard());
            if (file.exists()) {
               file.delete();
            }
            profile.setAdharcard(null);
            profileDao.save(profile); // Save the updated profile
            return new ProfileApiResponse("File deleted and profile image cleared");
        }
        throw new ResourceNotFoundException("Image not assigned, nothing to delete");
    }
}
