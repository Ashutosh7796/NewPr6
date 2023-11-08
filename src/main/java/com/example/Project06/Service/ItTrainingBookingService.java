package com.example.Project06.Service;

import com.example.Project06.Dto.ItTrianningBooking.ItTrianningBookingDto;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;


public interface ItTrainingBookingService {

    public String AddItTrainingBooking(ItTrianningBookingDto itTrianningBookingDto);

    public  ItTrianningBookingDto GetbyId(Integer itTrainingBookingId);

    List<ItTrianningBookingDto> AllItBooking();

    public  String ItBookingDelete(Integer itTrainingBookingId);

    List<ItTrianningBookingDto> getByUserId(Integer UserId);






}
