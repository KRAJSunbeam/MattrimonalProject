package com.app.entities;




import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="sucess_story")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SuccessStory {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private Long storyId;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER
			)
	@JoinColumn(name="user_id")
	 private User user;
	
	
	@Column(length = 1000,name="imagedata")
	private String imageData;
	
	@Column(length=300,name="story",columnDefinition = "TEXT")
	private String story;
	

	
}
