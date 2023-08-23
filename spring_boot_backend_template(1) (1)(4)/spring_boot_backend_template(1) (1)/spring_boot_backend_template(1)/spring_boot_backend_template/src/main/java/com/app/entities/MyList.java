package com.app.entities;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="MyList")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class MyList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	

	@ManyToOne
	private User user;
	
	
	 
		private long user2;
	
}
