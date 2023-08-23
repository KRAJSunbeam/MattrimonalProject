package com.app.service;







import com.app.entities.SuccessStory;
import com.app.payload.SuccessStoryAuthRequest;

public interface SuccessStoryService {

	
	SuccessStoryAuthRequest getstoryById(Long storyId);
   String addstoryDetails(SuccessStoryAuthRequest story);
	String deletestoryDetails(Long storyId);
	String updatestoryDetails(SuccessStoryAuthRequest  updatedStory) ;
}
