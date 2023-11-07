package com.example.Project06.Dto.BootcampDto;

import com.example.Project06.Entity.Bootcamp;
import lombok.Data;

import java.util.List;

@Data
public class ResponseAllBootcampDetails {
private String status;
private List<Bootcamp> bootcamps;

    public ResponseAllBootcampDetails(String status) {
        this.status = status;
    }
}
