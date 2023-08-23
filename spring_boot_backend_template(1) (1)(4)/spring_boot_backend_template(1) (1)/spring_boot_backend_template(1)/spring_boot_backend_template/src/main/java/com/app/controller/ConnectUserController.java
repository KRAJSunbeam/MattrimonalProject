package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.payload.ConnectRequestDto;
import com.app.service.ConnectUserService;

@RestController
@RequestMapping("/Connect")
@CrossOrigin(origins = "http://localhost:3000")
public class ConnectUserController {
    @Autowired
    private ConnectUserService connectionService;
    
    @PostMapping("/send-request")
    public ResponseEntity<String> sendConnectionRequest(@RequestBody ConnectRequestDto requestDto) {
        connectionService.sendConnectRequest(requestDto);
        return ResponseEntity.ok("Request sent successfully!");
    }
    
    @PutMapping("/accept-request/{requestId}")
    public ResponseEntity<String> acceptConnectionRequest(@PathVariable Long requestId) {
        connectionService.acceptConnectRequest(requestId);
        return ResponseEntity.ok("Request accepted successfully!");
    }
}
