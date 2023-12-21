package com.example.Project06.Service;


import com.example.Project06.Dto.InterviewSchedule.InterviewScheduleDto;
import com.example.Project06.Entity.InterviewSchedule;

import java.util.List;

public interface InterviewScheduleService {

    InterviewSchedule scheduleInterview(InterviewScheduleDto interviewScheduleDto);

    void deleteInterviewScheduleById(Integer interviewScheduleId);

    List<InterviewScheduleDto> findByUserIdJobId (Integer userId, int jobId);
    InterviewScheduleDto getinterviewSchedule (int id);

    List <InterviewScheduleDto> findAllInterviews(int pageNo);

    List <InterviewScheduleDto> findInterviewByUSerId (Integer userId);
    List<InterviewScheduleDto> findInterviewsByStatus(String status, int pageNo);


}
