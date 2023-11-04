package com.example.Project06.Dto.Company;

import org.springframework.http.HttpStatus;

public class NoSuchCompanyFoundException extends RuntimeException{

        private HttpStatus httpStatus;

        public NoSuchCompanyFoundException() {
        }

        public NoSuchCompanyFoundException(String s) {
            super(s);
        }

        public NoSuchCompanyFoundException(String message, HttpStatus httpStatus) {
            super(message);
            this.httpStatus = httpStatus;

        }
    }


