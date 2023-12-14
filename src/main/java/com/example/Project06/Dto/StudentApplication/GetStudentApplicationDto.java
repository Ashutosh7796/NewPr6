package com.example.Project06.Dto.StudentApplication;

import lombok.Data;

import java.util.List;

@Data
public class GetStudentApplicationDto {
    private String status;

    private List <StudentApplicationDto> Response;

    public GetStudentApplicationDto(String status) {
        this.status = status;
    }

}
