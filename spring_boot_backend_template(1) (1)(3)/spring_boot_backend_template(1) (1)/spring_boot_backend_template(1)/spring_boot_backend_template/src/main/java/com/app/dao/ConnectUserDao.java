package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.ConnectUser;
import com.app.entities.ConnectUserStatus;
import com.app.entities.Profile;
import com.app.entities.User;



public interface ConnectUserDao extends JpaRepository<ConnectUser, Long> {
   List<ConnectUser> findBySenderOrReceiverAndStatus(User user1, User user2, ConnectUserStatus status);

static ConnectUser findBySenderAndReceiver(Profile currentUser, Profile profile) {
	// TODO Auto-generated method stub
	return null;
}
}