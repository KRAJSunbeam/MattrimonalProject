package com.app.payload;



import java.sql.Date;

import javax.validation.constraints.NotBlank;

import com.app.entities.Profile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class UserAuthRequest {
	
	private String first_Name;
	
	private String last_Name;

	private String email;
	
	private String mobileNo;
	
	private int pincode;
	//@NotBlank(message = "password must be supplied")
	private String password;
	//@NotBlank(message = "gender must be supplied")
	private String gender;
	private Date birth_date;
	private String userType;
	
//	@NotBlank(message = "birth date must be supplied")
//	private LocalDate birth_date;
//	@NotBlank(message = "occupation must be supplied")
//	private String occupation;
//	@NotBlank(message = "working must be supplied")
//	private String workingCity;
//	@NotBlank(message = "end date must be supplied")
//	private LocalDate end_date;
}
         