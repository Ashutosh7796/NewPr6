package com.example.Project06.Dto.JobfairQ2ans;

import com.example.Project06.Entity.JobfairQ2ans;
import lombok.Data;

@Data
public class ResponseForJobFairTwoUserId {
    private String status;
    private Integer totalItems;
    private JobfairQ2ans response;
    private Integer totalPages;
    private Integer currentPage;
    private String exception;

    public ResponseForJobFairTwoUserId(String status) {
        this.status = status;
    }
}
