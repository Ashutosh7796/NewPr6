package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class LiveProjectNotFoundException extends RuntimeException {

    private HttpStatus httpStatus;

    public LiveProjectNotFoundException(String message) {
        super(message);
    }

    public LiveProjectNotFoundException(String message, HttpStatus httpStatus) {

        super(message);
        this.httpStatus = httpStatus;
    }
}
