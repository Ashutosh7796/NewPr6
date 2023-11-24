package com.example.Project06.ServiceImpl;

import com.example.Project06.Dto.ItTraining.ItTrainingDTO;
import com.example.Project06.Dto.LiveProject.LiveProjectDto;
import com.example.Project06.Entity.ItTraining;
import com.example.Project06.Entity.LiveProject;
import com.example.Project06.Repository.LiveProjectRepo;
import com.example.Project06.Service.LiveProjectService;
import com.example.Project06.exception.ItTrainingNotFoundException;
import com.example.Project06.exception.LiveProjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LiveProjectServiceImpl implements LiveProjectService {


    private final LiveProjectRepo liveProjectRepo;
    @Override
    public String AddLiveProject(LiveProjectDto liveProjectDto) {
        LiveProject liveProject = new LiveProject(liveProjectDto);
        liveProjectRepo.save(liveProject);
        return "live Project added";
    }

    @Override
    public LiveProjectDto GetById(Integer liveProjectID) {
        Optional<LiveProject> liveProject= liveProjectRepo.findById(liveProjectID);
        if (liveProject.isEmpty()){
            throw new LiveProjectNotFoundException("Live Project not found", HttpStatus.NOT_FOUND);
        }
        LiveProjectDto liveProjectDto = new LiveProjectDto(liveProject.get());
        liveProjectDto.setLiveProjectID(liveProjectID);
        return liveProjectDto;

    }

    @Override
    public List<LiveProjectDto> GetAllLiveProject() {
        List<LiveProject> liveProjects = liveProjectRepo.findAll();
        return liveProjects.stream()
                .map(LiveProjectDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public String EditLiveProject(LiveProjectDto liveProjectDto, Integer liveProjectID) {
        return null;
    }

    @Override
    public String deleteLiveProject(Integer liveProjectID) {
        LiveProjectDto exitLiveProject = GetById(liveProjectID);

        if(exitLiveProject== null ){
            throw new ItTrainingNotFoundException("live Project ID:"+liveProjectID + "not found");
        }
        liveProjectRepo.deleteById(liveProjectID);
        return "live Project ID:"+ liveProjectID + "has been deleted successfully";

    }
    }

