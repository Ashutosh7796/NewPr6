package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class EventNotFoundException extends RuntimeException{

    private HttpStatus httpStatus;


    public EventNotFoundException() {
    }

    public EventNotFoundException(String s) {
        super(s);
    }

    public EventNotFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;

    }
}
