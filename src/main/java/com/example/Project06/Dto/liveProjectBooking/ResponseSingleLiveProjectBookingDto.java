package com.example.Project06.Dto.liveProjectBooking;

import lombok.Data;

@Data
public class ResponseSingleLiveProjectBookingDto {

    private String message;
    private Object object;
    private String exception;

    public ResponseSingleLiveProjectBookingDto(String message)
    {
        this.message = message;
    }


}
