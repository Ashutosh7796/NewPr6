package com.example.Project06.Service;

import com.example.Project06.Dto.ItTraining.ItTrainingDTO;
import com.example.Project06.Dto.LiveProject.LiveProjectDto;

import java.util.List;

public interface LiveProjectService {

    public String AddLiveProject(LiveProjectDto liveProjectDto);

    public LiveProjectDto GetById(Integer liveProjectID);

    public List<LiveProjectDto> GetAllLiveProject();

    public  String EditLiveProject(LiveProjectDto liveProjectDto, Integer liveProjectID);


    public String deleteLiveProject(Integer liveProjectID);
}
