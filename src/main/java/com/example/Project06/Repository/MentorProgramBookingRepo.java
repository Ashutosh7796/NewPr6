package com.example.Project06.Repository;

import com.example.Project06.Entity.MentorProgramBookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorProgramBookingRepo extends JpaRepository<MentorProgramBookings,Integer> {
}
