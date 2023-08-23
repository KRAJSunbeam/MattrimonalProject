package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Message;
import com.app.payload.MessagePayload;
import com.app.service.MessageServiceimpl;

@RestController
@RequestMapping("/Adminmessage")
public class AdminMessageController {
    @Autowired
    private MessageServiceimpl messageService;

    @GetMapping("/broadcast-messages")
    public List<Message> getBroadcastMessages() {
        return messageService.getBroadcastMessages();
    }

    @PostMapping("/broadcast-messages")
    public void sendBroadcastMessage(@RequestBody MessagePayload messagePayload) {
        messageService.sendBroadcastMessage(messagePayload.getTitle(), messagePayload.getContent());
    }

    @PostMapping("/newsletters")
    public void sendNewsletter(@RequestBody MessagePayload messagePayload) {
        messageService.sendNewsletter(messagePayload.getTitle(), messagePayload.getContent());
    }
}
