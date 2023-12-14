package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class ApplicationNotFoundException extends RuntimeException{

    private HttpStatus httpStatus;


    public ApplicationNotFoundException() {
    }

    public ApplicationNotFoundException(String s) {
        super(s);
    }

    public ApplicationNotFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;

    }
}
