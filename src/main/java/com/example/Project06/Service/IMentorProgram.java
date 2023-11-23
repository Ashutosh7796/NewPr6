package com.example.Project06.Service;

import com.example.Project06.Dto.MentorProgramDto.MentorProgramDto;
import com.example.Project06.Entity.MentorProgram;

import java.util.List;

public interface IMentorProgram {
    public void save(MentorProgramDto mentorProgramDto);

    public MentorProgram getById(Integer mentorProgramId);

   public List<MentorProgram> getAll();
}
