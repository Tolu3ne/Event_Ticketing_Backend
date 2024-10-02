package com.example.demo.model;

import com.example.demo.common.dto.CreateUserDto;
import com.example.demo.common.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter @Setter
    private long id;

    @Getter @Setter
    @Column(unique=true)
    private String username;

    @Getter @Setter
    private String password;

    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;

    @Getter @Setter
    @Column(unique=true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private UserRole userRole; 

    protected User() {}

    public User(String username, String password, String firstName, String lastName, String email, UserRole userRole) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userRole = userRole;
    }

    public User(CreateUserDto userDto) {
        this.username = userDto.getUsername();
        this.password = userDto.getPassword();
        this.firstName = userDto.getFirstName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        this.userRole = userDto.getUserRole();
    }
}


