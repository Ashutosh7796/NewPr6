package com.example.Project06.Dto.hr;

import com.example.Project06.Entity.Hr;
import lombok.Data;

@Data
public class ResponseHrSingleDto {
    private String status;
    private HrDto response;

    public ResponseHrSingleDto(String status) {
        this.status = status;
    }
}
