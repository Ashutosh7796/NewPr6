package com.example.Project06.Dto.BootcampBookingsDto;

import com.example.Project06.Entity.BootcampBookings;
import lombok.Data;

import java.util.List;
@Data
public class ResponseAllBootcampBookingsDto {
    private String status;
    private List<BootcampBookingsDto> response;

    public ResponseAllBootcampBookingsDto(String status) {
        this.status = status;
    }
}
