package com.example.springsecurity.controller;

import com.example.springsecurity.entity.UserDto;
import com.example.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/reg")
    public String reg(){
        return "registrate";
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> addUser(UserDto userDto) {
        return userService.saveUser(userDto)?
                new ResponseEntity<>(HttpStatus.CREATED):
                new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
