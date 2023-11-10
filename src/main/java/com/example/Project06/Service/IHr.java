package com.example.Project06.Service;

import com.example.Project06.Dto.hr.HrDto;

import java.util.List;

public interface IHr {

    public void saveHrDetails(HrDto hrDto);

    public HrDto getBootcampDetailsById(Integer hrId);

    public List<HrDto> getAllBootcampDetails();

    public String updateBootcampDetails(String digignastion, String status, String refNoOfCompany, Integer hrId);

    public String deleteById(Integer hrId);
}
