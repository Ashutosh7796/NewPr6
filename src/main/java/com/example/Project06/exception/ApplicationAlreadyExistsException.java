package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class ApplicationAlreadyExistsException extends RuntimeException{

    private HttpStatus httpStatus;

    public ApplicationAlreadyExistsException(String message) {
        super(message);
    }

    public ApplicationAlreadyExistsException(String message, HttpStatus httpStatus) {

        super(message);
        this.httpStatus = httpStatus;
    }
}
