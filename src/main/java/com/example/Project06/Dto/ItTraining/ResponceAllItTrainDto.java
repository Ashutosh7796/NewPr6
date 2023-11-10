package com.example.Project06.Dto.ItTraining;

import com.example.Project06.Dto.ItTrianningBooking.ItTrianningBookingDto;
import lombok.Data;

import java.util.List;

@Data
public class ResponceAllItTrainDto {
    private String message;
    private List<ItTrianningBookingDto> objects;
    private String exception;

    public ResponceAllItTrainDto(String message)
    {
        this.message = message;
    }

}
