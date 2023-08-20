package com.app.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Profile{
	

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name="profile_id")
	private long profile_id;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	 private User user;
	@Column(length=30,name="father_Name")
	private String father_Name;
	@Column(length=30,name="mother_Name")
	private String mother_Name;
	@Column(length=30,name="no_of_sibling")
	private String no_of_Sibling;
	@Column(length=30,name="alt_mobile_no",unique=true)
	private String alternateMobileNo;
	@Column(length=30,name="intercaste_parents",nullable = false)
	private String intercasteParents;
	@Column(length=30,name="Education",nullable = false)
	private String educationQualification;
	@Column(length=30,name="occupation",nullable = false)
	private String occupation;
	@Column(name="annual_income",nullable = false)
	private double annualIncome;
	@Column(length=30,name="occupation_details")
	private String occupationDetails;
	@Column(length=30,name="working_city",nullable = false)
	private String workingCity;
	@Column(length=30,name="working_at",nullable = false)
	private String workingAt;
	
	@Column(length=30,name="birth_time",nullable = false)
	private String birthTime;
	@Column(length=30,name="birth_place",nullable = false)
	private String birth_place;
	
	@Column(length=30,name="blood_group",nullable = false)
	private String blood_group;
	@Column(length=30,name="height",nullable = false)
	private int height;
	@Column(length=30,name="weight",nullable = false)
	private int weight;
	@Column(length=30,name="mother_tongue",nullable = false)
	private String mother_tongue;
	@Column(length=30,name="maritual_status",nullable = false)
	private String maritual_status;
	@Column(length=30,name="relative_info",nullable = false)
	private String relative_info;
	
   
   
	
}
