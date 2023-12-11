package com.example.Project06.Service;

import com.example.Project06.Dto.FilterDto;
import com.example.Project06.Dto.Job.JobDto;


import java.util.List;

public interface FilterService {
    public List<JobDto> mainFilter(FilterDto filterDto);

    public List<JobDto> searchByFilterAndSort(FilterDto filterDto, String sortField, String sortDirection);

}
