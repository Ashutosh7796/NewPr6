package com.example.Project06.Dto.HrCall;

import com.example.Project06.Dto.Event.GetSingleEventDto;
import lombok.Data;

@Data
public class SingleHrCallDto {

    private String status;
    private GetSingleHrCallDto Response;

    public SingleHrCallDto(String status) {
        this.status = status;
    }

}
