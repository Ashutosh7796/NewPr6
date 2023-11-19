package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.MentorProfileDto.MentorProfileDto;
import com.example.Project06.Entity.Company;
import com.example.Project06.Entity.Hr;
import com.example.Project06.Entity.Mentor;
import com.example.Project06.Entity.User;
import com.example.Project06.Repository.MentorRepo;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.IMentor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class MentorImp implements IMentor {
    private final MentorRepo mentorRepo;
    private final UserRepository userRepository;
    @Override
    public void save(MentorProfileDto mentorProfileDto) {
        userRepository.findById(mentorProfileDto.getUserUser()).orElseThrow(()->new RuntimeException("user not found by id"));
        Mentor mentor = new Mentor(mentorProfileDto);
        mentorRepo.save(mentor);
    }

    @Override
    public Mentor getById(Integer mentorId) {
        return mentorRepo.findById(mentorId).orElseThrow(()-> new RuntimeException("mentor profile details not found by id"));
    }

    @Override
    public List<Mentor> getAll() {

        List<Mentor> mentors = mentorRepo.findAll();
        if (mentors.isEmpty()) throw new RuntimeException("mentor profile details not found");
        return mentors;
    }
    @Override
    public String updateById(String specialityOfMentor,
                             String skills,
                             String subject,
                             String mentorInfo,
                             String achievements,
                             String socalMediaLinkF,
                             String socalMediaLinkF1,
                             String socalMediaLinkInsta,
                             String cost, Integer mentorId) {
        Mentor mentor = mentorRepo.findById(mentorId).orElseThrow(() -> new RuntimeException("mentor details Not found By Id"));

        mentor.setSpecialityOfMentor(specialityOfMentor.length()>0 ? specialityOfMentor : mentor.getSpecialityOfMentor());
        mentor.setSkills(skills.length()>0 ? skills : mentor.getSkills());
        mentor.setSubject(subject.length()>0 ? subject : mentor.getSubject());
        mentor.setMentorInfo(mentorInfo.length()>0 ? mentorInfo : mentor.getMentorInfo());
        mentor.setAchievements(achievements.length()>0 ? achievements : mentor.getAchievements());
        mentor.setSocalMediaLinkF(socalMediaLinkF.length()>0 ? socalMediaLinkF : mentor.getSocalMediaLinkF());
        mentor.setSocalMediaLinkF1(socalMediaLinkF1.length()>0 ? socalMediaLinkF1 : mentor.getSocalMediaLinkF1());
        mentor.setSocalMediaLinkInsta(socalMediaLinkInsta.length()>0 ? socalMediaLinkInsta : mentor.getSocalMediaLinkInsta());
        mentor.setCost(cost.length()>0 ? cost : mentor.getCost());

        mentorRepo.save(mentor);



    return "updeted";

    }

    @Override
    public String deleteById(Integer mentorId) {
        mentorRepo.findById(mentorId).orElseThrow(()->new RuntimeException("mentor not found by id"));

        mentorRepo.deleteById(mentorId);
        return "mentor details deleted";
    }
}
