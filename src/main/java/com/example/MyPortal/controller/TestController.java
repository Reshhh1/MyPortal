package com.example.MyPortal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/test")
public class TestController {

    @GetMapping
    public String testEndPoint() {
        return "Test";
    }
}
