package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class JobNotFoundException extends RuntimeException{
    private HttpStatus httpStatus;

    public JobNotFoundException(String message) {
        super(message);
    }

    public JobNotFoundException(String message, HttpStatus httpStatus) {

        super(message);
        this.httpStatus = httpStatus;
    }
}
