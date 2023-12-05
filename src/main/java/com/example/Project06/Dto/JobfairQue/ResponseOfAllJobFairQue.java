package com.example.Project06.Dto.JobfairQue;

import lombok.Data;

@Data
public class ResponseOfAllJobFairQue {
    private String status;
    private String response;

    public ResponseOfAllJobFairQue(String status) {
        this.status = status;
    }
}
