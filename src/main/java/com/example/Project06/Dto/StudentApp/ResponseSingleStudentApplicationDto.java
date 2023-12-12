package com.example.Project06.Dto.StudentApp;

import lombok.Data;

@Data
public class ResponseSingleStudentApplicationDto {

    private String message;
    private Object object;
    private String exception;

    public ResponseSingleStudentApplicationDto(String message)
    {
        this.message = message;
    }

}
