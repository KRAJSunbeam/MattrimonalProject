package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Profile;

public interface ProfileDao extends JpaRepository<Profile, Long> {	

}
