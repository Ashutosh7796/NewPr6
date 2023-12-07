package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.FilterDto;
import com.example.Project06.Dto.Job.JobDto;
import com.example.Project06.Entity.Job;
import com.example.Project06.Repository.JobRepository;
import com.example.Project06.Service.FilterService;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService {

    private final JobRepository jobRepository;
    @Override
    public List<JobDto> mainFilter(FilterDto filterDto) {
        Specification<Job> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filterDto.getJobLocation() != null && !filterDto.getJobLocation().isEmpty()) {
                predicates.add(criteriaBuilder.trim(root.get("jobLocation")).in(filterDto.getJobLocation()));
            }
            if (filterDto.getCompanyName() != null && !filterDto.getCompanyName().isEmpty()) {
                predicates.add(criteriaBuilder.trim(root.get("companyName")).in(filterDto.getCompanyName()));
            }
            if (filterDto.getSalary() != null && !filterDto.getSalary().isEmpty()) {
                predicates.add(criteriaBuilder.trim(root.get("salary")).in(filterDto.getSalary()));
            }
            if (filterDto.getExperienceLevel() != null && !filterDto.getExperienceLevel().isEmpty()) {
                predicates.add(criteriaBuilder.trim(root.get("experienceLevel")).in(filterDto.getExperienceLevel()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };


        List<Job> filteredJobs = jobRepository.findAll(spec);

        List<JobDto> listOfJobDtos = new ArrayList<>();
        for (Job job : filteredJobs) {
            JobDto jobDto = new JobDto(job);
            listOfJobDtos.add(jobDto);
        }

        return listOfJobDtos;
    }
}
