package com.example.MyPortal.user.service;

import com.example.MyPortal.user.model.BusinessUser;
import com.example.MyPortal.user.model.RegisterForm;
import com.example.MyPortal.user.data.UserEntity;
import com.example.MyPortal.user.data.UserRepository;
import com.example.MyPortal.exception.throwable.EntityAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(RegisterForm registerForm) {
        BusinessUser businessUser = new BusinessUser(registerForm.email(), registerForm.password());
        businessUser.validate();
        if(userRepository.existsByEmail(businessUser.getEmail())) {
            throw new EntityAlreadyExistsException("The given email is already registered");
        }
        businessUser.setPassword(passwordEncoder.encodePassword(businessUser.getPassword()));
        userRepository.save(new UserEntity(businessUser.getEmail(), businessUser.getPassword()));
    }

}
