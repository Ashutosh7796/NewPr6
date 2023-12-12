package com.example.Project06.Service;



import com.example.Project06.Dto.StudentApp.StudentApplicationDto;

import java.util.List;

public interface StudentApplicationService {


    public String AddStudentApplication(StudentApplicationDto studentApplicationDto);

    public List<StudentApplicationDto> getByUserId(Integer UserId);

    public String UpdateStudentApp (StudentApplicationDto studentApplicationDto);

    public List<StudentApplicationDto> getByJobId(Integer jobId);

    public String deleteStudentApplication(Integer StudentApplicationId);
}
