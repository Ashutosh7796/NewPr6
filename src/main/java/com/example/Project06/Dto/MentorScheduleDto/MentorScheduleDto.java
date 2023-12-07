package com.example.Project06.Dto.MentorScheduleDto;


import lombok.Data;

import java.time.LocalDate;
@Data
public class MentorScheduleDto {

    private LocalDate date;


    private String mode;


    private String time;

    private String payment;

    private String status;

    private Integer mentorScheduleMentorScheduleId;


    private Integer userUser;

    private Integer mentorBookings;
}
