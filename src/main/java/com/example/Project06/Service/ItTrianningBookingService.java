package com.example.Project06.Service;

import com.example.Project06.Dto.ItTrianningBooking.ItTrianningBookingDto;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;


public interface ItTrianningBookingService {

    public String AddItTrianningBooking(ItTrianningBookingDto itTrianningBookingDto);

    public  String GetbyId(Integer itTrainingBooking);

    List<ItTrianningBookingDto> AllItBooking();

    public  String ItBookingDelete(Integer itTrainingBooking);

    List<ItTrianningBookingDto> getByUserId(Integer UserId);

    List<ItTrianningBookingDto> getByItTrainingId(Integer itTrainingItTraining);




}
