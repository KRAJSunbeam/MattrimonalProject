package com.app.payload;




import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter 
@Setter 
public class UserApiResponse {
	private String message;

	public UserApiResponse(String message) {
		super();
		this.message = message;
		
	}
	
}
