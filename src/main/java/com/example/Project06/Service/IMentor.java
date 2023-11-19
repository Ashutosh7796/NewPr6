package com.example.Project06.Service;

import com.example.Project06.Dto.MentorProfileDto.MentorProfileDto;
import com.example.Project06.Entity.Mentor;

import java.util.List;

public interface IMentor {
    public void save(MentorProfileDto mentorProfileDto);

    public Mentor getById(Integer mentorId);

    public List<Mentor> getAll();

    public String updateById(String specialityOfMentor, String skills, String subject, String mentorInfo, String achievements, String socalMediaLinkF, String socalMediaLinkF1, String socalMediaLinkInsta, String cost, Integer mentorId);

    public String deleteById(Integer mentorId);
}
