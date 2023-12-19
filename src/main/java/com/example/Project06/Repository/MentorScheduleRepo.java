package com.example.Project06.Repository;

import com.example.Project06.Entity.MentorBokSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorScheduleRepo extends JpaRepository<MentorBokSchedule,Integer> {
}
