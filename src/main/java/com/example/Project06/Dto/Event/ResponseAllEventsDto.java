package com.example.Project06.Dto.Event;

import lombok.Data;

import java.util.List;

@Data
public class ResponseAllEventsDto {


    private String message;
    private List<GetSingleEventDto> list;
    private String exception;

    public ResponseAllEventsDto(String message){
        this.message=message;
    }
}
