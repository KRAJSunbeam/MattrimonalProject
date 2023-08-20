package com.app.entities;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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

@ToString
public class Success_Story {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long storyId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	 private User user_id;
	
	
	@Column(length = 1000,name="imagedata")
	private String imageData;
	
	@Column(length=300,name="story",columnDefinition = "TEXT")
	private String story;
	
	public Success_Story(User user, String story) {
		super();
		this.user_id = user;
		this.story = story;
		
	}
	
}
