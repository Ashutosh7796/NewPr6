package com.example.Project06.Service;

import com.example.Project06.Dto.BootcampBookingsDto.BootcampBookingsDto;

import java.time.OffsetDateTime;
import java.util.List;

public interface IBootcampBookings {
    void save(BootcampBookingsDto bootcampBookingsDto);

    List<BootcampBookingsDto> getAllBootcampDetails();

    BootcampBookingsDto getById(Integer bootcampId);

    String updateBootcampDetails(OffsetDateTime date, String status, Integer bootcampbookingId);

    String deleteById(Integer bootcampbookingId);
}
