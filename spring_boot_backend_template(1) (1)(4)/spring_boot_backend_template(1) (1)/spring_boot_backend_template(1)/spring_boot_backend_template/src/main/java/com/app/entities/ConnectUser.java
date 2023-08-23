package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="connectUser")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ConnectUser {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @ManyToOne
	    @JoinColumn(name = "sender_id")
	    private User sender;
	    @ManyToOne
	    @JoinColumn(name = "receiver_id")
	    private User receiver;
	    private ConnectUserStatus status;
}
