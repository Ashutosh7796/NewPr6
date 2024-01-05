package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.Exam.AssessmentExamDto;
import com.example.Project06.Entity.Questions;
import com.example.Project06.Repository.QuestionRepo;
import com.example.Project06.Service.AssessmentExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssessmentExamServiceImpl implements AssessmentExamService {


    private final QuestionRepo questionRepo;


    @Override
    public void createAssessmentExam(AssessmentExamDto requestDTO) {
        Questions assessmentExam = new Questions();
        assessmentExam.setSubject(requestDTO.getSubject());
        assessmentExam.setQuestion(requestDTO.getQuestion());
        questionRepo.save(assessmentExam);
    }
}
