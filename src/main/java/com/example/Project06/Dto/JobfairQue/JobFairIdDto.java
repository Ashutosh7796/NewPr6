package com.example.Project06.Dto.JobfairQue;

import com.example.Project06.Entity.JobfairQue;
import lombok.Data;

@Data
public class JobFairIdDto {
    private String status;
    private JobfairQue jobfairQue;
    private String Exception;

    public JobFairIdDto(String status) {
        this.status = status;
    }
}
