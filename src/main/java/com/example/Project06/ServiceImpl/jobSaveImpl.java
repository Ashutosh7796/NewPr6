package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.Event.GetSingleEventDto;
import com.example.Project06.Dto.GetSingleBlogDto;
import com.example.Project06.Dto.JobSave.GetSingleJobSave;
import com.example.Project06.Dto.JobSave.JobSaveDto;
import com.example.Project06.Entity.*;
import com.example.Project06.Repository.JobRepository;
import com.example.Project06.Repository.JobSaveRepo;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.JobSaveService;
import com.example.Project06.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class jobSaveImpl implements JobSaveService {

    private final UserRepository userRepository;

    private  final JobSaveRepo jobSaveRepo;

    private final JobRepository jobRepository;

    @Override
    public String saveJob(Integer userId, Integer jobId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            Optional<Job> jobOptional = jobRepository.findById(jobId);

            if (jobOptional.isPresent()) {
                Job job = jobOptional.get();

                if (hasUserAppliedForJob(userId, job)) {
                    throw new JobSavedAlreadyException("User with id " + user.getUser_id() +
                            " has already saved this job");
                }

                JobSave jobSave = new JobSave();
                jobSave.setUserId(userId);
                jobSave.setJobId(jobId);
                jobSaveRepo.save(jobSave);

                return "Saved Successfully";
            } else {
                throw new JobNotFoundException("Job not found with ID: " + jobId);
            }
        } else {
            throw new UserNotFoundExceptions("User not found with ID: " + userId);
        }
    }

    private boolean hasUserAppliedForJob(Integer userId, Job job) {
        return jobSaveRepo.existsByUserIdAndJobId(userId, job.getJobId());
    }

    @Override
    public GetSingleJobSave getsavedjobbyId(Integer jobSaveId) {
        Optional<JobSave> save = jobSaveRepo.findById(jobSaveId);

        if(save.isEmpty())
        {
            throw new NoSavedJobFoundException("No Saved Job Found by id ");
        }
        GetSingleJobSave saved = new GetSingleJobSave(save.get());
        return saved;
    }

    @Override
    public List<GetSingleJobSave> getSavedJobs(Integer userId) {
        List<JobSave> listOfEventsByStatus = jobSaveRepo.findByUserId(userId);

        if (listOfEventsByStatus.isEmpty()) {
            throw new NoSavedJobFoundException("No Saved Job found", HttpStatus.NOT_FOUND);
        }

        return listOfEventsByStatus.stream()
                .map(jobs -> new GetSingleJobSave(
                        jobs.getUserId(),
                        jobs.getJobId()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public String deleteSavedJobById(Integer jobSaveId) {
        jobSaveRepo.findById(jobSaveId).orElseThrow(() -> new RuntimeException("No Saved Job found By Id"));
        jobSaveRepo.deleteById(jobSaveId);
        return "Job Removed From Saved List Successfully ";
    }
}


