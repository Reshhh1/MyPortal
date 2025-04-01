package com.example.MyPortal.controller;

import com.example.MyPortal.data.UserRepository;
import com.example.MyPortal.model.RegisterForm;
import com.example.MyPortal.exception.throwable.EntityAlreadyExistsException;
import com.example.MyPortal.exception.throwable.InvalidInputException;
import com.example.MyPortal.exception.ResponseMessage;
import com.example.MyPortal.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
    }

    @PostMapping()
    public void createUser(@Valid @RequestBody RegisterForm registerForm) {
        userService.createUser(registerForm);
    }

    @ExceptionHandler(value = InvalidInputException.class)
    public ResponseEntity<Object> exception(InvalidInputException exception) {
        return new ResponseEntity<>(new ResponseMessage(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EntityAlreadyExistsException.class)
    public ResponseEntity<Object> exception(EntityAlreadyExistsException exception) {
        return new ResponseEntity<>(new ResponseMessage(exception.getMessage()), HttpStatus.CONFLICT);
    }
}
