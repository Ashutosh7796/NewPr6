package com.example.Project06.Service;

import com.example.Project06.Dto.MentorFeedBack.MentorFeedBackDto;
import com.example.Project06.Dto.MentorProfileDto.MentorProfileDto;
import com.example.Project06.Entity.MentorFeedback;

import java.util.List;

public interface IMentorFeedBack {

    public String updateById(String feedback, Integer mentorFeedbackId);

    public String deleteById(Integer mentorId);

    public List<MentorFeedback> getAll();

    public MentorFeedback getById(Integer mentorFeedbackId);

    public void save(MentorFeedBackDto mentorProfileDto);
}
