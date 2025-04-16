package com.example.MyPortal.ai.service;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final OllamaChatModel chatModel;

    public ChatService(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getResponse(String prompt) {
        return chatModel.call(prompt);
    }
}
