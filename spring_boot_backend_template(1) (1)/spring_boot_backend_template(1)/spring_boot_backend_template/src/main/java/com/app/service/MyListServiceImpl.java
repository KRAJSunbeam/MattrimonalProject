package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custexception.ResourceNotFoundException;
import com.app.dao.MyListDao;
import com.app.dao.UserDao;
import com.app.entities.MyList;
import com.app.entities.User;
import com.app.payload.MyListDto;

@Service
@Transactional
public class MyListServiceImpl implements MyListService{
	
	@Autowired
	private MyListDao listDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public void getList(MyListDto list) {
       User userowner=userDao.findById(list.getOwnuserid()).orElseThrow(() -> new RuntimeException("User Not Found"));
       User user=userDao.findById(list.getUserid()).orElseThrow(() -> new RuntimeException("User Not Found"));
       MyList lists=new MyList();
       lists.setUser(userowner);
       lists.setUser2(list.getUserid());
       listDao.save(lists);       
	}
	
	
}
