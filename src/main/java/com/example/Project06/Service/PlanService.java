package com.example.Project06.Service;



import com.example.Project06.Dto.Plan.PlanDto;

import java.util.List;

public interface PlanService {
    public String AddPlan(PlanDto planDto);

    public String EdgitPlan(PlanDto planDto, Integer PlanId);

    public String updatePlanFields(PlanDto planDto, Integer PlanId);

    public List<PlanDto> getAllPlanWithPages(int PageNo);

    public PlanDto findById(Integer PlanId);

    public List<PlanDto> getPlanByStatusWithPages(int PageNo, Boolean status);

    public String deletePlan(Integer planId);
}


