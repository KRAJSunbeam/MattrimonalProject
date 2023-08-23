package com.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.NotificationDao;
import com.app.entities.Notification;
import com.app.entities.NotificationType;
import com.app.entities.User;

@Service
@Transactional
public class NotificationService {
	
	   @Autowired
	    private NotificationDao notificationDao;
	   public List<Notification> getUserNotifications(User user) {
	        List<Notification> notifications = notificationDao.findByUserOrderByTimestampDesc(user);
	        return notifications;
	    }

	    public void markNotificationAsRead(Long notificationId) {
	        Notification notification = notificationDao.getById(notificationId);
	        notification.setRead(true);
	        notificationDao.save(notification);
	    }
	    
	  

	    public void cleanUpOldNotifications(User user) {
	        List<Notification> notifications = notificationDao.findByUserOrderByTimestampDesc(user);

	        int maxNotifications = 50; // Example: Limit to 50 notifications
	        if (notifications.size() > maxNotifications) {
	            // Delete older notifications to maintain the limit
	            for (int i = maxNotifications; i < notifications.size(); i++) {
	                notificationDao.delete(notifications.get(i));
	            }
	        }
	    }
	        
	        public void createNotification(Long userId, String message, NotificationType type) {
	            Notification notification = new Notification();
	          
	            notification.setMessage(message);
	            notification.setType(type);
	            notification.setCreatedAt(LocalDateTime.now());
	            notification.setRead(false);
	            notificationDao.save(notification);
	        }
	        
	        public List<Notification> getUnreadNotifications(Long uid) {
	            return notificationDao.findByuIdAndIsReadOrderByCreatedAtDesc(uid, false);
	        }
	        
	     
}
