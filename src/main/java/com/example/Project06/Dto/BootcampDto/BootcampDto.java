package com.example.Project06.Dto.BootcampDto;

import com.example.Project06.Entity.BootcampBookings;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class BootcampDto {

    private String bootcampTital;

    private String bootcampDetails;

    private LocalDate date;

    private LocalDate bootcampDate;

    private String time;

    private String status;

    private String location;

    private String tagLine;

    private String photo;

    private String price;

    private Integer bootcampBootcampBootcampBookingsesId;

}
