package com.example.Project06.Service;

import com.example.Project06.Dto.GetSingleBlogDto;
import com.example.Project06.Dto.HrCall.GetSingleHrCallDto;
import com.example.Project06.Dto.HrCall.HrCallDto;
import java.util.List;

public interface HrCallService {
    String AddHrCall(HrCallDto hrCallDto, Integer hrId);

    List <GetSingleHrCallDto> getCallByUserId(Integer userId);

    public GetSingleHrCallDto getHrCallById(Integer hrCallId);

    List<GetSingleHrCallDto> getAllHrCalls(int pageNo, int pageSize);

    public String deleteCallById(Integer hrCallId);
}
