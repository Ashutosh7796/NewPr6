package com.example.Project06.exception;

public class BannerNotFoundByIdException extends RuntimeException {
    public BannerNotFoundByIdException(String message) {
        super(message);
    }
}
