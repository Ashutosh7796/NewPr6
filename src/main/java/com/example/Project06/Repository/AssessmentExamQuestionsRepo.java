package com.example.Project06.Repository;

import com.example.Project06.Entity.AssessmentExamQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentExamQuestionsRepo extends JpaRepository<AssessmentExamQuestions, Integer> {
}
