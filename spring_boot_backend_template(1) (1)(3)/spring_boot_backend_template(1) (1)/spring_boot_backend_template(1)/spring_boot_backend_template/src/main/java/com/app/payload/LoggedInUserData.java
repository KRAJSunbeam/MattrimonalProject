package com.app.payload;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoggedInUserData {
	
	private long id;
	private String firstname;
	private String lastname;
	private String mobile;
	private String email;
	private int age;
	private char gender;

}
