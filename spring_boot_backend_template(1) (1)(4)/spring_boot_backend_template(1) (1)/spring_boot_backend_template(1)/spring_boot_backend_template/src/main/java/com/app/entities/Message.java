package com.app.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Message")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	  @Column(length=30,name="title")
	    private String title;
	  @Column(length=30,name="Content")
	    private String content;
	  @Column(name="Date_time")
	    private LocalDateTime timestamp = LocalDateTime.now();
	  @Column(name="Broadcast_status")
	    private boolean isBroadcast;
}
