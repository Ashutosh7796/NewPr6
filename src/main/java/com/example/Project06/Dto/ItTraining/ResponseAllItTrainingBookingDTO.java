package com.example.Project06.Dto.ItTraining;

import com.example.Project06.Dto.ItTrianningBooking.ItTrianningBookingDto;
import lombok.Data;

import java.util.List;

@Data
public class ResponseAllItTrainingBookingDTO {

    private String status;
    private List<ItTrianningBookingDto> objects;
}
