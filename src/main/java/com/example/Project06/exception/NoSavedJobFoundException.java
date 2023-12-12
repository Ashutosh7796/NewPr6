package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class NoSavedJobFoundException extends RuntimeException{

    private HttpStatus httpStatus;


    public NoSavedJobFoundException() {
    }

    public NoSavedJobFoundException(String s) {
        super(s);
    }

    public NoSavedJobFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;

    }
}
