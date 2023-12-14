package com.example.Project06.Service;




import com.example.Project06.Dto.StudentApplication.GetStudentApplicationDto;
import com.example.Project06.Dto.StudentApplication.StudentApplicationDto;

import java.util.List;

public interface StudentApplicationService {


    public String AddStudentApplication(StudentApplicationDto studentApplicationDto, Integer userId);

    public List<StudentApplicationDto> getByUserId(Integer userId);

    public String UpdateStudentApp (StudentApplicationDto studentApplicationDto, Integer userId, Integer studentApplicationsId);

    public List<StudentApplicationDto> getByJobId(Integer jobId);

    public String deleteStudentApplication(Integer studentApplicationsId);
}
