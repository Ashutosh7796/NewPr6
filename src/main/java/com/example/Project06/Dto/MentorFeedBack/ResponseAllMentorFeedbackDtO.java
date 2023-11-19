package com.example.Project06.Dto.MentorFeedBack;

import com.example.Project06.Entity.MentorFeedback;
import lombok.Data;

import java.util.List;
@Data
public class ResponseAllMentorFeedbackDtO {
    private String status;
    private List<MentorFeedback> response;

    public ResponseAllMentorFeedbackDtO(String status) {
        this.status = status;
    }
}
