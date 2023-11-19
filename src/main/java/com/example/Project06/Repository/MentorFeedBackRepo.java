package com.example.Project06.Repository;

import com.example.Project06.Entity.MentorFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorFeedBackRepo extends JpaRepository<MentorFeedback,Integer> {
}
