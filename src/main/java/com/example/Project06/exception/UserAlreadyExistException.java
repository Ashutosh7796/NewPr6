package com.example.Project06.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UserAlreadyExistException extends RuntimeException{
    private String code;

    private String message;

}
