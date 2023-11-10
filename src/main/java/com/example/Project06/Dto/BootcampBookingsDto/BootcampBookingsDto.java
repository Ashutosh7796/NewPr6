package com.example.Project06.Dto.BootcampBookingsDto;

import com.example.Project06.Entity.Bootcamp;
import com.example.Project06.Entity.BootcampBookings;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
@Data
@NoArgsConstructor
public class BootcampBookingsDto {
    private OffsetDateTime date;


    private Integer userId;


    private String status;


    private Integer bootcampBootcampID;

    public BootcampBookingsDto(BootcampBookings bootcampBookings) {
        this.date = bootcampBookings.getDate();
        this.userId = bootcampBookings.getUserId();
        this.status = bootcampBookings.getStatus();
        this.bootcampBootcampID = bootcampBookings.getBootcampBootcamp().getBootcampId();
    }
}
