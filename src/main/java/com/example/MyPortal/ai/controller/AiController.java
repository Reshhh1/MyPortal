package com.example.MyPortal.ai.controller;

import com.example.MyPortal.ai.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController {

    private final ChatService chatService;

    @Autowired
    public AiController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/ai")
    public String getResponse(@RequestParam String prompt) {
        return chatService.getResponse(prompt);
    }
}
