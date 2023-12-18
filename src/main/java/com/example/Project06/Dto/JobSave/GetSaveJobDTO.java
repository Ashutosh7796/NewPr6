package com.example.Project06.Dto.JobSave;

import lombok.Data;

@Data
public class GetSaveJobDTO {

    private String status;

    private GetSingleJobSave Response;

    public GetSaveJobDTO(String status) {
        this.status = status;
    }

}
