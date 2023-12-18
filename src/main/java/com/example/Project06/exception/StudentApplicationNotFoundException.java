package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class StudentApplicationNotFoundException extends RuntimeException {
    private HttpStatus httpStatus;

    public StudentApplicationNotFoundException(String message) {
        super(message);
    }

    public StudentApplicationNotFoundException(String message, HttpStatus httpStatus) {

        super(message);
        this.httpStatus = httpStatus;
    }

}