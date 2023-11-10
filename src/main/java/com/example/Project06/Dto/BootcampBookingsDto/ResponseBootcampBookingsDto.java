package com.example.Project06.Dto.BootcampBookingsDto;

import com.example.Project06.Entity.BootcampBookings;
import lombok.Data;

@Data
public class ResponseBootcampBookingsDto {
    private String status;
    private BootcampBookingsDto response;

    public ResponseBootcampBookingsDto(String status) {
        this.status = status;
    }
}
