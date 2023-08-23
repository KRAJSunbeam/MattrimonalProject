package com.app.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custexception.ResourceNotFoundException;
import com.app.dao.NotificationDao;

import com.app.dao.UserDao;

import com.app.entities.User;
import com.app.payload.LoginDto;
import com.app.payload.UserAuthRequest;
import com.app.payload.UserAuthResponce;
@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;

	@Autowired
	private ModelMapper modelMapper;
	
	   @Autowired
	    private NotificationDao notificationDao;
	
	@Override
	public List<User> getUsers() {
		return dao.findAll();
	}

	@Override
	public String addUserDetails(UserAuthRequest user) {
		User pro =dao.save(modelMapper.map(user,User.class));
		return "User Added SuccessFully";
	}

	@Override
	public String deleteUserDetails(Long id) {
		User pro = dao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid pro ID !!!!!"));
		dao.deleteById(id);
		return "profile details deleted successfully!";
	}

	@Override
	public String updateUserDetails(User user) {
		User pro = dao.findById(user.getUser_Id()).orElseThrow(() -> new ResourceNotFoundException("Invalid pro ID !!!!!"));
		dao.save(user);
		return "project details update successfully!";
	}

	@Override
	public String loginUser(LoginDto ld) {
User u = dao.findByEmailAndPassword(ld.getEmail(), ld.getPassword()).orElseThrow(()-> new RuntimeException("User Not Found.."));
		return "Login Successfully";
	}
	
	@Override
    public List<User> getProfilesPendingApproval() {
        return dao.findByIsApproved(false);
    }
	

	
	
	  public void blockUser(Long id) {
			User pro = dao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid pro ID !!!!!"));
	        pro.setBlocked(true);
	        dao.save(pro);
	    }  

	   public void unblockUser(Long id) {
		   User pro = dao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid pro ID !!!!!"));
	        pro.setBlocked(false);
	        dao.save(pro);
	    }
}
