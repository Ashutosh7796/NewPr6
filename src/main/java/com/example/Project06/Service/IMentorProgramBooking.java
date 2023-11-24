package com.example.Project06.Service;

import com.example.Project06.Dto.MentorProgramBookingDTO.MentorProgramBookingDto;
import com.example.Project06.Entity.MentorProgram;
import com.example.Project06.Entity.MentorProgramBookings;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface IMentorProgramBooking {
    public void save(MentorProgramBookingDto mentorProgramBookingDto);


    public MentorProgramBookings getById(Integer mentorProgramBookingId);

    public List<MentorProgramBookings> getAll();


    public String deleteById(Integer mentorProgramBookingId);

    public String updateBootcampDetails(LocalDate date, String mentorProgramBookingscol, Integer mentorProgramBookingId);
}
