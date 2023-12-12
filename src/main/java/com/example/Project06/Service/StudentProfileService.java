package com.example.Project06.Service;

import com.example.Project06.Dto.GetSingleBlogDto;
import com.example.Project06.Dto.HrCall.GetSingleHrCallDto;
import com.example.Project06.Dto.StudentProfileDto.GetSingleProfileDto;
import com.example.Project06.Dto.StudentProfileDto.StudentProfileDto;

import java.util.List;

public interface StudentProfileService {
    String AddProfile(StudentProfileDto studentProfileDto, Integer userId);
    public GetSingleProfileDto getProfileById(Integer userId);

    List<GetSingleProfileDto> getAllProfiles(int pageNo, int pageSize);
    public void updateProfileDetails (GetSingleProfileDto profileDto, Integer userId);

    public String deleteProfileById(Integer userId);


}
