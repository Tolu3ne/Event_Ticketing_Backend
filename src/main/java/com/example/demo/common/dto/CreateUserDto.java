package com.example.demo.common.dto;

import com.example.demo.common.enums.UserRole;

import lombok.Getter;
import lombok.Setter;

public class CreateUserDto {
    @Getter @Setter
    private String username;

    @Getter @Setter
    private String password;

    @Getter @Setter
    private String firstName;

    @Getter @Setter
    private String lastName;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private UserRole userRole = UserRole.ROLE_USER;
}
