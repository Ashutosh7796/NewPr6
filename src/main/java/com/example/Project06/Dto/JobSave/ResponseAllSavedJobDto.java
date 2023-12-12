package com.example.Project06.Dto.JobSave;

import lombok.Data;

import java.util.List;

@Data
public class ResponseAllSavedJobDto {
    private String message;
    private List<GetSingleJobSave> list;
    private String exception;

    public ResponseAllSavedJobDto(String message){
        this.message=message;
    }
}
