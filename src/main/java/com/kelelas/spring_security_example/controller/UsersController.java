package com.kelelas.spring_security_example.controller;

import com.kelelas.spring_security_example.dto.UsersDTO;
import com.kelelas.spring_security_example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/")
public class UsersController {
    UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public UsersDTO getAllUser(){
        log.info("{}",userService.getAllUsers());
        return userService.getAllUsers();
    }
}
