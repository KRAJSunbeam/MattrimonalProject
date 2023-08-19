package com.app.payload;

import java.sql.Date;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.app.entities.Profile;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class AuthResponce {
	private String first_Name;
	private String last_name ;
	
	private String email;
	
	private String mobileNo;

	private int pincode;
	
	private String password;
	private String gender;
	private Date birth_date;
}
