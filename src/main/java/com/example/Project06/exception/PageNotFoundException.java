package com.example.Project06.exception;

public class PageNotFoundException extends RuntimeException {
    public PageNotFoundException(String pageNotFound) {
            super(pageNotFound);
        }

}

