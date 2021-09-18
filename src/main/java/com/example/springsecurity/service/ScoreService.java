package com.example.springsecurity.service;

import com.example.springsecurity.entity.User;
import com.example.springsecurity.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class ScoreService {
    private UserRepository userRepository;

    public ScoreService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private User getUserBylogin(String login) {
        return userRepository.findByLogin(login);
    }

    public String increment(String username) {
        if(username == null){
            return "Username: null";
        }
        User user = getUserBylogin(username);
        user.incrementScore(10);
        userRepository.save(user);
        return "Ваш баланс: " + user.getScore();
    }

    public String decrement(String username) {
        if(username == null){
            return "Username: null";
        }
        User user = getUserBylogin(username);
        user.decrementScore(10);
        userRepository.save(user);
        return "Ваш баланс: " + user.getScore();

    }

    public String getScoreByUser(String username) {
        if(username == null){
            return "Username: null";
        }
        return "Ваш баланс: " + getUserBylogin(username).getScore().toString();
    }

    public String getScoreById(Long id) {
        User user = userRepository.findById(id).get();
        return "Баланс " + user.getLogin() +" составляет: " + user.getScore().toString();
    }
}
