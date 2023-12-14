package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class JobSavedAlreadyException extends RuntimeException{

    private HttpStatus httpStatus;

    public JobSavedAlreadyException(String message) {
        super(message);
    }

    public JobSavedAlreadyException(String message, HttpStatus httpStatus) {

        super(message);
        this.httpStatus = httpStatus;
    }
}
