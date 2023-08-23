package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.payload.LoginDto;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {

	@Autowired
	private UserService userService;
	@PostMapping("/login")
	public String loginUser(@RequestBody LoginDto ld){
		String resp = userService.loginUser(ld);
		return resp;
	}
}
