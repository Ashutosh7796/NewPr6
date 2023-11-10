package com.example.Project06.Dto.hr;

import lombok.Data;

import java.util.List;
@Data
public class ResponseAllHrDtos {
    private String status;
    private List<HrDto> response;

    public ResponseAllHrDtos(String status) {
        this.status = status;
    }
}
