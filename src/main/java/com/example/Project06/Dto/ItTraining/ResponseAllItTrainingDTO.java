package com.example.Project06.Dto.ItTraining;

import com.example.Project06.Dto.ItTrianningBooking.ItTrianningBookingDto;
import lombok.Data;

import java.util.List;
@Data
public class ResponseAllItTrainingDTO {
    private String message;
    private List<ItTrainingDTO> list;
    private String exception;

    public ResponseAllItTrainingDTO(String message)
    {
        this.message = message;
    }
}
