package com.nexxen.identityService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private com.nexxen.identityService.service.UserService userService;

    @GetMapping("/users")
    public List<com.nexxen.identityService.model.User> getUsers(){
        return userService.getUsers();
    }


}
