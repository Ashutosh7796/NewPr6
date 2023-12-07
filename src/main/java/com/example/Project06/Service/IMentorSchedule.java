package com.example.Project06.Service;

import com.example.Project06.Dto.MentorScheduleDto.MentorScheduleDto;
import com.example.Project06.Entity.MentorBokSchedule;

import java.time.LocalDate;
import java.util.List;

public interface IMentorSchedule {
    public void saveHrDetails(MentorScheduleDto mentorScheduleDto);


    public String updateBootcampDetails(LocalDate date, String mode, String time, String payment, String status, Integer mentorBookingsId);

    public String deleteById(Integer mentorScheduleId);

    public MentorBokSchedule getBootcampDetailsById(Integer mentorScheduleId);

    public List<MentorBokSchedule> getAllBootcampDetails();
}
