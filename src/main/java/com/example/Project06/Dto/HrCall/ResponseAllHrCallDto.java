package com.example.Project06.Dto.HrCall;

import com.example.Project06.Dto.Event.GetSingleEventDto;
import lombok.Data;
import java.util.List;
@Data
public class ResponseAllHrCallDto {

    private String message;
    private List<GetSingleHrCallDto> list;
    private String exception;

    public ResponseAllHrCallDto(String message){
        this.message=message;
    }
}
