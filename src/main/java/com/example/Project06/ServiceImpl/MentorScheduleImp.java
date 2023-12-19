package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.MentorScheduleDto.MentorScheduleDto;
import com.example.Project06.Entity.MentorBokSchedule;
import com.example.Project06.Entity.MentorBookings;
import com.example.Project06.Repository.MentorScheduleRepo;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.IMentorSchedule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class MentorScheduleImp implements IMentorSchedule {
    private final MentorScheduleRepo mentorScheduleRepo;
    private final UserRepository userRepository;
//    private final MentorBookingsRepo mentorBookingsRepo;
    @Override
    public void saveHrDetails(MentorScheduleDto mentorScheduleDto) {
        userRepository.findById(mentorScheduleDto.getUserUser()).orElseThrow(()->new RuntimeException("user details not found by id"));
//        mentorBookingsRepo.findById(mentorScheduleDto.getMentorBookings()).orElseThrow(()->new RuntimeException("mentor bookings details not found by id"));

        MentorBokSchedule mentorBokSchedule = new MentorBokSchedule(mentorScheduleDto);
        mentorScheduleRepo.save(mentorBokSchedule);
    }

    @Override
    public String updateBootcampDetails(LocalDate date, String mode, String time, String payment, String status, Integer mentorBookingsId) {
        MentorBokSchedule mentorBokSchedule = mentorScheduleRepo.findById(mentorBookingsId).orElseThrow(()->new RuntimeException("mentor schedule details not found by id"));

        mentorBokSchedule.setDate(date != null ? date : mentorBokSchedule.getDate());
        mentorBokSchedule.setMode(mode.length()>0 ? mode : mentorBokSchedule.getMode());
        mentorBokSchedule.setTime(time.length()>0 ? time : mentorBokSchedule.getTime());
        mentorBokSchedule.setPayment(payment.length()>0 ? payment : mentorBokSchedule.getPayment());
        mentorBokSchedule.setStatus(status.length()>0 ? status : mentorBokSchedule.getStatus());
        mentorScheduleRepo.save(mentorBokSchedule);
        return "mentor schedule details updated";


    }

    @Override
    public String deleteById(Integer mentorScheduleId) {
        mentorScheduleRepo.findById(mentorScheduleId).orElseThrow(()->new RuntimeException("mentor schedule details not found by id"));
        mentorScheduleRepo.deleteById(mentorScheduleId);
        return "mentor schedule details deleted";
    }

    @Override
    public MentorBokSchedule getBootcampDetailsById(Integer mentorScheduleId) {
        return mentorScheduleRepo.findById(mentorScheduleId).orElseThrow(()->new RuntimeException("mentor schedule details not found by id"));
    }

    @Override
    public List<MentorBokSchedule> getAllBootcampDetails() {
        List<MentorBokSchedule> list = mentorScheduleRepo.findAll();
        if(list.isEmpty())throw new RuntimeException("Mentor Schedule details not found by id");
        return list;
    }
}
