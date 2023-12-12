package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.StudentApp.StudentApplicationDto;
import com.example.Project06.Repository.JobRepository;
import com.example.Project06.Repository.StudentApplicationRepo;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.StudentApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentApplicationServiceImpl implements StudentApplicationService {


    private final StudentApplicationRepo studentApplicationRepo;

    private final UserRepository userRepository;

    private final JobRepository jobRepository;

    @Override
    public String AddStudentApplication(StudentApplicationDto studentApplicationDto) {
        return null;
    }

    @Override
    public List<StudentApplicationDto> getByUserId(Integer UserId) {
        return null;
    }

    @Override
    public String UpdateStudentApp(StudentApplicationDto studentApplicationDto) {
        return null;
    }

    @Override
    public List<StudentApplicationDto> getByJobId(Integer jobId) {
        return null;
    }

    @Override
    public String deleteStudentApplication(Integer StudentApplicationId) {
        return null;
    }
}
