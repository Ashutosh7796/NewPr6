package com.example.Project06.Dto.MentorFeedBack;

import com.example.Project06.Entity.MentorFeedback;
import lombok.Data;

@Data
public class ResponseMentorFeedbackSingleDto {
    private String status;
    private MentorFeedback response;

    public ResponseMentorFeedbackSingleDto(String status) {
        this.status = status;
    }
}
