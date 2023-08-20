package com.app.entities;


import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")

	    private List<MyList> userList; 
	
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private Long user_Id;
	

	
	@Column(length=30,name="first_Name")
	private String first_Name;
	@Column(length=30,name="password",nullable = false)
	private String password;
	@Column(length=30,name="last_Name")
	private String last_Name;
	@Column(length=30,name="email",unique = true,nullable=false)
	private String email;
	@Column(length=30,name="mobileNo",unique=true)
	private String mobileNo;
	@Column(length=30,name="birth_date")
	private Date birth_date;
	@Column(name="pincode")
	private int pincode;
	@Column(length=30,name="gender")
	private String gender;
	@Column(length=30,name="user_Type")
	private String userType;
	
	
	
}
