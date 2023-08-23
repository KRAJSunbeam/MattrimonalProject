package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Notification;
import com.app.entities.User;

public interface NotificationDao extends JpaRepository<Notification, Long> {
	    List<Notification> findByUserOrderByTimestampDesc(User user);

		
		List<Notification> findByuIdAndIsReadOrderByCreatedAtDesc(Long uid, boolean isRead);



	 
	}

