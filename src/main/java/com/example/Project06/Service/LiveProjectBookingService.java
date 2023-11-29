package com.example.Project06.Service;

import com.example.Project06.Dto.ItTrianningBooking.ItTrianningBookingDto;
import com.example.Project06.Dto.liveProjectBooking.LiveProjectBookingDto;

import java.util.List;

public interface LiveProjectBookingService {

    public String AddLiveProjectBooking(LiveProjectBookingDto liveProjectBookingDto);

    public  LiveProjectBookingDto GetbyId(Integer liveProjectBookingId);

    public List<LiveProjectBookingDto> getAllByliveProjectID(Integer liveProjectID);

    List<LiveProjectBookingDto> AllLiveProjectBooking();

    public  String LiveProjectBookingDelete(Integer liveProjectBookingId);

    List<LiveProjectBookingDto> getByUserId(Integer UserId);

}
