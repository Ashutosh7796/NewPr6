package com.example.Project06.Controller;

import com.example.Project06.Dto.Job.JobDto;
import com.example.Project06.Dto.Job.ResponseSingleJobDto;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Entity.Job;
import com.example.Project06.Service.JobService;
import com.example.Project06.exception.JobNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/getJob")
    public ResponseEntity<ResponseSingleJobDto> FindJobById(@RequestParam int JobId) {
        try {
            ResponseSingleJobDto responseSingleJobDto = new ResponseSingleJobDto("success");
             Optional<Job> job = jobService.findById(JobId);
            responseSingleJobDto.setObject(job);
            return ResponseEntity.status(HttpStatus.OK).body(responseSingleJobDto);
        } catch (JobNotFoundException jobNotFoundException) {
            ResponseSingleJobDto responseSingleJobDto = new ResponseSingleJobDto("unsuccess");
            responseSingleJobDto.setException("Job not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseSingleJobDto);
        }
    }

}
