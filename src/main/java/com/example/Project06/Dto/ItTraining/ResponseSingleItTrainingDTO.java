package com.example.Project06.Dto.ItTraining;

import lombok.Data;

@Data
public class ResponseSingleItTrainingDTO {

    private String message;
    private Object object;
    private String exception;

    public ResponseSingleItTrainingDTO(String message)
    {
        this.message = message;
    }
}
