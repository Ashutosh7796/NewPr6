package com.example.Project06.Dto;

import lombok.Data;

@Data
public class RUserSingleDto {

    private String status;
    private RegisterDto Response;

    public RUserSingleDto(String status) {
        this.status = status;
    }


}
