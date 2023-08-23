package com.app.service;

import java.util.List;

import com.app.entities.MyList;
import com.app.entities.User;
import com.app.payload.MyListDto;



public interface MyListService {
	void getList( MyListDto list);
}
