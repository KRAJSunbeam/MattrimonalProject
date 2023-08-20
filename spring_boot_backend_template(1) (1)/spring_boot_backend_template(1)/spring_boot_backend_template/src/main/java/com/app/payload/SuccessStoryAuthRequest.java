package com.app.payload;

import java.sql.Date;

import javax.persistence.Column;

import com.app.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SuccessStoryAuthRequest {
	    
	
	    private Long user_id;
		
		//private String imagePath;
	
		private String story;
}
