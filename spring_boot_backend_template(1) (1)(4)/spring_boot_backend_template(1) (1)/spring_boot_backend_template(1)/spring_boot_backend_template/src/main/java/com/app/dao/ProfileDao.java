package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Profile;


public interface ProfileDao extends JpaRepository<Profile, Long> {	
	List<Profile> findByIsApproved(boolean isApproved);

	
}
