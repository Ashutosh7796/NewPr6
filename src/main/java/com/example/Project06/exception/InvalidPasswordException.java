package com.example.Project06.exception;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException() {
    }

    public InvalidPasswordException(String invalidPassword) {
        super(invalidPassword);
    }
}
