package com.example.Project06.Controller;


import com.example.Project06.Dto.BlogUpdateDto;
import com.example.Project06.Dto.Event.GetSingleEventDto;
import com.example.Project06.Dto.JobSave.GetSaveJobDTO;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Dto.StudentApplication.GetStudentApplicationDto;
import com.example.Project06.Dto.StudentApplication.StudentApplicationDto;
import com.example.Project06.Service.StudentApplicationService;
import com.example.Project06.exception.*;
import com.example.Project06.utils.BaseResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/studentApplication")
public class StudentApplicationController {

    private final StudentApplicationService studentApplicationService;

    @PostMapping("/AddApplication")
    public ResponseEntity<?> addStudentApplication (@RequestBody StudentApplicationDto studentApplicationDto, Integer userId) {
        try {
            String response = studentApplicationService.AddStudentApplication(studentApplicationDto, userId);
            return ResponseEntity.status(HttpStatus.OK).body(new BaseResponseDTO("Success", response));
        } catch (UserNotFoundExceptions e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponseDTO("Unsuccessful", e.getMessage()));
        }catch (JobNotFoundException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponseDTO("Unsuccessful", e.getMessage()));
        }catch (ApplicationAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponseDTO("Unsuccessful", e.getMessage()));
        }
    }
    @GetMapping("/getById")
    public ResponseEntity<?> getBlogById(@RequestParam Integer userId) {
        try {
            GetStudentApplicationDto responseDto = new GetStudentApplicationDto("Success");
            responseDto.setResponse(studentApplicationService.getByUserId(userId));
            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        } catch (NoSavedJobFoundException e) {
            BlogUpdateDto userupdateDTO = new BlogUpdateDto("Unsuccess");
            userupdateDTO.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userupdateDTO);
        }catch(UserNotFoundExceptions e) {
            BlogUpdateDto userupdateDTO = new BlogUpdateDto("Unsuccess");
            userupdateDTO.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userupdateDTO);
        }
    }
    @PatchMapping("/updateApplicationDetails")
    public ResponseEntity<?> updateDetails(@RequestBody StudentApplicationDto studentApplicationDto, @RequestParam Integer userId, @RequestParam Integer studentApplicationsId) {
        try {
            studentApplicationService.UpdateStudentApp(studentApplicationDto,userId, studentApplicationsId);
            BlogUpdateDto userUpdateDto = new BlogUpdateDto("success");
            userUpdateDto.setMessage("Application Details Updated Successfully");

            return ResponseEntity.status(HttpStatus.OK).body(userUpdateDto);
        } catch (ApplicationNotFoundException e) {
            BlogUpdateDto userUpdateDto = new BlogUpdateDto("Unsuccess");
            userUpdateDto.setException(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userUpdateDto);
        }catch (UserNotFoundExceptions e){
            BlogUpdateDto userUpdateDto = new BlogUpdateDto("Unsuccess");
            userUpdateDto.setException(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userUpdateDto);
        }
    }
    @GetMapping("/getByJobId")
    public ResponseEntity<?> getByJobId(@RequestParam Integer jobId) {
        try {
            GetStudentApplicationDto responseDto = new GetStudentApplicationDto("Success");
            responseDto.setResponse(studentApplicationService.getByJobId(jobId));
            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        } catch (ApplicationNotFoundException e) {
            BlogUpdateDto userupdateDTO = new BlogUpdateDto("Unsuccess");
            userupdateDTO.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userupdateDTO);
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCallById(@RequestParam Integer studentApplicationsId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", studentApplicationService.deleteStudentApplication(studentApplicationsId)));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", e.getMessage()));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", e.getMessage()));

        }
    }

}
