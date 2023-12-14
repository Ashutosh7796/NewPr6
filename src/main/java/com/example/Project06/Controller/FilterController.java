package com.example.Project06.Controller;

import com.example.Project06.Dto.FilterDto;
import com.example.Project06.Dto.Job.JobDto;
import com.example.Project06.Dto.Job.ResponseGetAllJobDto;
import com.example.Project06.Service.FilterService;
import com.example.Project06.exception.JobNotFoundException;
import com.example.Project06.exception.NoMatchingResultFound;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/filter")
public class FilterController {

    private final FilterService filterService;

    @GetMapping("/mainFilter")
    public ResponseEntity<ResponseGetAllJobDto> mainFilter(
            @RequestParam(required = false) List<String> companyName,
            @RequestParam(required = false) List<String>  jobLocation,
            @RequestParam(required = false) List<String>  salary,
            @RequestParam(required = false) List<String>  experienceLevel

            ) {
        try {
            FilterDto filterDto = new FilterDto(companyName, jobLocation, salary, experienceLevel);
            List<JobDto> listOfJob = filterService.mainFilter(filterDto);
            ResponseGetAllJobDto responseGetAllJobDto = new ResponseGetAllJobDto("success");
            responseGetAllJobDto.setList(listOfJob);
            return ResponseEntity.status(HttpStatus.OK).body(responseGetAllJobDto);
        }catch (NoMatchingResultFound e){
            ResponseGetAllJobDto responseGetAllJobDto = new ResponseGetAllJobDto("unsuccess");
            responseGetAllJobDto.setException("No Matching Data Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGetAllJobDto);
        }
    }

    @GetMapping("/ascendFilter")
    public ResponseEntity<ResponseGetAllJobDto> searchByFilterAndSort(
            @RequestParam(required = false) List<String> companyName,
            @RequestParam(required = false) List<String>  jobLocation,
            @RequestParam(required = false) List<String>  salary,
            @RequestParam(required = false) List<String>  experienceLevel,
            @RequestParam(required = false) String sortDirection,
            @RequestParam(required = false) String sortField
    ) {
        FilterDto filterDto = new FilterDto(companyName, jobLocation, salary,experienceLevel);

        try {
            List<JobDto> listOfJob = filterService.searchByFilterAndSort(filterDto, sortField, sortDirection);
            ResponseGetAllJobDto responseGetAllJobDto = new ResponseGetAllJobDto("success");
            responseGetAllJobDto.setList(listOfJob);
            return ResponseEntity.status(HttpStatus.OK).body(responseGetAllJobDto);
        } catch (JobNotFoundException jobNotFoundException) {
            ResponseGetAllJobDto responseGetAllJobDto = new ResponseGetAllJobDto("unsuccess");
            responseGetAllJobDto.setException("No Matching Data Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGetAllJobDto);
        }catch (NoMatchingResultFound e){
            ResponseGetAllJobDto responseGetAllJobDto = new ResponseGetAllJobDto("unsuccess");
            responseGetAllJobDto.setException("No Matching Data Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGetAllJobDto);
        }
    }

}
