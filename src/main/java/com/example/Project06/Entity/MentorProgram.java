package com.example.Project06.Entity;

import com.example.Project06.Dto.MentorProgramDto.MentorProgramDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;


@Entity
@Table(name = "MentorPrograms")
@Getter
@Setter
@ToString
public class MentorProgram {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mentorProgramId;

    @Column(length = 250)
    private String programName;

    @Column(length = 250)
    private String programDetails;

    @Column
    private LocalDate date;

    @Column(length = 45)
    private String price;

    @Column
    private LocalTime time;

    @Column(length = 45)
    private String mentorProgramcol;

    @Column(length = 45)
    private String status;

    @Column(name = "mentor_mentor_id")
    private Integer mentorMentor;

    @OneToMany(mappedBy = "mentorProgramMentorProgram")
    private Set<MentorProgramBookings> mentorProgramMentorProgramMentorProgramBookingses;

    public MentorProgram() {
    }

    public MentorProgram(MentorProgramDto mentorProgramDto) {
        this.programName = mentorProgramDto.getProgramName();
        this.programDetails = mentorProgramDto.getProgramDetails();
        this.date = mentorProgramDto.getDate();
        this.price = mentorProgramDto.getPrice();
        this.time = mentorProgramDto.getTime();
        this.mentorProgramcol = mentorProgramDto.getMentorProgramcol();
        this.status = mentorProgramDto.getStatus();
        this.mentorMentor = mentorProgramDto.getMentorId();
    }
}
