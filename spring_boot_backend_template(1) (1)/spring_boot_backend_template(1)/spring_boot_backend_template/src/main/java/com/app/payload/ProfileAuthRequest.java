package com.app.payload;

import java.sql.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.app.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class ProfileAuthRequest {

	
	private String father_Name;

	private String mother_Name;

	private String no_of_Sibling;
	private String alternateMobileNo;
	//@NotBlank(message = "Input must be supplied")
	private String intercasteParents;
	//@NotBlank(message = "education Qualification  must be supplied")
	private String educationQualification;

	private String occupation;
	
	private double annualIncome;

	private String occupationDetails;
	//@NotBlank(message = "Working city must be supplied")
	private String workingCity;
	
	private String workingAt;

	//@NotBlank(message = "BirthTime must be supplied")
	private String birthTime;
	//@NotBlank(message = "birthplace must be supplied")
	private String birth_place;
	
	//@NotBlank(message = "Blood group must be supplied")
	private String blood_group;
	
	private int height;

	private int weight;
	private long user_id;
	private String mother_tongue;
	
	private String maritual_status;
	
	private String relative_info;
}
