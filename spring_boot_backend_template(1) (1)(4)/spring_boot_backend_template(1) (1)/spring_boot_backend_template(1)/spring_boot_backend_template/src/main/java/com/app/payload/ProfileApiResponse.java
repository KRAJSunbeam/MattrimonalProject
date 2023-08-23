package com.app.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter 
@Setter 
public class ProfileApiResponse {
	private String message;

	public ProfileApiResponse(String message) {
		super();
		this.message = message;
		
	}
}
