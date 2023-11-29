package com.example.Project06.Dto.liveProjectBooking;


import lombok.Data;

import java.util.List;
@Data
public class ResponseAllLiveProjectBookingDto {

    private String message;
    private List<LiveProjectBookingDto> List;
    private String exception;

    public ResponseAllLiveProjectBookingDto(String message)
    {
        this.message = message;
    }

}
