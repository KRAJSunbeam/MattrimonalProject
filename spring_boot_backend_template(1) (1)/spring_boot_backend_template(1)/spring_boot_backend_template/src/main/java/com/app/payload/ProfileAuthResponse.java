package com.app.payload;

import java.sql.Date;

import javax.persistence.Column;

import com.app.entities.Profile;
import com.app.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Setter
@Getter
public class ProfileAuthResponse {
	

	private String father_Name;

	private String mother_Name;

	private String no_of_Sibling;
	private String alternateMobileNo;
	
	private String intercasteParents;

	private String educationQualification;
	
	private String occupation;

	private double annualIncome;

	private String occupationDetails;

	private String workingCity;
	
	private String workingAt;

	private Date birth_date;

	private String birthTime;

	private String birth_place;
	 private User user_id;

	private String blood_group;
	
	private int height;

	private int weight;
	
	private String mother_tongue;
	
	private String maritual_status;
	
	private String relative_info;
}
