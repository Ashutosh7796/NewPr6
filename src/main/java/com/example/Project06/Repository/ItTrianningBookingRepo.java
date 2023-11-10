package com.example.Project06.Repository;

import com.example.Project06.Entity.ItTrainingBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItTrianningBookingRepo extends JpaRepository<ItTrainingBooking,Integer> {

    List<ItTrainingBooking> findByUserId(Integer userId);
    List<ItTrainingBooking> findByItTrainingId(Integer itTrainingId);


}
