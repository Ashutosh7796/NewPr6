package com.example.Project06.Controller;

import com.example.Project06.Dto.BlogDto;
import com.example.Project06.Dto.BlogUpdateDto;
import com.example.Project06.Dto.JobSave.GetSaveJobDTO;
import com.example.Project06.Dto.JobSave.GetSingleJobSave;
import com.example.Project06.Dto.JobSave.JobSaveDto;
import com.example.Project06.Dto.JobSave.ResponseAllSavedJobDto;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Dto.SingleBlogDto;
import com.example.Project06.Service.JobSaveService;
import com.example.Project06.exception.*;
import com.example.Project06.utils.BaseResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/save")
@RequiredArgsConstructor
public class JobSaveController {

    private final JobSaveService jobSaveService;

    @PostMapping(value = "/saveJob")
    public ResponseEntity<BaseResponseDTO> saveTheJob(@RequestParam Integer userId, @RequestParam Integer jobId) {
        try {
            String response = jobSaveService.saveJob(userId, jobId);
            return ResponseEntity.status(HttpStatus.OK).body(new BaseResponseDTO("Success", response));
        } catch (UserNotFoundExceptions e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponseDTO("Unsuccessful", e.getMessage()));
        }catch (JobNotFoundException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponseDTO("Unsuccessful", e.getMessage()));
        }catch (JobSavedAlreadyException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponseDTO("Unsuccessful", e.getMessage()));
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getBlogById(@RequestParam Integer jobSaveId) {
        try {
            GetSaveJobDTO responseDto = new GetSaveJobDTO("Success");
            responseDto.setResponse(jobSaveService.getsavedjobbyId(jobSaveId));
            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        } catch (NoSavedJobFoundException e) {
            BlogUpdateDto userupdateDTO = new BlogUpdateDto("Unsuccess");
            userupdateDTO.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userupdateDTO);

        }
    }

    @GetMapping("/getsavedjobByUserId")
    public ResponseEntity<ResponseAllSavedJobDto> getSavedJobs(Integer userId) {

        try {
            List<GetSingleJobSave> listOfJobsByStatus = jobSaveService.getSavedJobs(userId);
            ResponseAllSavedJobDto responseGetAllEventDto = new ResponseAllSavedJobDto("success");
            responseGetAllEventDto.setList(listOfJobsByStatus);
            return ResponseEntity.status(HttpStatus.OK).body(responseGetAllEventDto);
        } catch ( NoSavedJobFoundException e) {
            ResponseAllSavedJobDto responseGetAllJobDto = new ResponseAllSavedJobDto("unsuccess");
            responseGetAllJobDto.setException("No Saved Job found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseGetAllJobDto);
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCallById(@RequestParam Integer jobSaveId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", jobSaveService.deleteSavedJobById(jobSaveId)));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", e.getMessage()));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", e.getMessage()));
        }
    }


}
