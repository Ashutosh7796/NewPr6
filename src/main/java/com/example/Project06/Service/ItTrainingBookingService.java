package com.example.Project06.Service;

import com.example.Project06.Dto.ItTrianningBooking.ItTrianningBookingDto;

import java.util.List;


public interface ItTrainingBookingService {

    public String AddItTrainingBooking(ItTrianningBookingDto itTrianningBookingDto);

    public  ItTrianningBookingDto GetbyId(Integer itTrainingBookingId);

    public List<ItTrianningBookingDto> getAllByItTrainingId(Integer itTrainingId);

    List<ItTrianningBookingDto> AllItBooking();

    public  String ItBookingDelete(Integer itTrainingBookingId);

    List<ItTrianningBookingDto> getByUserId(Integer UserId);






}
