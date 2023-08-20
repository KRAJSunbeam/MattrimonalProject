package com.app.service;



import com.app.entities.Success_Story;

import com.app.payload.ProfileAuthRequest;
import com.app.payload.SuccessStoryAuthRequest;

public interface SuccessStoryService {

	
	Success_Story getstoryById(Long storyId);
   String addstoryDetails(SuccessStoryAuthRequest story);
	String deletestoryDetails(Long storyId);
	String updatestoryDetails(Success_Story story);
}
