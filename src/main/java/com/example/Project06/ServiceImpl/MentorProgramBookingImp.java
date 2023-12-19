package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.MentorProgramBookingDTO.MentorProgramBookingDto;
import com.example.Project06.Entity.MentorProgramBookings;
import com.example.Project06.Repository.MentorProgramBookingRepo;
import com.example.Project06.Repository.MentorProgramRepo;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.IMentorProgramBooking;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MentorProgramBookingImp implements IMentorProgramBooking {

    private final MentorProgramBookingRepo mentorProgramBookingRepo;
    private final UserRepository userRepository;
    private final MentorProgramRepo mentorProgramRepo;

    @Override
    public void save(MentorProgramBookingDto mentorProgramBookingDto) {
        userRepository.findById(mentorProgramBookingDto.getUserId()).orElseThrow(()->new RuntimeException("user not found by id"));
        mentorProgramRepo.findById(mentorProgramBookingDto.getMentorProgramId()).orElseThrow(()->new RuntimeException("mentor program not found by id"));
        MentorProgramBookings mentorProgramBookings = new MentorProgramBookings(mentorProgramBookingDto);
        mentorProgramBookingRepo.save(mentorProgramBookings);

    }

    @Override
    public MentorProgramBookings getById(Integer mentorProgramBookingId) {
        return mentorProgramBookingRepo.findById(mentorProgramBookingId).orElseThrow(()->new RuntimeException("mentor program booking details not found by id"));
    }

    @Override
    public List<MentorProgramBookings> getAll() {
        List<MentorProgramBookings> mentorProgramBookings = mentorProgramBookingRepo.findAll();
        if(mentorProgramBookings.isEmpty())throw new RuntimeException("mentor program bookings details not found");
        return mentorProgramBookings;

    }

    @Override
    public String updateBootcampDetails(LocalDate date, String mentorProgramBookingscol, Integer mentorProgramBookingId){
        MentorProgramBookings mentorProgramBookings = mentorProgramBookingRepo.findById(mentorProgramBookingId).orElseThrow(()->new RuntimeException("mentor program bookings details not found"));

        mentorProgramBookings.setDate(date!=null ? date : mentorProgramBookings.getDate());
        mentorProgramBookings.setMentorProgramBookingscol(mentorProgramBookingscol.length()>0 ?  mentorProgramBookingscol : mentorProgramBookings.getMentorProgramBookingscol());
        mentorProgramBookingRepo.save(mentorProgramBookings);
        return "mentor program details updated";
    }

    @Override
    public String deleteById(Integer mentorProgramBookingId) {
        mentorProgramBookingRepo.findById(mentorProgramBookingId).orElseThrow(()->new RuntimeException("mentor program booking details not found by id"));
        mentorProgramBookingRepo.deleteById(mentorProgramBookingId);
        return "mentor program details deleted";

    }

}

