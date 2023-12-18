package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.FilterDto;
import com.example.Project06.Dto.Job.JobDto;
import com.example.Project06.Entity.Job;
import com.example.Project06.Repository.JobRepository;
import com.example.Project06.Service.FilterService;
import com.example.Project06.exception.JobNotFoundException;
import com.example.Project06.exception.NoMatchingResultFound;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

        if (filteredJobs.isEmpty()) {
            throw new NoMatchingResultFound("No Matching Data Found");
        }

        List<JobDto> listOfJobDtos = new ArrayList<>();
        for (Job job : filteredJobs) {
            JobDto jobDto = new JobDto(job);
            listOfJobDtos.add(jobDto);
        }

        return listOfJobDtos;
    }

    @Override
    public List<JobDto> searchByFilterAndSort(FilterDto filterDto, String sortField, String sortDirection) {
        Specification<Job> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filterDto.getJobLocation() != null && !filterDto.getJobLocation().isEmpty()) {
                predicates.add(root.get("jobLocation").in(filterDto.getJobLocation()));
            }
            if (filterDto.getCompanyName() != null && !filterDto.getCompanyName().isEmpty()) {
                predicates.add(root.get("companyName").in(filterDto.getCompanyName()));
            }
            if (filterDto.getSalary() != null && !filterDto.getSalary().isEmpty()) {
                predicates.add(root.get("Salary").in(filterDto.getSalary()));
            }
            if (filterDto.getExperienceLevel() != null && !filterDto.getExperienceLevel().isEmpty()) {
                predicates.add(root.get("experienceLevel").in(filterDto.getExperienceLevel()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        List<Job> filteredJobs = jobRepository.findAll(spec);

        if (filteredJobs.isEmpty()) {
            throw new NoMatchingResultFound("No Matching Data Found");
        }
        List<JobDto> listOfJobDtos = filteredJobs.stream()
                .map(JobDto::new)
                .collect(Collectors.toList());

        if (listOfJobDtos.isEmpty()) {
            throw new JobNotFoundException("No Matching Data Found");
        }

        Comparator<JobDto> comparator = Comparator.comparing(JobDto::getCompanyName);
        if ("jobLocation".equals(sortField)) {
            comparator = Comparator.comparing(JobDto::getJobLocation);
        } else if ("companyName".equals(sortField)) {
            comparator = Comparator.comparing(JobDto::getCompanyName);
        } else if ("Salary".equals(sortField)) {
            comparator = Comparator.comparing(JobDto::getSalary);
        } else if ("ExperienceLevel".equals(sortField)) {
            comparator = Comparator.comparing(JobDto::getExperienceLevel);
        }

        if ("desc".equalsIgnoreCase(sortDirection)) {
            comparator = comparator.reversed();
        }

        return listOfJobDtos.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

}
