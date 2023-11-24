package com.example.Project06.Dto.LiveProject;


import com.example.Project06.Entity.LiveProject;
import lombok.Data;

import java.util.List;
@Data
public class ResponseAllLiveProjectDto {

    private String message;
    private List<LiveProjectDto> List;
    private String exception;

    public ResponseAllLiveProjectDto(String message)
    {
        this.message = message;
    }

}
