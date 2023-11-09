package com.example.Project06.Dto.Job;

import lombok.Data;

@Data
public class ResponseSingleJobDto {
    private String message;
    private Object object;
    private String exception;

    public ResponseSingleJobDto(String message)
    {
        this.message = message;
    }
}
