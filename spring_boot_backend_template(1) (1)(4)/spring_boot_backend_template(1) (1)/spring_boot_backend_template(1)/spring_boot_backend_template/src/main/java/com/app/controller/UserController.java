package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Profile;
import com.app.entities.User;
import com.app.payload.UserApiResponse;
import com.app.payload.UserAuthRequest;
import com.app.service.ProfileService;
import com.app.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> listAllUser(){
		return userService.getUsers();
	}
	
	public UserController() {
	System.out.println("in ctor of "+getClass());
	}
	
	@PostMapping
	public ResponseEntity<?> addNewProfile(@RequestBody UserAuthRequest payloadDTO ){
		
		return ResponseEntity.ok(userService.addUserDetails(payloadDTO));
	}
	
	@DeleteMapping("/{id}")
	public UserApiResponse deleteProfile(@PathVariable Long id) {
		return new UserApiResponse(userService.deleteUserDetails(id));
	}
}
