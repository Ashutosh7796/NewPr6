package com.example.Project06.Dto.ItTrianningBooking;

import lombok.Data;

@Data
public class ResponseSingleItTrainingBookingDTO {

    private String message;
    private Object object;
    private String exception;

    public ResponseSingleItTrainingBookingDTO(String message)
    {
        this.message = message;
    }
}
