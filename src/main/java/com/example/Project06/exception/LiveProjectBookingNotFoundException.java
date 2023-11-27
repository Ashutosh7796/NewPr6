package com.example.Project06.exception;
import org.springframework.http.HttpStatus;

public class LiveProjectBookingNotFoundException extends RuntimeException {

    private HttpStatus httpStatus;

    public LiveProjectBookingNotFoundException(String message) {
        super(message);
    }

    public LiveProjectBookingNotFoundException(String message, HttpStatus httpStatus) {

        super(message);
        this.httpStatus = httpStatus;
    }
}
