package com.example.Project06.Dto;

import lombok.Data;

@Data
public class RUserSingleDto {

    private String status;
    private GetSingleUserDto Response;

    public RUserSingleDto(String status) {
        this.status = status;
    }


}
