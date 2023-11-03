package com.example.Project06.Service;

import com.example.Project06.Dto.BootcampDto.BootcampDto;
import com.example.Project06.Entity.Bootcamp;

import java.time.LocalDate;
import java.util.List;

public interface IBootcamp {
    public void saveBootcampDetails(BootcampDto bootcampDto);

    public Bootcamp getBootcampDetailsById(Integer bootcampId);

    public List<Bootcamp> getAllBootcampDetails();

    public String updateBootcampDetails(String bootcampTital, String bootcampDetails, String time, String status, String location, String tagLine, String photo, String price, Integer bootCampId) ;
    String updateBootcampDetails(String taital, String status, String name, Integer bootcampId);

    public String deleteBootcampDetailsByID(Integer bootcampId);
}


