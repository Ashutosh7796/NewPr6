package com.example.Project06.Dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@ToString
public class FilterDto {

    private List<String> companyName;


    private List<String> jobLocation;

    private List<String> salary;

    private List<String> experienceLevel;



    public FilterDto(List<String> companyName, List<String> jobLocation, List<String> salary,List<String> experienceLevel) {
        this.jobLocation = jobLocation;
        this.companyName = companyName;
        this.salary = salary;
        this.experienceLevel = experienceLevel;
    }
}
