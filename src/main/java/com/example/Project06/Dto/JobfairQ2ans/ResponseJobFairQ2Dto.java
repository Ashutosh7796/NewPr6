package com.example.Project06.Dto.JobfairQ2ans;

import com.example.Project06.Entity.JobfairQ2ans;
import lombok.Data;

@Data
public class ResponseJobFairQ2Dto {
    private String status;
    private JobfairQ2ans response;
    private String exception;

    public ResponseJobFairQ2Dto(String status) {
        this.status = status;
    }
}
