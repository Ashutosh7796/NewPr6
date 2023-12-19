package com.example.Project06.Service;

import com.example.Project06.Dto.Planning.CareerPlaningDto;
import com.example.Project06.Entity.CareerPlanning;

import java.time.OffsetDateTime;
import java.util.List;

public interface CareerPlanningService {
    void createCareerPlan(CareerPlaningDto careerPlaningDto);

    CareerPlaningDto getPlanById(Integer careerPlanning);

    List<CareerPlaningDto> getAllCareerPlans();

    String deleteById(Integer careerPlanning);

    String updateCareerPlans(String domain, String mode, OffsetDateTime slot, String cost, String status, Integer careerPlanning);
}
