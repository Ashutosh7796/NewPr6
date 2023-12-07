package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class HrCallNotFoundException  extends RuntimeException {


        private HttpStatus httpStatus;


        public HrCallNotFoundException() {
        }

        public HrCallNotFoundException(String s) {
            super(s);
        }

        public HrCallNotFoundException(String message, HttpStatus httpStatus) {
            super(message);
            this.httpStatus = httpStatus;

        }
}
