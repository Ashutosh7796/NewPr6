package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class DuplicateGSTNumberException extends RuntimeException {
    private HttpStatus httpStatus;


    public DuplicateGSTNumberException() {
    }

    public DuplicateGSTNumberException(String s) {
        super(s);
    }

    public DuplicateGSTNumberException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;


    }
}