package com.itechartgroup.telemed.security.web;

import com.itechartgroup.telemed.exception.ResourceNotFoundException;
import com.itechartgroup.telemed.security.CurrentUser;
import com.itechartgroup.telemed.security.UserPrincipal;
import com.itechartgroup.telemed.security.entity.User;
import com.itechartgroup.telemed.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}