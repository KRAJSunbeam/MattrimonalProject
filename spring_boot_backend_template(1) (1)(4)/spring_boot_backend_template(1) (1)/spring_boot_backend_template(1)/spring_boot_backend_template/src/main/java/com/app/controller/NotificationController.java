package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Notification;
import com.app.service.NotificationService;

@RestController
@RequestMapping("/Controller")
public class NotificationController {
	
	  @Autowired
	    private NotificationService notificationService;
	    
	    @GetMapping("/{uId}")
	    public ResponseEntity<List<Notification>> getUnreadNotifications(@PathVariable Long uId) {
	        List<Notification> notifications = notificationService.getUnreadNotifications(uId);
	        return ResponseEntity.ok(notifications);
	    }
	    
	    @PutMapping("/mark-as-read/{notificationId}")
	    public ResponseEntity<String> markNotificationAsRead(@PathVariable Long notificationId) {
	        notificationService.markNotificationAsRead(notificationId);
	        return ResponseEntity.ok("Notification marked as read.");
	    }
}
