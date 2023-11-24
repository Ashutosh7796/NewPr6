package com.example.Project06.Repository;

import com.example.Project06.Entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {

    public List<Plan> getPlansByStatus(boolean status);
}
