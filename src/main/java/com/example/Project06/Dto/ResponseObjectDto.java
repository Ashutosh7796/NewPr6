package com.example.Project06.Dto;

import com.example.Project06.Entity.Banner;
import lombok.Data;
import lombok.Getter;

import java.util.List;
@Data
public class ResponseObjectDto {
    private String status;

    private List<Banner> response;

    public ResponseObjectDto(String status) {
        this.status = status;

    }


}
