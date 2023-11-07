package com.example.Project06.Dto.ItTrianningBooking;

import lombok.Data;
import java.util.List;
@Data
public class ResponseAllItTrainingBookingDTO {
    private String message;
    private List<ItTrianningBookingDto> list;
    private String exception;

    public ResponseAllItTrainingBookingDTO(String message)
    {
        this.message = message;
    }
}
