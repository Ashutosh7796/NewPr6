package com.example.Project06.Dto.JobSave;

import com.example.Project06.Entity.JobSave;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetSingleJobSave {

    private Integer userId;

    private Integer JobId;

    private Integer jobSaveId;

    public GetSingleJobSave(JobSave jobSave) {
        this.userId = jobSave.getUserId();
        this.JobId=jobSave.getJobId();
        this.jobSaveId =jobSave.getJobSaveId();
    }
}
