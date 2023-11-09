package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.Job.JobDto;
import com.example.Project06.Entity.Job;
import com.example.Project06.Entity.User;
import com.example.Project06.Repository.JobRepository;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.JobService;
import com.example.Project06.exception.JobNotFoundException;
import com.example.Project06.exception.UserNotFoundExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public String updateJobFields(JobDto jobDto, Integer JobId) {
        return null;
    }

    @Override
    public List<JobDto> getAlljobsWithPages() {
        return null;
    }

    @Override
    public Optional<Job> findById(Integer JobId) {
        System.out.println("1");
        Job job = jobRepository.findByJobId(JobId);
        System.out.println("ok");
        if (job == null) {
            throw new JobNotFoundException("Job not found", HttpStatus.NOT_FOUND);
        }

        return Optional.of(job);
    }

    @Override
    public String deleteById(Integer JobId) {
        return null;
    }
}
