package com.example.Project06.Repository;

import com.example.Project06.Entity.BootcampBookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BootcampBookingsRepo extends JpaRepository<BootcampBookings,Integer> {
//    public Set<BootcampBookings> findByBannnerId();
}
