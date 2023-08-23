package com.app.service;

import com.app.payload.ConnectRequestDto;

public interface ConnectUserService {

	
	   public void sendConnectRequest(ConnectRequestDto requestDto);
	     
	    
	    public void acceptConnectRequest(Long requestId);
}
