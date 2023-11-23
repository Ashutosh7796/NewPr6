package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.MentorProgramDto.MentorProgramDto;
import com.example.Project06.Entity.Mentor;
import com.example.Project06.Entity.MentorProgram;
import com.example.Project06.Repository.MentorProgramRepo;
import com.example.Project06.Repository.MentorRepo;
import com.example.Project06.Service.IMentorProgram;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MentorProgramImp implements IMentorProgram {
    private final MentorProgramRepo mentorProgramRepo;
    private final MentorRepo mentorRepo;

    @Override
    public void save(MentorProgramDto mentorProgramDto) {
        mentorRepo.findById(mentorProgramDto.getMentorId()).orElseThrow(()->new RuntimeException("mentor not found by id"));
        MentorProgram mentorProgram = new MentorProgram(mentorProgramDto);
        mentorProgramRepo.save(mentorProgram);

    }

    @Override
    public MentorProgram getById(Integer mentorProgramId) {
        return mentorProgramRepo.findById(mentorProgramId).orElseThrow(()->new RuntimeException("mentor program details not found by id"));
    }

    @Override
    public List<MentorProgram> getAll() {
        List<MentorProgram> mentorPrograms = mentorProgramRepo.findAll();
        if (mentorPrograms.isEmpty()) throw new RuntimeException("mentor program details not found");
        return mentorPrograms;
    }
}
