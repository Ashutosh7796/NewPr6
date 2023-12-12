package com.example.Project06.Service;

import com.example.Project06.Dto.JobSave.GetSingleJobSave;

import java.util.List;


public interface JobSaveService {

    String saveJob(Integer userId, Integer jobId);
    public GetSingleJobSave getsavedjobbyId(Integer jobSaveId);

    public List<GetSingleJobSave> getSavedJobs(Integer userId);

    public String deleteSavedJobById(Integer jobSaveId);

}
