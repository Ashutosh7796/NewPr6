package com.example.Project06.Repository;

import com.example.Project06.Entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
    public interface QuestionRepo extends JpaRepository<Questions, Integer> {

    List<Questions> findBySubject(String subject);
}


