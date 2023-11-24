package com.example.Project06.Entity;

import com.example.Project06.Dto.MentorProgramBookingDTO.MentorProgramBookingDto;
import com.example.Project06.Repository.MentorProgramBookingRepo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "MentorProgramBookingses")
@Getter
@Setter
public class MentorProgramBookings {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mentorProgramBookings;

    @Column
    private LocalDate date;

    @Column
    private Integer userId;

    @Column(length = 45)
    private String mentorProgramBookingscol;

    @Column(name = "mentor_program_mentor_program_id", nullable = false)
    private Integer mentorProgramMentorProgram;

    public MentorProgramBookings() {
    }

    public MentorProgramBookings(MentorProgramBookingDto mentorProgramBookingDto) {
        this.date = mentorProgramBookingDto.getDate();
        this.userId = mentorProgramBookingDto.getUserId();
        this.mentorProgramBookingscol = mentorProgramBookingDto.getMentorProgramBookingscol();
        this.mentorProgramMentorProgram = mentorProgramBookingDto.getMentorProgramId();
    }
}
