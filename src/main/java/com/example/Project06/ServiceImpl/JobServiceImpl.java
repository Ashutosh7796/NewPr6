package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.Job.JobDto;
import com.example.Project06.Entity.Job;
import com.example.Project06.Entity.User;
import com.example.Project06.Repository.JobRepository;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.JobService;
import com.example.Project06.exception.UserNotFoundExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public JobDto findById(Integer JobId) {
        return null;
    }

    @Override
    public String deleteById(Integer JobId) {
        return null;
    }
}
