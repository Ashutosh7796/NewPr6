package com.example.Project06.Repository;

import com.example.Project06.Entity.BootcampBookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootcampBookingRepo extends JpaRepository<BootcampBookings,Integer> {
}
