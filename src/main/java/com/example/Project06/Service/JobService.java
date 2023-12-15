package com.example.Project06.Service;

import com.example.Project06.Dto.Job.JobDto;
import com.example.Project06.Entity.Job;

import java.util.List;
import java.util.Optional;

public interface JobService {

    public String AddJob(JobDto jobDto);

    public String updateJobFields(JobDto jobDto,Integer JobId);

    public List<JobDto> getAlljob();

    public JobDto findById(Integer JobId);

    public Optional<Job> findjobById(Integer JobId);

    public String deleteById(Integer JobId);

    public List<JobDto> getJobsByStatus(String status);

    public List<JobDto> getByUserId(Integer userId);

}
