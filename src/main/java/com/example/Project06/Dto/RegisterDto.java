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
    private Integer id;
    public String roles;

    public RegisterDto(User user) {
        this.fullName = user.getFullName();
        this.email = user.getEmail();
        this.moNumber = user.getMoNumber();
        this.password = user.getPassword();
        this.status = user.getStatus();
        this.date = user.getDate();
        this.ref = user.getRef();
        this.gender = user.getGender();
        this.id=user.getId();
    }


}
