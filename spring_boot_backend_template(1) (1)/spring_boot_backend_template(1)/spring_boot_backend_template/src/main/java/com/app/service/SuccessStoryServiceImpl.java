package com.app.service;

import java.util.Optional;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custexception.ResourceNotFoundException;
import com.app.dao.SuccessStoryDao;
import com.app.dao.UserDao;

import com.app.entities.Success_Story;
import com.app.entities.User;
import com.app.payload.SuccessStoryAuthRequest;


@Service
@Transactional
public class SuccessStoryServiceImpl implements SuccessStoryService {

	@Autowired
	private SuccessStoryDao storyDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public Success_Story getstoryById(Long storyId) {
	
		return storyDao.findById(storyId).orElse(null);
	}

	@Override
	public String addstoryDetails(SuccessStoryAuthRequest story) {
		
		Success_Story sty =storyDao.save(modelMapper.map(story,Success_Story.class));
		Optional<User> user = userDao.findById(story.getUser_id());
	    sty.setUser_id(user.orElseGet(null));
		return"story Created Successfully";
	}

	@Override
	public String deletestoryDetails(Long storyId) {
		
		Success_Story sty = storyDao.findById(storyId).orElseThrow(() -> new ResourceNotFoundException("Invalid pro ID !!!!!"));
		storyDao.deleteById(storyId);
		return "story details deleted successfully!";
	}

	

	    @Override
	    public String updatestoryDetails(Success_Story updatedStory) {
	        Long storyId = updatedStory.getStoryId();

	        // Check if the story with the given ID exists
	        Success_Story existingStory = storyDao.findById(storyId)
	                .orElseThrow(() -> new ResourceNotFoundException("Story not found with ID: " + storyId));

	        // Update the fields of the existing story with the new values
	        existingStory.setStory(updatedStory.getStory());
	      

	    // Save the updated story
	    storyDao.save(existingStory);

	    return "Story details updated successfully!";
	}

}
