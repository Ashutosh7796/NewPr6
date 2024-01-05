package com.example.Project06.Repository;

import com.example.Project06.Entity.SelectedQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelectedQuestionsRepository extends JpaRepository<SelectedQuestions, Integer> {


}
