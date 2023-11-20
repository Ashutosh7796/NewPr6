package com.example.Project06.Repository;

import com.example.Project06.Entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepo extends JpaRepository<Mentor,Integer> {
}
