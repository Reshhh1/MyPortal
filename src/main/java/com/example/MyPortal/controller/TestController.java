package com.example.MyPortal.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/unauthorized-path")
public class TestController {

    @PostMapping
    public String testEndPoint() {
        return "Successfully requested";
    }

}
