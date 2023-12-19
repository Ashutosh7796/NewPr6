package com.example.Project06.Controller;

import com.example.Project06.Dto.MentorScheduleDto.MentorScheduleDto;
import com.example.Project06.Dto.MentorScheduleDto.ResponseAllMentorBokScheduleDto;
import com.example.Project06.Dto.MentorScheduleDto.ResponseMentorBokScheduleSingleDto;
import com.example.Project06.Dto.ResponseDto;
import com.example.Project06.Dto.hr.HrDto;
import com.example.Project06.Dto.hr.ResponseAllHrDtos;
import com.example.Project06.Dto.hr.ResponseHrSingleDto;
import com.example.Project06.Service.IHr;
import com.example.Project06.Service.IMentorSchedule;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/mentorschedule")
@AllArgsConstructor
public class MentorScheduleController {
    private final IMentorSchedule iMentorSchedule;

    @PostMapping("/post")
    public ResponseEntity<?> saveBootcampDetails(@RequestBody MentorScheduleDto mentorScheduleDto)
    {
        try {

            iMentorSchedule.saveHrDetails(mentorScheduleDto);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success","mentor schedule details added"));

        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("unsuccess",e.getMessage()));

        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(Integer mentorScheduleId)
    {
        try {
            ResponseMentorBokScheduleSingleDto responseSingleDto = new ResponseMentorBokScheduleSingleDto("success");
            responseSingleDto.setResponse(iMentorSchedule.getBootcampDetailsById(mentorScheduleId));
            return ResponseEntity.status(HttpStatus.OK).body(responseSingleDto);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }

    @GetMapping("/getAllHrDetails")
    public ResponseEntity<?> getById() {
        try {
            ResponseAllMentorBokScheduleDto responseObjectDto = new ResponseAllMentorBokScheduleDto("success");
            responseObjectDto.setResponse(iMentorSchedule.getAllBootcampDetails());
            return ResponseEntity.status(HttpStatus.OK).body(responseObjectDto);
        }catch (RuntimeException e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateById(
            @RequestParam LocalDate date,
            @RequestParam String mode,
            @RequestParam String time,
            @RequestParam String payment,
            @RequestParam String status,
            @RequestParam Integer mentorBookingsId
    ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",iMentorSchedule.updateBootcampDetails(
                    date,mode,time,payment,status,mentorBookingsId
            )));
        }catch (RuntimeException e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteById( @RequestParam Integer mentorScheduleId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("success",iMentorSchedule.deleteById(mentorScheduleId)));
        }catch (RuntimeException e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto("unsuccess",e.getMessage()));
        }
    }

}
