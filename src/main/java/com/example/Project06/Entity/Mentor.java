package com.example.Project06.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Table(name = "Mentors")
@Getter
@Setter
public class Mentor {

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_user_id", nullable = false)
    private User userUser;

    @OneToMany(mappedBy = "mentorMentor")
    private Set<MentorProgram> mentorMentorMentorPrograms;

    @OneToMany(mappedBy = "mentorMentor")
    private Set<MentorFeedback> mentorMentorMentorFeedbacks;

}
