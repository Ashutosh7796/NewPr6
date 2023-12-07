package com.example.Project06.Controller;

import com.example.Project06.Dto.BlogUpdateDto;
import com.example.Project06.Dto.Event.EventUpdateDto;
import com.example.Project06.Dto.GetSingleBlogDto;
import com.example.Project06.Dto.HrCall.GetSingleHrCallDto;
import com.example.Project06.Dto.HrCall.ResponseAllHrCallDto;
import com.example.Project06.Dto.HrCall.SingleHrCallDto;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Dto.StudentProfileDto.GetSingleProfileDto;
import com.example.Project06.Dto.StudentProfileDto.ResponseAllProfileDto;
import com.example.Project06.Dto.StudentProfileDto.SingleProfileDto;
import com.example.Project06.Dto.StudentProfileDto.StudentProfileDto;
import com.example.Project06.Service.StudentProfileService;
import com.example.Project06.exception.BlogNotFoundException;
import com.example.Project06.exception.HrCallNotFoundException;
import com.example.Project06.exception.PageNotFoundException;
import com.example.Project06.utils.BaseResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/StudentProfile")
@RequiredArgsConstructor
public class StudentProfileController {

    private final StudentProfileService studentProfileService;
    @PostMapping(value = "/AddProfile")
    public ResponseEntity<BaseResponseDTO> addProfile(@RequestBody StudentProfileDto studentProfileDto, Integer userId) {
        try {
            String response = studentProfileService.AddProfile(studentProfileDto, userId);
            return ResponseEntity.status(HttpStatus.OK).body(new BaseResponseDTO("Success", response));
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BaseResponseDTO("Unsuccessful", e.getMessage()));
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getProfileById(@RequestParam Integer userId) {
        try {
            SingleProfileDto responseDto = new SingleProfileDto("Success");
            responseDto.setResponse(studentProfileService.getProfileById(userId));
            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        } catch (RuntimeException e) {
            EventUpdateDto hrdto = new EventUpdateDto("Unsuccess");
            hrdto.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hrdto);

        }
    }
    @GetMapping("/getAllProfiles")
    public ResponseEntity<ResponseAllProfileDto> getAllHrCalls(@RequestParam int pageNo,
                                                              @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        try {
            List<GetSingleProfileDto> calls = studentProfileService.getAllProfiles(pageNo, pageSize);
            ResponseAllProfileDto responseAllCompnayDto = new ResponseAllProfileDto("Success");
            responseAllCompnayDto.setList(calls);
            return ResponseEntity.status(HttpStatus.OK).body(responseAllCompnayDto);
        } catch (PageNotFoundException e) {
            ResponseAllProfileDto dto = new ResponseAllProfileDto("Unsuccess");
            dto.setException("Page Not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
        }
    }
    @PatchMapping("/updateProfileDetails")
    public ResponseEntity<?> updateDetails(@RequestBody GetSingleProfileDto profileDto, Integer userId) {
        try {
            studentProfileService.updateProfileDetails(profileDto, userId);
            BlogUpdateDto userupdateDTO = new BlogUpdateDto("success");
            userupdateDTO.setMessage("Profile Details Updated Successfully");

            return ResponseEntity.status(HttpStatus.OK).body(userupdateDTO);
        } catch (RuntimeException e) {
            BlogUpdateDto userupdateDTO = new BlogUpdateDto("Unsuccess");
            userupdateDTO.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userupdateDTO);

        }
    }

    @DeleteMapping("/deleteProfile")
    public ResponseEntity<?> deleteProfileById(@RequestParam Integer userId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success", studentProfileService.deleteProfileById(userId)));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", e.getMessage()));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess", e.getMessage()));
        }
    }
}
