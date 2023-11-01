package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class ItTrainingNotFoundException extends RuntimeException{

    private HttpStatus httpStatus;

    public ItTrainingNotFoundException(String message) {
        super(message);
    }

    public ItTrainingNotFoundException(String message, HttpStatus httpStatus) {

        super(message);
        this.httpStatus = httpStatus;
    }

}
