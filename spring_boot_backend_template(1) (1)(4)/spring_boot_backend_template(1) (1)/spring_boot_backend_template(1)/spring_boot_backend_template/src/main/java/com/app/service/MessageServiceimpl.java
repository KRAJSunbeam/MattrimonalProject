package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.MessageDao;
import com.app.entities.Message;

@Service
@Transactional
public class MessageServiceimpl {
	
	 @Autowired
	    private MessageDao messageDao;

	    public List<Message> getBroadcastMessages() {
	        return messageDao.findByIsBroadcastOrderByTimestampDesc(true);
	    }

	    public void sendBroadcastMessage(String title, String content) {
	        Message message = new Message();
	        message.setTitle(title);
	        message.setContent(content);
	        message.setBroadcast(true);
	        messageDao.save(message);
	    }

	    public void sendNewsletter(String title, String content) {
	        Message message = new Message();
	        message.setTitle(title);
	        message.setContent(content);
	        message.setBroadcast(false);
	        messageDao.save(message);
	    }
	}

	


