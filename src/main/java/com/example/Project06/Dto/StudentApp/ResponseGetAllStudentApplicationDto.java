package com.example.Project06.Dto.StudentApp;

import com.example.Project06.Dto.Plan.PlanDto;
import lombok.Data;

import java.util.List;
@Data
public class ResponseGetAllStudentApplicationDto {

    private String message;
    private List<PlanDto> list;
    private String exception;

    public ResponseGetAllStudentApplicationDto(String message) {
        this.message = message;
    }
}
