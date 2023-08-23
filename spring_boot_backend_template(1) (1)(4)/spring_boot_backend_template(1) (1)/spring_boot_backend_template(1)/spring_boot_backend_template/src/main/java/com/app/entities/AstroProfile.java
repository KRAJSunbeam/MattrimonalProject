package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="astro_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AstroProfile {

	
	@Id
    @NaturalId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	
	@Column(length=30,name="religion")
	private String religion;
	@Column(length=30,name="caste")
	private String caste;
	@Column(length=30,name=" subCaste")
	private String subCaste;
	@Column(length=30,name="raasi")
	private String raasi;
	@Column(length=30,name="nakshatra")
	private String nakshatra;
	@Column(length=30,name="charan",nullable=false)
	private String charan;
	@Column(length=30,name="nadi",nullable=false)
	private String nadi;
	@Column(length=30,name="gan",nullable=false)
	private String gan;
	@Column(length=30,name="manglik",nullable=false)
	private boolean manglik;
	@Column(length=30,name=" mangal")
	private boolean mangal;
	

	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	 private User user;

}
