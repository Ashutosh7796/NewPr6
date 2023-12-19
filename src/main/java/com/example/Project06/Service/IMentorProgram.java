package com.example.Project06.Service;

import com.example.Project06.Dto.MentorProgramDto.MentorProgramDto;
import com.example.Project06.Entity.MentorProgram;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface IMentorProgram {
    public void save(MentorProgramDto mentorProgramDto);

    public MentorProgram getById(Integer mentorProgramId);

   public List<MentorProgram> getAll();

    public String deleteById(Integer mentorProgramId);

    public String updateBootcampDetails(String programName, String programDetails, LocalDate date, String price, LocalTime time, String mentorProgramcol, String status, Integer mentorProgramId);
}
