package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class InvalidHRRegistrationException extends RuntimeException{

    private HttpStatus httpStatus;


    public InvalidHRRegistrationException() {
    }

    public InvalidHRRegistrationException(String s) {
        super(s);
    }

    public InvalidHRRegistrationException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;


    }
}
