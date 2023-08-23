package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.entities.SuccessStory;

public interface SuccessStoryDao extends JpaRepository<SuccessStory, Long>{

}
