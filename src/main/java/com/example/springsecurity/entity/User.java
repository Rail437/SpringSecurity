package com.example.springsecurity.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String login;

    private String password;

    private String email;

    private Integer score;


    public User() {}

    public User(Long id,String username) {
        this.id = id;
        this.username = username;
    }

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    public void incrementScore(Integer s) {
        this.score = score + s;
    }

    public void decrementScore(Integer i) {
        this.score -= i;
    }
}
