package com.example.Project06.Dto;


import com.example.Project06.Entity.User;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

public class RegisterDto {

    private String fullName;
    private String email;
    private String moNumber;
    private String password;
    private String status;
    private LocalDate date;
    private String ref;
    private String gender;

    public RegisterDto(String fullName, String email, String moNumber, String password, String status, LocalDate date, String ref, String gender, String roles) {
        this.fullName = fullName;
        this.email = email;
        this.moNumber = moNumber;
        this.password = password;
        this.status = status;
        this.date = date;
        this.ref = ref;
        this.gender = gender;
        this.roles = roles;
    }

    public String roles;


}
