package com.example.Project06.Dto.JobfairQ2ans;

import com.example.Project06.Entity.JobfairQ2ans;
import lombok.Data;

import java.util.List;

@Data
public class ResponseAllJobFairQ2 {
    private String status;
    private List<JobfairQ2ans> response;

    public ResponseAllJobFairQ2(String status) {
        this.status = status;
    }
}
