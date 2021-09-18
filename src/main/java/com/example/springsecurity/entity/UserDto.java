package com.example.springsecurity.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String login;
    private String password;
    private String Email;

    public UserDto(Long id, String name, String login, String password, String mail) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.Email = mail;
    }

    public static UserDto valueOf(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getLogin(),
                user.getPassword(),
                user.getEmail()
        );
    }

    public User mapToUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(name);
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(Email);
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
