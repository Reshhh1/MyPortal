package com.example.MyPortal.model;

import com.example.MyPortal.exception.throwable.InvalidInputException;

import java.util.regex.Pattern;

public class BusinessUser {
    private String email;
    private String password;

    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 255;

    public BusinessUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void validate() {
        validatePassword();
    }

    private void validatePassword() {
        Pattern passwordPattern = Pattern.compile("(?=.*[0-9])");
        if(password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            throw new InvalidInputException(String.format("The password field should contain between %s and %s characters", MAX_PASSWORD_LENGTH, MAX_PASSWORD_LENGTH));
        }
        if(!passwordPattern.matcher(password).find()) {
            throw new InvalidInputException("The password field requires atleast 1 number");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
