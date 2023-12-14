package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class NoMatchingResultFound extends RuntimeException{

    private HttpStatus httpStatus;

    public NoMatchingResultFound(String message) {
        super(message);
    }

    public NoMatchingResultFound(String message, HttpStatus httpStatus) {

        super(message);
        this.httpStatus = httpStatus;
    }
}
