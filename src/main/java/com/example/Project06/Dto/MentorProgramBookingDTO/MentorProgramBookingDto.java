package com.example.Project06.Dto.MentorProgramBookingDTO;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
@Data
public class MentorProgramBookingDto {
    private LocalDate date;

    private Integer userId;

    private String mentorProgramBookingscol;

    private Integer mentorProgramId;

}
