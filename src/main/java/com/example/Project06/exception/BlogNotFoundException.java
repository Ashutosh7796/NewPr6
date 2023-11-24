package com.example.Project06.exception;

import org.springframework.http.HttpStatus;

public class BlogNotFoundException extends RuntimeException{

        private HttpStatus httpStatus;


        public BlogNotFoundException() {
        }

        public BlogNotFoundException(String s) {
            super(s);
        }

        public BlogNotFoundException(String message, HttpStatus httpStatus) {
            super(message);
            this.httpStatus = httpStatus;

        }
}
