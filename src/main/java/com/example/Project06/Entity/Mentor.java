package com.example.Project06.Entity;

import com.example.Project06.Dto.MentorProfileDto.MentorProfileDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "Mentors")
@Getter
@Setter
@NoArgsConstructor
public class Mentor  {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mentorId;

    @Column(length = 200)
    private String specialityOfMentor;

    @Column(length = 200)
    private String skills;

    @Column(length = 200)
    private String subject;

    @Column(length = 250)
    private String mentorInfo;

    @Column(length = 250)
    private String achievements;

    @Column(length = 200)
    private String socalMediaLinkF;

    @Column(length = 250)
    private String aboutAs;

    @Column(length = 250)
    private String socalMediaLinkL;

    @Column(length = 45)
    private String socalMediaLinkF1;

    @Column(length = 45)
    private String socalMediaLinkInsta;

    @Column(length = 45)
    private String cost;


    @Column(name = "user_user_id")
    private Integer userUser;



    public Mentor(MentorProfileDto mentorProfileDto) {

        this.specialityOfMentor = mentorProfileDto.getSpecialityOfMentor();
        this.skills = mentorProfileDto.getSkills();
        this.subject = mentorProfileDto.getSubject();
        this.mentorInfo = mentorProfileDto.getMentorInfo();
        this.achievements = mentorProfileDto.getAchievements();
        this.socalMediaLinkF = mentorProfileDto.getSocalMediaLinkF();
        this.aboutAs = mentorProfileDto.getAboutAs();
        this.socalMediaLinkL = mentorProfileDto.getSocalMediaLinkL();
        this.socalMediaLinkF1 = mentorProfileDto.getSocalMediaLinkF1();
        this.socalMediaLinkInsta = mentorProfileDto.getSocalMediaLinkInsta();
        this.cost = mentorProfileDto.getCost();
        this.userUser = mentorProfileDto.getUserUser();
    }
}
