package com.example.Project06.Dto.JobSave;


import com.example.Project06.Entity.JobSave;
import lombok.Data;

@Data
public class JobSaveDto {

    private Integer jobId;

    private Integer userId;

    public JobSaveDto(JobSave jobSave) {
        this.jobId = jobSave.getJobId();
        this.userId = jobSave.getUserId();
    }
}
