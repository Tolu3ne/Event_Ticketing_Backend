package com.example.demo.exception;

import lombok.Getter;
import lombok.Setter;

public class ExceptionObject {
    @Getter @Setter
    private String message;

    public ExceptionObject(String message) {
        this.message = message;
    }
}
