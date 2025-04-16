package com.example.MyPortal.session.service;

import com.example.MyPortal.util.security.JWTService;
import com.example.MyPortal.session.model.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    public String createSession(LoginForm loginForm) {
        if(verifyUser(loginForm.email(), loginForm.password())) {
            return jwtService.generateToken(loginForm.email());
        } else {
            return "Failed";
        }
    }

    private boolean verifyUser(String email, String password) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        ).isAuthenticated();
    }
}
