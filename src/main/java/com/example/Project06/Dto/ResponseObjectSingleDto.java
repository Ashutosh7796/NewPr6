package com.example.Project06.Dto;


import com.example.Project06.Entity.Banner;
import lombok.Data;
import lombok.Getter;
@Data
public class ResponseObjectSingleDto {
    private String status;

    private Banner response;

    public ResponseObjectSingleDto(String status) {
        this.status = status;
    }


}
