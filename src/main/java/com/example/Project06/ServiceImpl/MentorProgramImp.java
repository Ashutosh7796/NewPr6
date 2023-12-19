package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.MentorProgramDto.MentorProgramDto;
import com.example.Project06.Entity.Mentor;
import com.example.Project06.Entity.MentorProgram;
import com.example.Project06.Repository.MentorProgramRepo;
import com.example.Project06.Repository.MentorRepo;
import com.example.Project06.Service.IMentorProgram;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
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

    @Override
    public String deleteById(Integer mentorProgramId) {
        mentorProgramRepo.findById(mentorProgramId).orElseThrow(() -> new RuntimeException("mentor program details Not found By Id"));
        mentorProgramRepo.deleteById(mentorProgramId);
        return "mentor program details deleted ";
    }

    @Override
    public String updateBootcampDetails(String programName, String programDetails, LocalDate date, String price, LocalTime time, String mentorProgramcol, String status, Integer mentorProgramId) {
        MentorProgram mentorProgram = mentorProgramRepo.findById(mentorProgramId).orElseThrow(() -> new RuntimeException("mentor program details Not found By Id"));

        mentorProgram.setProgramName(programName.length()>0 ? programName : mentorProgram.getProgramName());
        mentorProgram.setProgramDetails(programDetails.length()>0 ? programDetails : mentorProgram.getStatus());
        mentorProgram.setDate(date != null ? date : mentorProgram.getDate());
        mentorProgram.setPrice(price.length()>0 ? price : mentorProgram.getPrice());
        mentorProgram.setTime(time!= null ? time : mentorProgram.getTime());
        mentorProgram.setMentorProgramcol(mentorProgramcol.length()>0 ? mentorProgramcol : mentorProgram.getMentorProgramcol());
        mentorProgram.setStatus(status.length()>0 ? status : mentorProgram.getStatus());



        mentorProgramRepo.save(mentorProgram);
        return "mentor program details updated";
    }
}
