package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class UniversityDataNotFound extends RuntimeException {

    private HttpStatus httpStatus;

    public UniversityDataNotFound(String message) {
        super(message);
    }

    public UniversityDataNotFound(String message, HttpStatus httpStatus) {

        super(message);
        this.httpStatus = httpStatus;
    }
}
