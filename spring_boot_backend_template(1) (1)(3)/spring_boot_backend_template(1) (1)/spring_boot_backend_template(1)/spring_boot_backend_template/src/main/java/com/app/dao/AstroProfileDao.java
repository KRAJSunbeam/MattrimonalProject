package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.AstroProfile;



public interface AstroProfileDao extends JpaRepository<AstroProfile, Long>{

}
