package com.example.Project06.Dto.MentorProgramDto;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class MentorProgramDto {



    private String programName;

    private String programDetails;


    private LocalDate date;

    private String price;

    private LocalTime time;

    private String mentorProgramcol;

    private String status;

    private Integer mentorId;
}
