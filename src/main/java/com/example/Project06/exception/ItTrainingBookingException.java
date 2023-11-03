package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class ItTrainingBookingException extends RuntimeException{

    private HttpStatus httpStatus;

    public ItTrainingBookingException(String message) {
        super(message);
    }

    public ItTrainingBookingException(String message, HttpStatus httpStatus) {

        super(message);
        this.httpStatus = httpStatus;
    }

}