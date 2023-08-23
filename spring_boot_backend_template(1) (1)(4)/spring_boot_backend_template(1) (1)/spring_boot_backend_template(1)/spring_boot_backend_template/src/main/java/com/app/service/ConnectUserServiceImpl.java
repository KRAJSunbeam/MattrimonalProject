package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ConnectUserDao;
import com.app.dao.UserDao;
import com.app.entities.ConnectUser;
import com.app.entities.ConnectUserStatus;
import com.app.entities.User;
import com.app.payload.ConnectRequestDto;

@Service
@Transactional
public class ConnectUserServiceImpl implements  ConnectUserService {

	
	 @Autowired
	    private ConnectUserDao connectUserDao;
	    @Autowired
	    private UserDao userDao;
	
	
	@Override
	public void sendConnectRequest(ConnectRequestDto requestDto) {
		  User sender = userDao.getById(requestDto.getSenderId());
	        User receiver = userDao.getById(requestDto.getReceiverId());
	        
	        ConnectUser connection = new ConnectUser();
	        connection.setSender(sender);
	        connection.setReceiver(receiver);
	        connection.setStatus(ConnectUserStatus.PENDING);
	        
	        connectUserDao.save(connection);
		
	}

	@Override
	public void acceptConnectRequest(Long requestId) {
		
		  ConnectUser connection = connectUserDao.getById(requestId);
	        connection.setStatus(ConnectUserStatus.ACCEPTED);
	        connectUserDao.save(connection);
	}
	
	

		
}
