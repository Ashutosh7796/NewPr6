package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class HrNotFoundException  extends RuntimeException{

        private HttpStatus httpStatus;


        public HrNotFoundException() {
        }

        public HrNotFoundException(String s) {
            super(s);
        }

        public HrNotFoundException(String message, HttpStatus httpStatus) {
            super(message);
            this.httpStatus = httpStatus;

        }
}
