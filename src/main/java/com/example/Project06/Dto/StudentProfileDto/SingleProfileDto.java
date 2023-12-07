package com.example.Project06.Dto.StudentProfileDto;

import lombok.Data;

@Data
public class SingleProfileDto {
    private String status;
    private GetSingleProfileDto Response;

    public SingleProfileDto(String status) {
        this.status = status;
    }

}
