package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.JobSave.GetSingleJobSave;
import com.example.Project06.Dto.StudentApplication.GetStudentApplicationDto;
import com.example.Project06.Dto.StudentApplication.StudentApplicationDto;
import com.example.Project06.Entity.*;
import com.example.Project06.Repository.JobRepository;
import com.example.Project06.Repository.StudentApplicationRepo;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.StudentApplicationService;
import com.example.Project06.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentApplicationServiceImpl implements StudentApplicationService {


    private final StudentApplicationRepo studentApplicationRepo;

    private final UserRepository userRepository;

    private final JobRepository jobRepository;


    @Override
    public String AddStudentApplication(StudentApplicationDto studentApplicationDto, Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundExceptions("User not found with id: " + userId);
        }

        Optional<Job> jobOptional = jobRepository.findById(studentApplicationDto.getJobId());
        if (jobOptional.isEmpty()) {
            throw new JobNotFoundException("Job not found with id: " + studentApplicationDto.getJobId());
        }

        User user = userOptional.get();
        Job job = jobOptional.get();
        if (hasUserAppliedForJob(user, job)) {
            throw new ApplicationAlreadyExistsException("User with id " + user.getUser_id() +
                    " has already applied for job");
        }

        StudentApplication studentApplication = new StudentApplication(studentApplicationDto);
        studentApplication.setUserUser(user);
        studentApplicationRepo.save(studentApplication);

        return "Application added successfully.";
    }

    private boolean hasUserAppliedForJob(User user, Job job) {
        return studentApplicationRepo.existsByUserUserAndJobId(user, job.getJobId());
    }

    @Override
    public List<StudentApplicationDto> getByUserId(Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            throw new UserNotFoundExceptions("User Not Found");
        }

        User user = userOptional.get();
        List<StudentApplication> savedApplications = studentApplicationRepo.findByUserUser(user);

        if (savedApplications.isEmpty()) {
            throw new NoSavedJobFoundException("No Applications Found for the specified student ID");
        }

        return savedApplications.stream()
                .map(StudentApplicationDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public String UpdateStudentApp(StudentApplicationDto studentApplicationDto, Integer userId, Integer studentApplicationsId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundExceptions("User Not Found", HttpStatus.NOT_FOUND));

        StudentApplication studentApplication = studentApplicationRepo.findById(studentApplicationsId)
                .orElseThrow(() -> new ApplicationNotFoundException("Student Application Not Found", HttpStatus.NOT_FOUND));

        if (!studentApplication.getUserUser().equals(user)) {
            throw new ApplicationNotFoundException("Student Application Not Found for the specified user", HttpStatus.NOT_FOUND);
        }

        if (studentApplicationDto.getDate() != null) {
            studentApplication.setDate(studentApplicationDto.getDate());
        }
        if (studentApplicationDto.getTime() != null) {
            studentApplication.setTime(studentApplicationDto.getTime());
        }
        if (studentApplicationDto.getRecruiterNote() != null) {
            studentApplication.setRecruiterNote(studentApplicationDto.getRecruiterNote());
        }
        if (studentApplicationDto.getStudentApplicationStatus() != null) {
            studentApplication.setStudentApplicationStatus(studentApplicationDto.getStudentApplicationStatus());
        }

        studentApplicationRepo.save(studentApplication);

        return "Student application details updated successfully.";
    }

    @Override
    public List<StudentApplicationDto> getByJobId(Integer jobId) {
        List<StudentApplication> applications = studentApplicationRepo.findByJobId(jobId);

        if (applications.isEmpty()) {
            throw new ApplicationNotFoundException("No applications found for Job ID: " + jobId);
        }

        return applications.stream()
                .map(StudentApplicationDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public String deleteStudentApplication(Integer StudentApplicationId) {
        studentApplicationRepo.findById(StudentApplicationId).orElseThrow(() -> new RuntimeException("No Application found By Id"));
        studentApplicationRepo.deleteById(StudentApplicationId);
        return "Application Deleted Successfully ";
    }
}
