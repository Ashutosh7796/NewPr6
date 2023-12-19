package com.example.Project06.Entity;

import com.example.Project06.Dto.MentorScheduleDto.MentorScheduleDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "MentorBokSchedules")
@Getter
@Setter
public class MentorBokSchedule {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mentorBokSchedule;

    @Column
    private LocalDate date;

    @Column(length = 45)
    private String mode;

    @Column(length = 45)
    private String time;

    @Column(length = 45)
    private String payment;

    @Column(length = 45)
    private String status;

    @Column(nullable = false)
    private Integer mentorScheduleMentorScheduleId;


    @Column(name = "user_user_id", nullable = false)
    private Integer userUser;

    @Column(name = "mentorBokScheduleMentorBokSchedule")
    private Integer mentorBookings;

    public MentorBokSchedule() {
    }
    public MentorBokSchedule(MentorScheduleDto mentorScheduleDto) {

        this.date = mentorScheduleDto.getDate();
        this.mode = mentorScheduleDto.getMode();
        this.time = mentorScheduleDto.getTime();
        this.payment = mentorScheduleDto.getPayment();
        this.status = mentorScheduleDto.getStatus();
        this.mentorScheduleMentorScheduleId = mentorScheduleDto.getMentorScheduleMentorScheduleId();
        this.userUser = mentorScheduleDto.getUserUser();
        this.mentorBookings = mentorScheduleDto.getMentorBookings();
    }
}
