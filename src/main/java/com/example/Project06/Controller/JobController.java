package com.example.Project06.Controller;

import com.example.Project06.Dto.Job.JobDto;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Service.JobService;
import com.example.Project06.exception.JobNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/job")
@RestController
@RequiredArgsConstructor
public class JobController {


    private final JobService jobService;

    @PostMapping(value = "/add")
    public ResponseEntity<ResponseDto> jobadded(@RequestBody JobDto jobDto) {
        try {
            String result = jobService.AddJob(jobDto);
            return (ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", result)));
        } catch (JobNotFoundException jobNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", "job Not found"));

        }
    }
}
