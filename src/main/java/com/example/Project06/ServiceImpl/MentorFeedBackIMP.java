package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.MentorFeedBack.MentorFeedBackDto;
import com.example.Project06.Dto.MentorProfileDto.MentorProfileDto;
import com.example.Project06.Entity.Mentor;
import com.example.Project06.Entity.MentorFeedback;
import com.example.Project06.Repository.MentorFeedBackRepo;
import com.example.Project06.Repository.MentorRepo;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.IMentorFeedBack;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MentorFeedBackIMP implements IMentorFeedBack {
    private final MentorFeedBackRepo mentorFeedBackRepo;
    private final UserRepository userRepository;
    private final MentorRepo mentorRepo;

    @Override
    public String updateById(String feedback, Integer mentorFeedbackId) {
       MentorFeedback mentorFeedback = mentorFeedBackRepo.findById(mentorFeedbackId).orElseThrow(()->new RuntimeException("mentor feedback details not found by id"));
        mentorFeedback.setFeedback(feedback.length()>0 ? feedback : mentorFeedback.getFeedback());
        mentorFeedBackRepo.save(mentorFeedback);
        return "mentor feed back updated";

    }

    @Override
    public String deleteById(Integer mentorId) {
        mentorFeedBackRepo.findById(mentorId).orElseThrow(()->new RuntimeException("mentor feedback details not found by id"));
        mentorFeedBackRepo.deleteById(mentorId);
        return "mentor feedback deleted";
    }

    @Override
    public List<MentorFeedback> getAll() {
        List<MentorFeedback> mentorFeedbacks = mentorFeedBackRepo.findAll();
        if (mentorFeedbacks.isEmpty()) throw new RuntimeException("mentor feedback details not found");
        return mentorFeedbacks;
    }

    @Override
    public MentorFeedback getById(Integer mentorFeedbackId) {
        return mentorFeedBackRepo.findById(mentorFeedbackId).orElseThrow(()->new RuntimeException("mentor feedback details not found by id"));
    }

    @Override
    public void save(MentorFeedBackDto mentorProfileDto) {
        userRepository.findById(mentorProfileDto.getUserId()).orElseThrow(()->new RuntimeException("user not found by id"));
        mentorRepo.findById(mentorProfileDto.getMentorId()).orElseThrow(()->new RuntimeException("mentor not found by id"));
        MentorFeedback feedback = new MentorFeedback();
        feedback.setFeedback(mentorProfileDto.getFeedback());
        feedback.setUserId(mentorProfileDto.getUserId());
        feedback.setMentorId(mentorProfileDto.getMentorId());
        mentorFeedBackRepo.save(feedback);
    }
}
