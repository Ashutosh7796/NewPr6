package com.example.Project06.Dto;

import lombok.Data;

@Data
public class ResponseProfileLevelDto {
    private String status;
    private String response;
    private String exception;

    public ResponseProfileLevelDto(String status) {
        this.status = status;
    }

}
