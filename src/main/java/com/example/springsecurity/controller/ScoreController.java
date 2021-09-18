package com.example.springsecurity.controller;

import com.example.springsecurity.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Id;
import java.security.Principal;


@RequestMapping("/app/score")
@RestController
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping("/inc")
    public String increment(@AuthenticationPrincipal User user){
        if(user == null){
            return "user = null";
        }
        if(user.getUsername() == null){
            return "user.getUsername() = null";
        }
        return scoreService.increment(user.getUsername());
    }

    @GetMapping("/dec")
    public String decrement(@AuthenticationPrincipal User user){
        if(user == null){
            return "user = null";
        }
        if(user.getUsername() == null){
            return "user.getUsername() = null";
        }
        return scoreService.decrement(user.getUsername());
    }

    @GetMapping("/get/current")
    public String getScore(@AuthenticationPrincipal User user){
        if(user == null){
            return "user = null";
        }
        if(user.getUsername().isEmpty()){
            return "user.getUsername() = null";
        }
        return scoreService.getScoreByUser(user.getUsername());
    }

    @GetMapping("/get/{id}")
    public String scoreById(@PathVariable Long id){
        if(id == null){
            return "id = null";
        }
        return scoreService.getScoreById(id);
    }
}
