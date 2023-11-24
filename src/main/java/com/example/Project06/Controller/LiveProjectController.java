package com.example.Project06.Controller;

import com.example.Project06.Dto.ItTraining.ItTrainingDTO;
import com.example.Project06.Dto.ItTraining.ResponseAllItTrainingDTO;
import com.example.Project06.Dto.LiveProject.LiveProjectDto;
import com.example.Project06.Dto.LiveProject.ResponseAllLiveProjectDto;
import com.example.Project06.Dto.LiveProject.ResponseSingleLiveProjectDto;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Entity.LiveProject;
import com.example.Project06.Service.LiveProjectService;
import com.example.Project06.exception.ItTrainingNotFoundException;
import com.example.Project06.exception.LiveProjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/LiveProject")
public class LiveProjectController {

    private  final LiveProjectService liveProjectService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> LiveProjectAdd(@RequestBody LiveProjectDto liveProjectDto)
    {
        try {
            String result = liveProjectService.AddLiveProject(liveProjectDto);
            return (ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",result)));
        }catch (LiveProjectNotFoundException liveProjectNotFoundException)
        {
            return (ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsucces","IT Training not found")));
        }
    }
    @GetMapping("/byID")
    public ResponseEntity<ResponseSingleLiveProjectDto> ItTrainingById(@RequestParam Integer liveProjectID){
        try {
            ResponseSingleLiveProjectDto responseSingleLiveProjectDto =new ResponseSingleLiveProjectDto("Success");
           LiveProjectDto liveProject = liveProjectService.GetById(liveProjectID);
            responseSingleLiveProjectDto.setObject(liveProject);
            return ResponseEntity.status(HttpStatus.OK).body(responseSingleLiveProjectDto);

        }catch (LiveProjectNotFoundException liveProjectNotFoundException)
        {
            ResponseSingleLiveProjectDto responseSingleLiveProjectDto =new ResponseSingleLiveProjectDto("unsuccess");
            responseSingleLiveProjectDto.setException("Live Project not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseSingleLiveProjectDto);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseAllLiveProjectDto> getAllItTraining() {
        try {
            ResponseAllLiveProjectDto responseAllLiveProjectDto = new ResponseAllLiveProjectDto("success");
            List<LiveProjectDto> liveProjects = liveProjectService.GetAllLiveProject();
            responseAllLiveProjectDto.setList(liveProjects);
            return ResponseEntity.status(HttpStatus.OK).body(responseAllLiveProjectDto);
        }catch (LiveProjectNotFoundException liveProjectNotFoundException)
        {
            ResponseAllLiveProjectDto responseAllLiveProjectDto =new ResponseAllLiveProjectDto("unsuccessful");
            responseAllLiveProjectDto.setException("Live Project not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseAllLiveProjectDto);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteItLiveProject(@RequestParam Integer liveProjectID) {
        try {
            String result = liveProjectService.deleteLiveProject(liveProjectID);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", result));
        } catch (LiveProjectNotFoundException liveProjectNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsucces", "Project not found"));
        }
    }

}
