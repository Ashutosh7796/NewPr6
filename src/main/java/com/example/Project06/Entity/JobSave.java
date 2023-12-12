package com.example.Project06.Entity;

import com.example.Project06.Dto.JobSave.JobSaveDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "JobSave")
@Getter
@Setter
@NoArgsConstructor
public class JobSave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobSaveId;

    private Integer jobId;

    private Integer userId;

    public JobSave(JobSaveDto jobSaveDto) {
        this.jobId = jobSaveDto.getJobId();
        this.userId = jobSaveDto.getUserId();
    }
}
