package com.example.Project06.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CompanyRegistrationDto {
    private String fullName;
    private String email;
    private String moNumber;
    private String companyName;
    private String password;
    private String role;
    private String gestnNo;
    private String companyServices;
    private String companyType;
    private String companyLevel;
    private String logo;
    private LocalDate date;
    private String officeAddress;
    private String companyLocations;
    private String oneCompanyDoc;
    private String refNo;
    private String status;
}
