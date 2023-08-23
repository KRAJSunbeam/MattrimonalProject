package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Images;


public interface ImageDao extends JpaRepository<Images, Long> {

}
