package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.MyList;


public interface MyListDao extends JpaRepository<MyList, Long> {	

}

