package com.example.MyPortal.controller;

import com.example.MyPortal.model.LoginForm;
import com.example.MyPortal.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/sessions")
public class SessionController {

    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping
    public String createSession(@RequestBody LoginForm loginForm) {
        return sessionService.createSession(loginForm);
    }
}
