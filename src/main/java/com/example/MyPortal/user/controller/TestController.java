package com.example.MyPortal.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/testing-path")
public class TestController {

    @PostMapping
    public String testEndPoint() {
        return "Successfully unauthorized requested";
    }

    @GetMapping
    public String testEndPoint2() {
        return "Successfully authorized requested";
    }
}
