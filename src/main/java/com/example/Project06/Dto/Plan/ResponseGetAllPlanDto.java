package com.example.Project06.Dto.Plan;

import lombok.Data;

import java.util.List;
@Data
public class ResponseGetAllPlanDto {

    private String message;
    private List<PlanDto> list;
    private String exception;

    public ResponseGetAllPlanDto(String message) {
        this.message = message;
    }
}
