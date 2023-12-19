package com.example.Project06.Repository;

import com.example.Project06.Entity.CareerPlanning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerPlanningRepository extends JpaRepository<CareerPlanning, Integer> {
}
