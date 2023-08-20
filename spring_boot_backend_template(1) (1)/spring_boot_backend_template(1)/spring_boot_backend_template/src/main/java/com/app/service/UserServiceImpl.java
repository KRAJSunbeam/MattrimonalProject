package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custexception.ResourceNotFoundException;
import com.app.dao.ProfileDao;
import com.app.dao.UserDao;
import com.app.entities.Profile;
import com.app.entities.User;
import com.app.payload.AuthRequest;
import com.app.payload.AuthResponce;
@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<User> getUsers() {
		return dao.findAll();
	}

	@Override
	public String addUserDetails(AuthRequest user) {
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

}
