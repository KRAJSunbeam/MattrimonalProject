package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.User;
import com.app.payload.MyListDto;
import com.app.service.MyListService;
import com.app.service.UserService;

@RestController
@RequestMapping("/MyList")
@CrossOrigin(origins = "http://localhost:3000")
public class MyListController {
	@Autowired
	private MyListService listService;
	
	
	@PostMapping
	public void listAllUser(@RequestBody MyListDto list){
		listService.getList(list);
		
	}
}
