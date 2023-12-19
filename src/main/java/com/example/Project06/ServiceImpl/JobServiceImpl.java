package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.ItTraining.ItTrainingDTO;
import com.example.Project06.Dto.ItTrianningBooking.ItTrianningBookingDto;
import com.example.Project06.Dto.Job.JobDto;
import com.example.Project06.Entity.*;
import com.example.Project06.Repository.JobRepository;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.JobService;
import com.example.Project06.exception.JobNotFoundException;
import com.example.Project06.exception.NoSavedJobFoundException;
import com.example.Project06.exception.UserNotFoundExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    private final UserRepository userRepository;
    private static final String CLEARBIT_LOGO_API = "https://logo.clearbit.com/";



    @Override
    public String AddJob(JobDto jobDto) {
        String logo = CLEARBIT_LOGO_API + jobDto.getLogo().toLowerCase().replace(" ", "") + ".com";
        User user = userRepository.findById(jobDto.getUser_Id()).orElseThrow(() -> new UserNotFoundExceptions("User Not found", HttpStatus.NOT_FOUND));
        Job job = new Job(jobDto,logo);

        job.setUserUser(user);

        jobRepository.save(job);
        return "Job Added";
    }


    @Override
    public JobDto findById(Integer JobId) {
        Optional<Job> job = jobRepository.findById(JobId);
        if (job.isEmpty()) {
            throw new JobNotFoundException("Job not found", HttpStatus.NOT_FOUND);
        }
        JobDto jobDto = new JobDto(job.get());
        jobDto.setJobId(JobId);

        return jobDto;
    }

    public Optional<Job> findjobById(Integer JobId) {
        Job job = jobRepository.findByJobId(JobId);
        if (job == null) {
            throw new JobNotFoundException("Job not found", HttpStatus.NOT_FOUND);
        }

        return Optional.of(job);
    }
    @Override
    public String deleteById(Integer JobId) {
        return null;
    }

    @Override
    public List<JobDto> getJobsByStatus(String status) {
        List<Job> jobbystatus = jobRepository.getJobsByStatus(status);
        return jobbystatus.stream()
                .map(JobDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<JobDto> getByUserId(Integer userId) {



        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            throw new UserNotFoundExceptions("User Not Found");
        }

        User user = userOptional.get();
        List<Job> jobs = jobRepository.findByUserUser(user);

        if (jobs.isEmpty()) {
            throw new NoSavedJobFoundException("No Applications Found for the specified student ID");
        }

        return jobs.stream()
                .map(JobDto::new)
                .collect(Collectors.toList());
    }

    public String updateJobFields(JobDto jobDto, Integer JobId) {
        Job job = jobRepository.findById(JobId).orElseThrow(() -> new JobNotFoundException("Job not found", HttpStatus.NOT_FOUND));
        if (jobDto.getCompanyName() != null) {
            job.setCompanyName(jobDto.getCompanyName());
        }
        if (jobDto.getPostName() != null){
               job.setPostName(jobDto.getPostName());
        }
        if (jobDto.getJobLocation()!= null){
            job.setJobLocation(job.getJobLocation());

        }
        if( jobDto.getAddress()!= null){
            job.setAddress(job.getAddress());

        }
         if(jobDto.getSkills()!=null){
              job.setSkills(job.getSkills());
         }
         if (jobDto.getJobDescription()!=null){
             job.setJobDescription(job.getJobDescription());

         }

        if (jobDto.getPostDate() != null) {
            job.setPostDate(jobDto.getPostDate());
        }

        if (jobDto.getSalary() != null) {
            job.setSalary(jobDto.getSalary());
        }

        if (jobDto.getNoOfPost() != null) {
            job.setNoOfPost(jobDto.getNoOfPost());
        }

        if (jobDto.getLogo() != null) {
            job.setLogo(jobDto.getLogo());
        }

        if (jobDto.getExperienceLevel() != null) {
            job.setExperienceLevel(jobDto.getExperienceLevel());
        }

        if (jobDto.getJobType() != null) {
            job.setJobType(jobDto.getJobType());
        }

        if (jobDto.getStatus() != null) {
            job.setStatus(jobDto.getStatus());
        }

        if (jobDto.getIncentives() != null) {
            job.setIncentives(jobDto.getIncentives());
        }

        if (jobDto.getEssentialRequirements() != null) {
            job.setEssentialRequirements(jobDto.getEssentialRequirements());
        }

        if (jobDto.getSeatNo() != null) {
            job.setSeatNo(jobDto.getSeatNo());
        }
        jobRepository.save(job);
        return "Job fields updated successfully";
    }

    @Override
    public List<JobDto> getAlljob() {
        List<Job> jobs = jobRepository.findAll(Sort.by(Sort.Direction.DESC, "jobId"));
        return jobs.stream()
                .map(JobDto::new)
                .collect(Collectors.toList());
    }
}
