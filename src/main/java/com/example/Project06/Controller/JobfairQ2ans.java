package com.example.Project06.Controller;

import com.example.Project06.Dto.JobfairQ2ans.*;
import com.example.Project06.Dto.ResponceDto;
import com.example.Project06.Dto.ResponseProfileLevelDto;
import com.example.Project06.Repository.UserRepository;
import com.example.Project06.Service.IJobfairQ2ans;
import com.example.Project06.exception.JobNotFoundException;
import com.example.Project06.exception.PageNotFoundException;
import com.example.Project06.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobFairQueAns")
@AllArgsConstructor
public class JobfairQ2ans {

    private final IJobfairQ2ans iJobfairQ2ans;
    private final UserRepository userRepository;
    @PostMapping("/addQ2ans")
    public ResponseEntity<?> addQ2ans(@RequestBody JobfairQ2ansDto jobfairQ2ansDto)
    {
        try {
            System.out.println();
            ResponseProfileLevelDto responseProfileLevelDto = new ResponseProfileLevelDto("success");
            responseProfileLevelDto.setResponse(iJobfairQ2ans.addQ2ans(jobfairQ2ansDto));
            return ResponseEntity.status(HttpStatus.OK).body(responseProfileLevelDto);

        }catch (UserNotFoundException userNotFoundException){
            ResponseProfileLevelDto responseProfileLevelDto = new ResponseProfileLevelDto("unsuccess");
            responseProfileLevelDto.setException(String.valueOf(userNotFoundException));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseProfileLevelDto);
        }catch (JobNotFoundException jobNotFoundException){
            ResponseProfileLevelDto responseProfileLevelDto = new ResponseProfileLevelDto("unsuccess");
            responseProfileLevelDto.setException(String.valueOf(jobNotFoundException));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseProfileLevelDto);
        }

    }
    @PostMapping("/saveAllJobFairques")
    public ResponseEntity<?> addAllJobFairques(@RequestBody List<JobfairQ2ansDto> listOfjobFairQueDto){
        try{
            System.out.println("1");
            ResponseOfAllJobFair2Ans responseOfAllJobFair2Ans = new ResponseOfAllJobFair2Ans("success");
            responseOfAllJobFair2Ans.setResponse(iJobfairQ2ans.addAllJobFairAns(listOfjobFairQueDto));
            System.out.println("2");
            return ResponseEntity.status(HttpStatus.OK).body(responseOfAllJobFair2Ans);

        }catch (Exception e){
            ResponceDto responceDto = new ResponceDto("unsuccess","Job Question not added");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responceDto);
        }
    }
    @GetMapping("/getQ2ans")
    public ResponseEntity<?> getQ2ans(@RequestParam Integer JobFairQ1AnsId)
    {

        try {
            System.out.println();
            ResponseJobFairQ2Dto responseProfileLevelDto = new ResponseJobFairQ2Dto("success");
            responseProfileLevelDto.setResponse(iJobfairQ2ans.getQ2ans(JobFairQ1AnsId));
            return ResponseEntity.status(HttpStatus.OK).body(responseProfileLevelDto);

        }catch (JobNotFoundException userNotFoundException){
            ResponseJobFairQ2Dto responseJobFairQ1Dto = new ResponseJobFairQ2Dto("unsuccess");
            responseJobFairQ1Dto.setException(String.valueOf(userNotFoundException));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseJobFairQ1Dto);
        }

    }
    @GetMapping("/getallQ2ans")
    public List<com.example.Project06.Entity.JobfairQ2ans> getallQ2ans()
    {

        return iJobfairQ2ans.getallQ2ans();
    }
    @DeleteMapping("/deleteQ2ans")
    public ResponseEntity<?> deleteQ2ans(@RequestParam Integer JobFairQ1AnsId)
    {
        try {
            System.out.println();
            ResponseProfileLevelDto responseProfileLevelDto = new ResponseProfileLevelDto("success");
            responseProfileLevelDto.setResponse(iJobfairQ2ans.deleteQ2ans(JobFairQ1AnsId));
            return ResponseEntity.status(HttpStatus.OK).body(responseProfileLevelDto);

        }catch (JobNotFoundException userNotFoundException){
            ResponseProfileLevelDto responseProfileLevelDto = new ResponseProfileLevelDto("unsuccess");
            responseProfileLevelDto.setException(String.valueOf(userNotFoundException));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseProfileLevelDto);
        }

    }
    @DeleteMapping("/deleteallQ2ans")
    public String deleteallQ2ans()
    {
        iJobfairQ2ans.deleteallQ2ans();

        return "All data deleted";
    }
    @GetMapping("/getJobFairDetailsByUserId")
    public ResponseEntity<?> getJobFairDetailsByUserId(@RequestParam Integer userId){
        try {
            ResponseForJobFairTwoUserId responseForJobFairTwoUserId = new ResponseForJobFairTwoUserId("success");
            responseForJobFairTwoUserId.setResponse(iJobfairQ2ans.getJobFairDetailsByUserId(userId));
            return ResponseEntity.status(HttpStatus.OK).body(responseForJobFairTwoUserId);

        }catch (UserNotFoundException userNotFoundException) {

            ResponseForJobFairTwoUserId responseForJobFairTwoUserId = new ResponseForJobFairTwoUserId("unsuccess");
            responseForJobFairTwoUserId.setException(String.valueOf(userNotFoundException));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseForJobFairTwoUserId);
        }
    }
    @GetMapping("/getByUserIdAndJobId")
    public ResponseEntity<?> getAllQ2AnsByUserIdAndJobId(@RequestParam Integer userId,@RequestParam Integer jobId)
    {
            try{
                ResponseAllJobFairQ2 responseAllJobFairQ2 = new ResponseAllJobFairQ2("success");
                responseAllJobFairQ2.setResponse(iJobfairQ2ans.getByUserIdAndJobId(userId,jobId));
                return ResponseEntity.status(HttpStatus.OK).body(responseAllJobFairQ2) ;

            }catch (PageNotFoundException pageNotFoundException){
                ResponseOfAllJobFair2Ans responseOfAllJobFair2Ans = new ResponseOfAllJobFair2Ans("unsuccess");
                responseOfAllJobFair2Ans.setResponse(String.valueOf(pageNotFoundException));
                return ResponseEntity.status(HttpStatus.OK).body(responseOfAllJobFair2Ans) ;
            }


    }
    @PatchMapping("/update")
    public ResponseEntity<?> UpdateQ2AnsByUserIdAndJobId(@RequestBody List<JobfairQ2ansDto> jobfairQ2ansDto)
    {
        try{
            ResponseOfAllJobFair2Ans responseOfAllJobFair2Ans = new ResponseOfAllJobFair2Ans("success");
            responseOfAllJobFair2Ans.setResponse(iJobfairQ2ans.UpdateQ2AnsByUserIdAndJobId(jobfairQ2ansDto));
            return ResponseEntity.status(HttpStatus.OK).body(responseOfAllJobFair2Ans) ;

        }catch (Exception e){
            ResponseOfAllJobFair2Ans responseOfAllJobFair2Ans = new ResponseOfAllJobFair2Ans("unsuccess");
            responseOfAllJobFair2Ans.setResponse(String.valueOf("details not updated"));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseOfAllJobFair2Ans) ;
        }


    }




}
