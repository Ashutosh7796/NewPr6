package com.example.Project06.Dto.LiveProject;

import lombok.Data;

@Data
public class ResponseSingleLiveProjectDto {

    private String message;
    private Object object;
    private String exception;

    public ResponseSingleLiveProjectDto(String message)
    {
        this.message = message;
    }


}
