package com.example.Project06.Dto.Planning;

import lombok.Data;

import java.util.List;

@Data
public class ResponseAllCareersDto {


    private String status;
    private List<CareerPlaningDto> response;

    public ResponseAllCareersDto(String status) {
        this.status = status;
    }
}
