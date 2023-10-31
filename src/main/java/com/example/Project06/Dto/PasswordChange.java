package com.example.Project06.Dto;


import lombok.Data;

@Data
public class PasswordChange {

    private String oldPassword;
    private String newPassword;
    private String confirmPassword;

}

