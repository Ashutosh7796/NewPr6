package com.example.Project06.Dto;

import com.example.Project06.Entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
public class GetSingleUserDto {

    private String fullName;
    private String email;
    private String moNumber;
    private String status;
    private LocalDate date;
    private String ref;
    private String gender;
    private Integer id;

    public GetSingleUserDto (User user) {
        this.fullName = user.getFullName();
        this.email = user.getEmail() ;
        this.moNumber = user.getMoNumber();
        this.status = user.getStatus();
        this.date = user.getDate();
        this.ref = user.getRef();
        this.gender = user.getGender();
        this.id = user.getUser_id();

    }
}
