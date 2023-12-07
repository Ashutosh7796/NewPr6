package com.example.Project06.Dto.Planning;

import com.example.Project06.Dto.hr.HrDto;
import lombok.Data;

@Data
public class ResponseCareerPlansDto {

    private String status;
    private CareerPlaningDto response;

    public ResponseCareerPlansDto(String status) {
        this.status = status;
    }
}
