package com.example.Project06.Dto.MentorFeedBack;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class MentorFeedBackDto {


    private String feedback;

    private Integer userId;

    private Integer mentorId;
}
