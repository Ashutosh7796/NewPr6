package com.example.Project06.Service;



import com.example.Project06.Dto.AssessmentExamQuestions.AssessmentExamQuestionsDto;

import java.util.List;

public interface AssessmentExamQuestionsService {


    public String AssessmentExamQuestion(AssessmentExamQuestionsDto assessmentExamQuestionsDto);


    public List<AssessmentExamQuestionsDto> getAllAssessmentExamQuestionWithPages(int PageNo);

    public AssessmentExamQuestionsDto findById(Integer AssessmentExamQuestionsID);


    public String deletePlan(Integer AssessmentExamQuestionsID);

}
