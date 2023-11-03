package com.example.Project06.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserAlreadyExistException extends RuntimeException{

    public UserAlreadyExistException(String s) {
    }

    public UserAlreadyExistException(String s, String usernameAlreadyExists) {
    }
}
