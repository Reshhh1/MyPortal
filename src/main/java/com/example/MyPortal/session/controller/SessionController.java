package com.example.MyPortal.session.controller;

import com.example.MyPortal.session.model.LoginForm;
import com.example.MyPortal.session.service.SessionService;
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
