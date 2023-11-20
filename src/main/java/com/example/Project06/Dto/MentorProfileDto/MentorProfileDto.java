package com.example.Project06.Dto.MentorProfileDto;

import com.example.Project06.Entity.MentorFeedback;
import com.example.Project06.Entity.MentorProgram;
import com.example.Project06.Entity.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
public class MentorProfileDto {


    private String specialityOfMentor;

    private String skills;

    private String subject;

    private String mentorInfo;

    private String achievements;

    private String socalMediaLinkF;

    private String aboutAs;

    private String socalMediaLinkL;

    private String socalMediaLinkF1;

    private String socalMediaLinkInsta;

    private String cost;

    private Integer userUser;
}
