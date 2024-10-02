package com.example.demo.common.dto;

import lombok.Getter;
import lombok.Setter;

public class LoginRequestDto {
    @Getter @Setter
    private String username;

    @Getter @Setter
    private String password;
}
