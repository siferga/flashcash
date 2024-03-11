package com.example.project.services;

import com.example.project.model.User;
import com.example.project.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;

public class SessionService {
    private final UserRepository userRepository;
    /*constructor initialises SessionService with an UserRepo instance */
    public SessionService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   public User sessionUser(){
        org.springframework.security.core.userdetails.User springUser =
                (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findUserByMail(springUser.getUsername())
                .orElseThrow(() -> new RuntimeException("email not found"));
    }


}
