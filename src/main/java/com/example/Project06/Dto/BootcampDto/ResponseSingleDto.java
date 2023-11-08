package com.example.Project06.Dto.BootcampDto;

import com.example.Project06.Entity.Bootcamp;
import lombok.Data;

@Data
public class ResponseSingleDto {
    private String status;
    private Bootcamp bootcamp;

    public ResponseSingleDto(String status) {
        this.status = status;
    }
}
