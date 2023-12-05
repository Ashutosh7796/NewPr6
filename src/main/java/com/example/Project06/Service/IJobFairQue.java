package com.example.Project06.Service;

import com.example.Project06.Dto.JobfairQue.JobFairQueDto;
import com.example.Project06.Dto.JobfairQue.ResponseJobFairQueDto;
import com.example.Project06.Dto.JobfairQue.ResponseOfAllJobFairQue;
import com.example.Project06.Entity.JobfairQue;

import java.util.List;

public interface IJobFairQue {
    public String addJobFairQuestion(JobFairQueDto jobFairQueDto);
    public ResponseJobFairQueDto getAllJobFairDetails(Integer pageNo, ResponseJobFairQueDto responseJobFairQ1Dto) ;

    public JobfairQue getJobFairDetails(Integer jobFairQueId);

    public List<JobfairQue> getJobFairDetailsBySetNo(String setNo, Integer pageNo,ResponseJobFairQueDto responseJobFairQ1Dto);

    public List<JobfairQue> getJobFairDetailsBySetNoAndQueType(String setNo,String questionType);

    public List<JobfairQue> getJobFairDetailsByJobId(Integer jobId);

    public ResponseOfAllJobFairQue addAllJobFairQuestion(List<JobFairQueDto> listOfjobFairQueDto, ResponseOfAllJobFairQue responseOfAllJobFairQue);
//    public JobfairQ1ans getJobFairDetailsByUserId(Integer userId);
}
