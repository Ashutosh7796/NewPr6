package com.example.Project06.Dto.AssessmentExamQuestions;

import com.example.Project06.Dto.Plan.PlanDto;
import lombok.Data;

import java.util.List;
@Data
public class ResponseGetAllAssessmentExamQuestionsDto {

    private String message;
    private List<AssessmentExamQuestionsDto> list;
    private String exception;

    public ResponseGetAllAssessmentExamQuestionsDto(String message) {
        this.message = message;
    }
}
