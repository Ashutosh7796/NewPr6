package com.example.Project06.Dto.InterviewSchedule;

import lombok.Data;

@Data
public class ResponseGetSingleInterview {
    private String message;
    private Object object;
    private String exception;
    public ResponseGetSingleInterview(String message){
        this.message=message;
    }
}
