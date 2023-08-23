package com.app.service;

import java.util.Optional;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custexception.ResourceNotFoundException;
import com.app.dao.SuccessStoryDao;
import com.app.dao.UserDao;

import com.app.entities.SuccessStory;
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
	public SuccessStoryAuthRequest getstoryById(Long storyId) {
		  Optional<SuccessStory> storyOptional = storyDao.findById(storyId);
		    
		    if (storyOptional.isPresent()) {
		        SuccessStory story = storyOptional.get();
		        SuccessStoryAuthRequest successStoryAuthRequest = modelMapper.map(story, SuccessStoryAuthRequest.class);
		        return successStoryAuthRequest;
		    }
		    
		    return null;
	}

	@Override
	public String addstoryDetails(SuccessStoryAuthRequest story) {
		
		SuccessStory sty =storyDao.save(modelMapper.map(story,SuccessStory.class));
		Optional<User> user = userDao.findById(story.getUser_id());
	    sty.setUser(user.orElseGet(null));
		return"story Created Successfully";
	}

	@Override
	public String deletestoryDetails(Long storyId) {
		
		SuccessStory sty = storyDao.findById(storyId).orElseThrow(() -> new ResourceNotFoundException("Invalid pro ID !!!!!"));
		storyDao.deleteById(storyId);
		return "story details deleted successfully!";
	}

	

	    @Override
	    public String updatestoryDetails(SuccessStoryAuthRequest  updatedStory) {

//	    	  String story = updatedStory.getStory();
//	    	  Long storyId=null;
//
//	    	    // Check if the story with the given ID exists
//	    	    SuccessStory existingStory = storyDao.findById(storyId)
//	    	            .orElseThrow(() -> new ResourceNotFoundException("Story not found with ID: " + storyId));
//
//	    	    // Update the fields of the existing story with the new values
//	    	    modelMapper.map(updatedStory, existingStory);
//
//	    	    // Save the updated story
//	    	    storyDao.save(existingStory);

	    	    return "Story details updated successfully!";
	}

}
